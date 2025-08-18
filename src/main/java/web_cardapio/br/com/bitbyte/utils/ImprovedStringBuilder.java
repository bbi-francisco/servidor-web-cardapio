package web_cardapio.br.com.bitbyte.utils;

public class ImprovedStringBuilder implements CharSequence{
    
    private StringBuilder sb;
    private String jumpCharacter;
    private boolean jumpBeforeAppends;
    private boolean jumpAfterEachAppend;
    
    public ImprovedStringBuilder(){
        this("");
    }
    
    public ImprovedStringBuilder(String value){
        sb = new StringBuilder(StringUtils.getEmptyIfNull(value));
        jumpCharacter = System.lineSeparator();
    }
    
    public ImprovedStringBuilder(Object value){
        this(String.valueOf(value != null ? value : ""));
    }
    
    public ImprovedStringBuilder append(Object value){
        if(value != null){
            append(String.valueOf(value));
        }
        return this;
    }
    
    public ImprovedStringBuilder appendWithSpace(Object value){
        if(value != null){
            append(String.valueOf(value));
            append(" ");
        }
        return this;
    }
    
    public ImprovedStringBuilder spaceAndAppend(Object value){
        if(value != null){
            append(" ");
            append(String.valueOf(value));
        }
        return this;
    }
    
    public ImprovedStringBuilder append(String value){
        if(jumpBeforeAppends){
            jump();
        }
        sb.append(StringUtils.getEmptyIfNull(value));
        if(jumpAfterEachAppend){
            jump();
        }
        return this;
    }
    
    public ImprovedStringBuilder jump(int times){
        while(times > 0){
            jump();
            times--;
        }
        return this;
    }
    
    public ImprovedStringBuilder jump(){
        sb.append(jumpCharacter);
        return this;
    }
    
    public ImprovedStringBuilder appendAndJump(String value){
        append(value);
        jump();
        return this;
    }
    
    public ImprovedStringBuilder appendAndJump(Number value){
        if(value != null){
            appendAndJump(String.valueOf(value));
        }
        return this;
    }
    
    public ImprovedStringBuilder jumpAndAppend(String value){
        jump();
        append(value);
        return this;
    }
    
    public ImprovedStringBuilder jumpAndAppend(Object value){
        if(value != null){
            jumpAndAppend(String.valueOf(value));
        }
        return this;
    }

    public void jumpBeforeEachAppend(boolean jumpBeforeEachAppend) {
        this.jumpBeforeAppends = jumpBeforeEachAppend;
    }

    public void jumpAfterEachAppend(boolean jumpAfterEachAppend) {
        this.jumpAfterEachAppend = jumpAfterEachAppend;
    }
    
    public String build(){
        String value = sb.toString();
        clean();
        
        return value;
    }
    
    @Override
    public String toString(){
        return build();
    }
    
    private void clean(){
        this.sb = new StringBuilder();
        jumpBeforeAppends = false;
        jumpAfterEachAppend = false;
    }

    @Override
    public int length() {
        return sb.length();
    }

    @Override
    public char charAt(int index) {
        return sb.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return sb.subSequence(start, end);
    }
    
    public ImprovedStringBuilder appendAll(Object... strings){
        if(strings == null || strings.length == 0){
            return this;
        }
        for(Object string : strings){
            append(string);
        }
        return this;
    }
}
