package web_cardapio.br.com.bitbyte.log;

import web_cardapio.br.com.bitbyte.error.ExceptionInfo;
import web_cardapio.br.com.bitbyte.utils.ImprovedStringBuilder;
import web_cardapio.br.com.bitbyte.utils.StringUtils;

/**
 *
 * @author Francisco Oliveira
 */
public class LogBuilder {
    
    private String message;
    private Throwable throwable;
    private ExceptionInfo exceptionInfo;
    
    public LogBuilder(){
        exceptionInfo = new ExceptionInfo();
    }
    
    public LogBuilder setMessage(String message){
        this.message = message;
        return this;
    }
    
    public LogBuilder setThrowable(Throwable throwable){
        this.throwable = throwable;
        exceptionInfo.setThrowable(throwable);
        return this;
    }
    
    public String build()
    {
        ImprovedStringBuilder sb = new ImprovedStringBuilder();
        sb.jump();
        
        if(!StringUtils.isNullOrEmpty(message)){
            sb.append("Mensagem: ");
            sb.appendAndJump(message);
        }
        
        if(throwable != null){
            
            sb.append("Exception: ");
            sb.appendAndJump(throwable.toString());
            
            sb.append("StackTrace: ");
            sb.appendAndJump(exceptionInfo.printStackTrace());
        }
        
        clean();
        return sb.toString();
    }
    
    public String toString(){
        return build();
    }
    
    private void clean(){
        throwable = null;
        message = "";
        exceptionInfo = new ExceptionInfo();
    }
    
}

