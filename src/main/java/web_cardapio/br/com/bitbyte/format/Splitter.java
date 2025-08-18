package web_cardapio.br.com.bitbyte.format;

public class Splitter
{
	/**
	 * Recupera as variacoes de determinado item baseado na consulta geral de variacoes 
	 * @param variacoes - variacoes no formato de exemplo : 00033|00022|00011
	 * @param lstVariacoesConsulta - lista de variacoes geral
	 * @return
	 */
	
	public String[] splitVariacoes(String data) 
	{
		// O simbolo | é um caractere especial usado para alternacao no regex, por isso foi utilizado: split("\\|")
		String[] dataSplitted = data.split("\\|"); 
		return dataSplitted;
	}
}
