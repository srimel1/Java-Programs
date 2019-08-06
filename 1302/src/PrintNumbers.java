
public class PrintNumbers {
	public static void main(String[] args) {
		printNums(5);
	}
	public static void printNums(int number) {
		for(int i = 0; i<= number; i++) {
			if(i==0) {
			System.out.print(i);
			}else {
				System.out.print(", " + i);
			}
		}
	}
}
