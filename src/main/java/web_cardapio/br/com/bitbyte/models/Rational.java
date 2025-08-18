
package web_cardapio.br.com.bitbyte.models;
/**
 * Represents a rational number.
 * @version 1.0
 * @author Vitor Bonequini.
 */
public final class Rational
{
	private double decimalValue;
	private String fraction;

	public Rational(double d)
	{
		decimalValue = d;
		fraction = convert(d);
	}

	private String convert(double x)
	{
		if (x < 0)
		{
			return "-" + convert(-x);
		}

		double tolerance = 1.0E-6;
		double h1=1; double h2=0;
		double k1=0; double k2=1;
		double b = x;

		do 
		{
			double a = Math.floor(b);
			double aux = h1; h1 = a*h1+h2; h2 = aux;
			aux = k1; k1 = a*k1+k2; k2 = aux;
			b = 1/(b-a);
		}
		while (Math.abs(x-h1/k1) > x*tolerance);

		return String.format("%.0f/%.0f", h1, k1);
	}

	public String toFraction()
	{
		return fraction;
	}

	public double toDecimal()
	{
		return decimalValue;
	}

	public int numerator()
	{
		String d = fraction.split("/")[0];
		return Integer.parseInt(d);
	}

	public int denominator()
	{
		String d = fraction.split("/")[1];
		return Integer.parseInt(d);
	}

	@Override
	public String toString()
	{
		return fraction;
	}
}