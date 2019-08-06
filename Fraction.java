
public class Fraction {
	private int numerator;
	private int denominator;
	public Fraction(int num, int denom) {
		this.numerator = num;
		this.denominator = denom;
		
	}
	public Fraction add(Fraction f) {
		int num = numerator * f.getDenominator() + f.numerator * denominator;
		int denom = denominator * f.denominator;
		return new Fraction(num, denom);
	}
	public int getNumerator() {
		return numerator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	public String toString() {
		return numerator + "/" + denominator;
	}

}
