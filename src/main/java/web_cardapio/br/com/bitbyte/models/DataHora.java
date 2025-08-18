package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public final class DataHora
{
    private String hora;
    private String data;
    
    public String getHora()
    {
        return StringUtils.getEmptyIfNull(hora);
    }

    public DataHora setHora(String hora)
    {
        this.hora = hora;
        return this;
    }

    public String getData()
    {
        return StringUtils.getEmptyIfNull(data);
    }

    public DataHora setData(String data)
    {
        this.data = data;
        return this;
    }
}
