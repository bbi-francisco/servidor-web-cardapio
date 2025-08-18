package web_cardapio.br.com.bitbyte.printers;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class StackTracePrinter {
    
    private static final String line = System.lineSeparator();
    
    public String printStackTrace(StackTraceElement[] stackTrace){
        if(stackTrace == null || stackTrace.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(StackTraceElement obj : stackTrace)
        {
            if(obj == null) continue;
            sb.append(obj.toString());
            sb.append(line);
        }
        String print = sb.toString();
        if(!StringUtils.isNullOrEmpty(print)){
            sb.append(line);
        }
        return sb.toString();
    }
    
    private StackTraceElement[] getMethods(StackTraceElement[] stackTraceArray, int levels){
        if(stackTraceArray == null) return new StackTraceElement[0];
        StackTraceElement[] stackTrace = new StackTraceElement[levels];
        for(int i = 0; i < levels; i++){
            if(i < stackTraceArray.length){
                stackTrace[i] = stackTraceArray[i];
            }else{
                break;
            }
        }
        return stackTrace;
    }
    
    public String printStackTraceWithLevels(StackTraceElement[] stackTrace, int levels){
        return printStackTrace(getMethods(stackTrace, levels));
    }
    
}

