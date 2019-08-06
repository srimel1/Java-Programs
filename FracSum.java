import java.util.Scanner;
public class FracSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter name: ");
		String name = in.nextLine();
		
		System.out.println("Please enter your Panther ID number: ");
		double id = in.nextInt() % 100;
		
		double d = (id + 10) * 2 + 1;
		
		double a = 0, sum = 0;
		
		for (double i = 1.0; i <= d; i += 2){
			a = i + 2.0;
			sum += i/a;
		}
		System.out.println(name);
		System.out.println(sum);
		
		
		in.close();
	}

}