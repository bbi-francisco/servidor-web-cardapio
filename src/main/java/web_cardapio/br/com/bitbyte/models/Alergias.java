package web_cardapio.br.com.bitbyte.models;

import web_cardapio.br.com.bitbyte.utils.StringUtils;

public class Alergias {
	
	private String codProd;
	private boolean ovo;
	private boolean leite;
	private boolean soja;
	private boolean gluten;
	private boolean amendoim;
	private boolean sulfitos;
	private boolean peixe;
	private boolean moluscos;
	private boolean mostarda;
	private boolean nozes;
	private boolean gergelim;
	private boolean aipo;
	private boolean tremoco;
	private boolean crustaceos;
	
	public String getCodProd() {
		return StringUtils.getEmptyIfNull(codProd);
	}
	public Alergias setCodProd(String codProd) {
		this.codProd = codProd;
		return this;
	}
	
	public boolean isOvo() {
		return ovo;
	}
	public Alergias setOvo(boolean ovo) {
		this.ovo = ovo;
		return this;
	}
	public boolean isLeite() {
		return leite;
	}
	public Alergias setLeite(boolean leite) {
		this.leite = leite;
		return this;
	}
	public boolean isSoja() {
		return soja;
	}
	public Alergias setSoja(boolean soja) {
		this.soja = soja;
		return this;
	}
	public boolean isGluten() {
		return gluten;
	}
	public Alergias setGluten(boolean gluten) {
		this.gluten = gluten;
		return this;
	}
	public boolean isAmendoim() {
		return amendoim;
	}
	public Alergias setAmendoim(boolean amendoim) {
		this.amendoim = amendoim;
		return this;
	}
	public boolean isSulfitos() {
		return sulfitos;
	}
	public Alergias setSulfitos(boolean sulfitos) {
		this.sulfitos = sulfitos;
		return this;
	}
	public boolean isPeixe() {
		return peixe;
	}
	public Alergias setPeixe(boolean peixe) {
		this.peixe = peixe;
		return this;
	}
	public boolean isMoluscos() {
		return moluscos;
	}
	public Alergias setMoluscos(boolean moluscos) {
		this.moluscos = moluscos;
		return this;
	}
	public boolean isMostarda() {
		return mostarda;
	}
	public Alergias setMostarda(boolean mostarda) {
		this.mostarda = mostarda;
		return this;
	}
	public boolean isNozes() {
		return nozes;
	}
	public Alergias setNozes(boolean nozes) {
		this.nozes = nozes;
		return this;
	}
	public boolean isGergelim() {
		return gergelim;
	}
	public Alergias setGergelim(boolean gergelim) {
		this.gergelim = gergelim;
		return this;
	}
	public boolean isAipo() {
		return aipo;
	}
	public Alergias setAipo(boolean aipo) {
		this.aipo = aipo;
		return this;
	}
	public boolean isTremoco() {
		return tremoco;
	}
	public Alergias setTremoco(boolean tremoco) {
		this.tremoco = tremoco;
		return this;
	}
	public boolean isCrustaceos() {
		return crustaceos;
	}
	public Alergias setCrustaceos(boolean crustaceos) {
		this.crustaceos = crustaceos;
		return this;
	}
	
	

}
