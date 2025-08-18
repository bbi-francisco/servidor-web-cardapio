package web_cardapio.br.com.bitbyte.format;

import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;

public class VariacaoFormatter {
    
    private StringFormatterBuilder formatter;
    
    public VariacaoFormatter(){
        formatter = new StringFormatterBuilder();
    }
    
    public String getDescricao(String descricao){
        return formatter
                .limitarCaracteres(50)
                .removerAcentos()
                .toUpperCase()
                .trim()
                .build(descricao); 
    }
}