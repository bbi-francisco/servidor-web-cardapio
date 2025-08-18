package web_cardapio.br.com.bitbyte.models.bbifood;

import web_cardapio.br.com.bitbyte.format.Format;
import web_cardapio.br.com.bitbyte.models.Atendente;
import web_cardapio.br.com.bitbyte.models.Comanda;
import web_cardapio.br.com.bitbyte.models.ValoresComanda;

public class ComandaBBIFood {
    
    private final Comanda comanda;
    
    public ComandaBBIFood(Comanda comanda){
        this.comanda = comanda;
    }
    
    public int getMesa(){
        return comanda.getMesa();
    }
    
    public int getNumero(){
        return comanda.getNumero();
    }
    
    public ClienteBBIFood getCliente(){
    	if(comanda.getCliente() == null) {
    		return null;
    	}
        return new ClienteBBIFood(comanda.getCliente());
    }
    
    public ValoresComanda getValoresComanda() {
    	return comanda.getValoresComanda();
    }
    
    public int getIdTablet() {
    	return comanda.getIdTablet();
    }
    
    public ComandaBBIFood setIdTablet(int idTablet) {
    	comanda.setIdTablet(idTablet);
    	return this;
    }
    
    public ComandaBBIFood setValoresComanda(ValoresComanda valoresComanda) {
    	comanda.setValoresComanda(valoresComanda);
    	return this;
    }
    
    public AtendenteBBIFood getAtendente() {
    	Atendente atendente = comanda.getAtendente();
    	if(atendente == null) {
    		return null;
    	}
    	return new AtendenteBBIFood(atendente);
    }
}