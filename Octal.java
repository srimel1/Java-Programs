
public class Octal {
	public static void main(String[] args) {
		int a = displayOctal(188);
		System.out.println("f(8) is equal to "+f(1));
		
	}
	public static int displayOctal(int n) {
		if(n>0) {
			if(n/8>0) {
				displayOctal(n%8);
			}
			System.out.println(n%8);
		}
		return n;
	}
	public static int f(int n) {
		System.out.printf("Enter f: n = %d\n",n);
		
		switch(n) {
		case 1: case 2: case 3:
			return n+1;
			
			default:
				return f(n-1)*f(n-3);
		}
	}
}
