
public class CountFactors {
	public static void main(String[] args) {
		
		firstFactor(91);
		printPrimes(256);
		int factors = countFacts(256);
		System.out.println("\n" +factors);
		int digits = countDigits(1234);
		System.out.println(digits);
		
		
		
		
		
		
	
}
	
	public static int countDigits(int number) {
		int count = 0;
		while(number > 0) {
			count++;
			number/=10;
		}
		return count;
	}
	
	public static void printPrimes(int number) {
		if(number>=2) {
			System.out.print("2");
		
		for(int i = 3; i<= number; i++) {
			if(countFacts(i) == 2) {
				System.out.print(", " + i);
			}
			}
		}
	}
	public static int countFacts(int number) {
		int count = 0;
		for(int i = 1; i <= number; i++) {
			if(number%i== 0) {
				
				count++;
				
			}
		}
		return count;
	}
	public static void firstFactor(int n) {
		
		int factor = 2;
		while(n%factor != 0) {
			factor++;
			
		}
		System.out.println("First factor is " + factor);
	}
}
