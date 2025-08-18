package web_cardapio.br.com.bitbyte.error;

import web_cardapio.br.com.bitbyte.printers.StackTracePrinter;

/**
 * Expoe dados das excecoes para uso geral, como logs.
 * @author Francisco Oliveira
 */
public class ExceptionInfo 
{
    private Throwable throwable;
    private StackTracePrinter stackTracePrinter;
    
    public ExceptionInfo(Throwable throwable){
        this();
        this.throwable = throwable;  
    }
    
    public ExceptionInfo(){
        stackTracePrinter = new StackTracePrinter();
    }
    
    public ExceptionInfo setThrowable(Throwable throwable){
        this.throwable = throwable;
        return this;
    }
    
    public String printStackTrace(){
        if(throwable == null){
            return "";
        }
        return stackTracePrinter.printStackTrace(throwable.getStackTrace());
    }
    
    public String printStackTrace(int levels){
        return stackTracePrinter.printStackTraceWithLevels(throwable.getStackTrace(), levels);
    }
}
