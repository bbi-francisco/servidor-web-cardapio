package web_cardapio.br.com.bitbyte.enums;

public class BBIStatus {
	
	public static final int CAIXA_FECHADO = 469;
	
	public abstract class Comanda{
	    public static final int COMANDA_FECHADA = 470;
	    public static final int COMANDA_BLOQUEADA = 471;
	    public static final int COMANDA_NAO_ABERTA = 472;
	    public static final int INTERVALO_INVALIDO = 473;
	    public static final int TAG_INVALIDA = 474;
	    public static final int LIMITE_ULTRAPASSADO = 475;
	    public static final int COMANDA_INVALIDA = 476;
	    public static final int COMANDA_JA_ABERTA = 478;
	    public static final int QR_CODE_INVALIDO = 479;
	    public static final int COMANDA_SEM_ITENS = 480;
	    public static final int SEM_LICENCA = 481;
	}
}
