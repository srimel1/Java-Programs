
public class practice43 {
	public static void main(String[] args) {
		printSquares(6);
	}
	public static void printSquares(int n) {
		if(n > 0) {
			int square = n * n;
			System.out.println(n +" " + square);
			printSquares(n-1);
		}
	}
}
