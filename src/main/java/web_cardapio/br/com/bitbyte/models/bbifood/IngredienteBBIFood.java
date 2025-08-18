package web_cardapio.br.com.bitbyte.models.bbifood;

import web_cardapio.br.com.bitbyte.format.IngredienteFormatter;
import web_cardapio.br.com.bitbyte.models.Ingrediente;
import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;

public class IngredienteBBIFood{
    
    private Ingrediente subItem;
    private StringFormatterBuilder formatter;
    private IngredienteFormatter ingredienteFormatter;
    
    public IngredienteBBIFood(Ingrediente subItem){
        this.subItem = subItem;
        formatter = new StringFormatterBuilder();
        ingredienteFormatter = new IngredienteFormatter();
    }

    public String getCodigo()
    {
        return formatter
                .removerLetras()
                .defineCharLength(5)
                .build(subItem.getCodigo());
    }

    public String getDescricao()
    {
        String descricao = subItem.getDescricao();
        return ingredienteFormatter.getDescricao(descricao);
    }
    
    public String getTipo()
    {
        return subItem.getTipo();
    }

    public int getQtd()
    {
        return subItem.getQtd();
    }
}
