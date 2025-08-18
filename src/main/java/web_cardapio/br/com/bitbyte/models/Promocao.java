package web_cardapio.br.com.bitbyte.models;

public class Promocao{

	private String codigoItem;
	private int dia;
	private String horarioInicio;
	private String horarioFim;
	private double percentual;
	
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
	public double getPercentual()
	{
		return percentual;
	}
	public void setPercentual(double percentual)
	{
		this.percentual = percentual;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("codigo-item: " + getCodigoItem());
		sb.append("\n");
		sb.append("dia: " + getDia());
		sb.append("\n");
		sb.append("horario-fim: " +getHorarioInicio());
		sb.append("\n");
		sb.append("hora-fim: " +getHorarioFim());
		return sb.toString();
	}

}
