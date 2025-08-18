package web_cardapio.br.com.bitbyte.models.bbifood;

import java.math.BigDecimal;

import web_cardapio.br.com.bitbyte.interfaces.ItemComandaIngrediente;
import web_cardapio.br.com.bitbyte.interfaces.Quantificavel;
import web_cardapio.br.com.bitbyte.models.Item;
import web_cardapio.br.com.bitbyte.utils.BigDecimalUtils;
import web_cardapio.br.com.bitbyte.utils.StringFormatterBuilder;

public class ItemBBIFood implements ItemComandaIngrediente, Quantificavel{
    
    private final Item item;
    private StringFormatterBuilder formatter;
    
    public ItemBBIFood(Item itemComanda){
        this.item = itemComanda;
        formatter = new StringFormatterBuilder();
    }
    
    public String getId() {
        return formatter
                .limitarCaracteres(100)
                .removerAcentos()
                .trim()
                .build(item.getId());
    }

    public String getDescricao() {
        return formatter
                .limitarCaracteres(210)
                .removerAcentos()
                .toUpperCase()
                .trim()
                .build(item.getDescricao());
    }

    public String getCodigo() {
        return formatter
                .removerLetras()
                .removerAcentos()
                .defineCharLength(6)
                .build(item.getCodigo());
    }

    public String getCodigoPesquisa() {
        return formatter
                .limitarCaracteres(15)
                .removerLetras()
                .removerAcentos()
                .build(item.getCodigoPesquisa());
    }

    public ItemBBIFood setCodigoPesquisa(String codigoPesquisa) {
        this.item.setCodigoPesquisa(codigoPesquisa);
        return this;
    }

    public BigDecimal getVrUnit() {
        return BigDecimalUtils.getZeroIfNull(item.getVrUnit());
    }

    public ItemBBIFood setVrUnit(BigDecimal vrUnit) {
        this.item.setVrUnit(vrUnit);
        return this;
    }

    public double getQtd() {
        return item.getQtd();
    }

    public ItemBBIFood setQtd(double qtd) {
        item.setQtd(qtd);
        return this;
    }
    
    public AdicionaisBBIFood getAdicionais() {
    	return new AdicionaisBBIFood(item.getAdicionais());
    }

    public String getOrigem() {
    	return formatter
    			.limitarCaracteres(10)
    			.removerAcentos()
    			.toUpperCase()
    			.trim()
    			.build(item.getOrigem());
    }

    public ItemBBIFood setOrigem(String origem) {
        this.item.setOrigem(origem);
        return this;
    }
    
    public int getIdIngre() {
    	return item.getIdIngre();
    }
    
    public void setIdIngre(int idIngre) {
    	item.setIdIngre(idIngre);
    }
    
    public int getSeqItem() {
    	return item.getSeqItem();
    }
    
    public void setSeqItem(int seqItem) {
    	item.setSeqItem(seqItem);
    }
    
    public Item getItemPedido() {
    	return item;
    }
    
    public int getIdPizza() {
    	return item.getIdPizza();
    }
    
    public void setIdPizza(int idPizza) {
    	item.setIdPizza(idPizza);
    }
    
    public String getObservacao() {
    	return formatter
    			.limitarCaracteres(500)
    			.trim()
    			.removerAcentos()
    			.toUpperCase()
    			.build(item.getObservacao());
    }
    
    public boolean isAcessorio() {
    	return item.isAcessorio();
    }
}
