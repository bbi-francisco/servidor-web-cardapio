package web_cardapio.br.com.bitbyte.models;

public class Restricao{
	
	private String codigoItem;
	private int dia;
	private String horarioInicio;
	private String horarioFim;
	
	public String getCodigoItem()
	{
		return codigoItem != null ? codigoItem : "";
	}
	public void setCodigoItem(String codigoItem)
	{
		this.codigoItem = codigoItem;
	}
	public int getDia()
	{
		return dia;
	}
	public void setDia(int dia)
	{
		this.dia = dia;
	}
	public String getHorarioInicio()
	{
		return horarioInicio != null ? horarioInicio : "";
	}
	public void setHorarioInicio(String horarioInicio)
	{
		this.horarioInicio = horarioInicio;
	}
	public String getHorarioFim()
	{
		return horarioFim != null ? horarioFim : "";
	}
	public void setHorarioFim(String horarioFim)
	{
		this.horarioFim = horarioFim;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("codigo-item: " + getCodigoItem());
		sb.append("\n");
		sb.append("dia: " + getDia());
		sb.append("\n");
		sb.append("horario-inicio: " +getHorarioInicio());
		sb.append("\n");
		sb.append("horario-fim: " +getHorarioFim());
		return sb.toString();
	}
}
