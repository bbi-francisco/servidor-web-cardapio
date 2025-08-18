package web_cardapio.br.com.bitbyte.estatico;

import java.lang.reflect.Field;

public class Parametros {
	
	private static String parametros;
	
	public static final String COMANDA_INICIAL = "COMANDA_INICIAL";
	public static final String COMANDA_FINAL = "COMANDA_FINAL";
	public static final String COM = "COM";
	public static final String COMISSAO = "COMISSAO";
	public static final String ABERTURA_COMANDA = "ABERTURA_COMANDA";
	public static final String VALIDA_LIMITE_CAIXA_ABERTURA = "VALIDA_LIMITE_CAIXA_ABERTURA";
	public static final String MULTI_ACRESCENTAR_ANDROID = "MULTI_ACRESCENTAR_ANDROID";
	public static final String VALOR_TRAVA_COMANDA = "VALOR_TRAVA_COMANDA";
	public static final String TRUNCAR_ARREDONDAR = "TRUNCAR_ARRENDONDAR";
	public static final String LIBERAR_TAXA_POR_PRODUTO = "LIBERAR_TAXA_POR_PRODUTO";
	public static final String TIPO_PESQ_CODPROD = "TIPO_PESQ_CODPROD";
	public static final String MESCLAR_PROD_VALOR_MEDIO = "MESCLAR_PROD_VALOR_MEDIO";
	public static final String DIRETORIO_IMAGENS = "DIRETORIO_IMAGENS";
	public static final String LIMITE_COMPRA_VENDA = "LIMITE_COMPRA_VENDA";
	public static final String INTEGRACAO_EASY_CHOPP = "INTEGRACAO_EASY_CHOPP";
	public static final String COMANDA_PRE_PAGA = "COMANDA_PRE_PAGA";
	public static final String EXIBE_TAXA_ATENDIMENTO = "EXIBE_TAXA_ATENDIMENTO";
	public static final String DIRETORIO_INSTALACOES = "DIRETORIO_INSTALACOES";
	public static final String UTILIZA_PESQUISA_SATISFACAO = "UTILIZA_PESQUISA_SATISFACAO";
	public static final String BLOQ_COMANDA_APOS_FX = "BLOQ_COMANDA_APOS_FX";
	
	public String getParametros()
	{
		if(parametros == null) 
		{
			try {
				StringBuilder sb = new StringBuilder();
		        for(Field parametro : getClass().getDeclaredFields()){
		            sb.append("'");
		            sb.append(parametro.get(this));
		            sb.append("'");
		            sb.append(",");
		        }
		        String parametrosFormatado = sb.toString();
		        parametros = parametrosFormatado.substring(0, parametrosFormatado.length()-1);
			}catch(IllegalAccessException e) {
				throw new RuntimeException("Erro ao configurar parâmetros. " + e.getMessage());
			}
		}
		return parametros;
    }
}