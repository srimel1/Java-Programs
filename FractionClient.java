
public class FractionClient {

	public static void main(String[] args) {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(1,2);
		Fraction f3 = f1.add(f2);
		
		System.out.println(f3.toString());
	}
}
