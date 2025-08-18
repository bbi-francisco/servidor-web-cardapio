package web_cardapio.br.com.bitbyte.models.bbifood;

import web_cardapio.br.com.bitbyte.format.VariacaoFormatter;
import web_cardapio.br.com.bitbyte.interfaces.Identificavel;
import web_cardapio.br.com.bitbyte.models.Variacao;
import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;

public class VariacaoBBIFood implements Identificavel<String>
{
    private StringFormatterBuilder formatter;
    private Variacao variacao;
    private VariacaoFormatter variacaoFormatter;
    
    public VariacaoBBIFood(Variacao variacao){
        formatter = new StringFormatterBuilder();
        this.variacao = variacao;
        variacaoFormatter =  new VariacaoFormatter();
    }

    public String getCodigo()
    {
        return formatter
                .defineCharLength(5)
                .removerLetras()
                .build(variacao.getCodigo());
    }

    public String getDescricao()
    {
        return variacaoFormatter.getDescricao(variacao.getDescricao());
    }
}