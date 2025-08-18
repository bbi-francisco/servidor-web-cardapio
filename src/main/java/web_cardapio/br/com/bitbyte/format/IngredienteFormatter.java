package web_cardapio.br.com.bitbyte.format;

import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;

public class IngredienteFormatter {
    
    private StringFormatterBuilder formatter;
    
    public IngredienteFormatter(){
        formatter = new StringFormatterBuilder();
    }
    
    public String getDescricao(String descricao){
        return formatter
                .removerAcentos()
                .limitarCaracteres(50)
                .toUpperCase()
                .trim()
                .build(descricao);
    }
    
}