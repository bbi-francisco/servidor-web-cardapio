package web_cardapio.br.com.bitbyte.models;

public class ComandaState {
	
	private BloqueioComanda bloqueioComanda;
	private FechamentoComanda fechamentoComanda;
	private IntervaloComanda intervaloComanda;
	private ValoresComanda limiteComanda;
	private boolean limiteUltrapassado;
	private boolean aberta;
	private Comanda comanda;
	
	public FechamentoComanda getFechamentoComanda() {
		return fechamentoComanda;
	}
	public ComandaState setFechamentoComanda(FechamentoComanda fechamentoComanda) {
		this.fechamentoComanda = fechamentoComanda;
		return this;
	}
	
	public boolean isLimiteUltrapassado() {
		return limiteUltrapassado;
	}
	public ComandaState setLimiteUltrapassado(boolean limiteUltrapassado) {
		this.limiteUltrapassado = limiteUltrapassado;
		return this;
	}
	
	public BloqueioComanda getBloqueioComanda() {
		return bloqueioComanda;
	}
	
	public ComandaState setBloqueioComanda(BloqueioComanda bloqueioComanda) {
		this.bloqueioComanda = bloqueioComanda;
		return this;
	}
	
	public boolean isAberta() {
		return aberta;
	}
	public void setAberta(boolean aberta) {
		this.aberta = aberta;
	}
	public IntervaloComanda getIntervaloComanda() {
		return intervaloComanda;
	}
	public ComandaState setIntervaloComanda(IntervaloComanda intervaloComanda) {
		this.intervaloComanda = intervaloComanda;
		return this;
	}
	
	public ValoresComanda getLimiteComanda() {
		return limiteComanda;
	}
	public ComandaState setLimiteComanda(ValoresComanda limiteComanda) {
		this.limiteComanda = limiteComanda;
		return this;
	}
	public Comanda getComanda() {
		return comanda;
	}
	public ComandaState setComanda(Comanda comanda) {
		this.comanda = comanda;
		return this;
	}
	
}
