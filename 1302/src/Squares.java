
public class Squares {
	public static void main(String[] args) {
		int num = 6;
		printSquares(num);
		System.out.println(Pow(3, 4));
		
	}
	public static void printSquares(int n) {
		if(n == 0) {
			System.out.println("0");
		}else {
			System.out.println(n + " " + Math.pow(n, 2));
			printSquares(n-1);
		}
	}
	public static double Pow(int base, int exp) {
		if(exp == 0)
			return 1;
		else
			return base*Pow(base, exp-1);
	}

}
