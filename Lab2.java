import java.util.Scanner;

public class Lab2 {
	public static void main (String[] args){
		Scanner in = new Scanner(System.in);
		
		System.out.print("Please enter the last 5 digits of your panther ID: ");
		int PantherID = in.nextInt();
		
		System.out.print("Please enter a digit between 0 and 9: ");
		int singleDigit = in.nextInt();
		
		System.out.println(containDigit(PantherID, singleDigit));
		
		in.close();
	}
	
	public static boolean containDigit(int PantherID, int singleDigit){
		do{
			int a = PantherID % 10;
			
			if (a == singleDigit){
				return true;
			}
			
			PantherID /= 10;
			
		} while (PantherID != 0);
		return false;
	}
}