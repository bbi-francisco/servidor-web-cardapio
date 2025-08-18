package web_cardapio.br.com.bitbyte.models;


public class Retorno<T> {

    private T value;
    private int status;
    private String msg;

    public T getValue() {
        return value;
    }

    public Retorno<T> setValue(T value) {
        this.value = value;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Retorno<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg != null ? msg : "";
    }

    public Retorno<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
