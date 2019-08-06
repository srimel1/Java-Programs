import java.util.Random;
import java.util.Scanner;


public class selectionsort {
	public static void main (String[] args){
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		
		int[] randNumber = new int[1000];
		
        System.out.println("Please enter range for random numbers: ");
        System.out.println("Min:");       
        int min = input.nextInt();
        System.out.println("Max:");
        int max = input.nextInt();
        
		long start = System.currentTimeMillis();
		for (int i = 0; i < randNumber.length; i++){
			randNumber[i] = rand.nextInt(max - min + 1)+ min;
			
		}
		
//		System.out.println(Arrays.toString(randNumber));
		
		//selection sort 
		for (int i = 0; i < randNumber.length; i++){
			int minValue = i;
			for (int j = i; j < randNumber.length; j++){
				if (randNumber[j] < randNumber[minValue]){ 
					minValue = j;
				}
			}
			int temp = randNumber[i];
			randNumber[i] = randNumber[minValue];
			randNumber[minValue] = temp;
		}
		
//		System.out.println(Arrays.toString(randNumber));
		
		long end = System.currentTimeMillis();
		System.out.println("Time to fill and sort array: " + (end - start) + " millisecond.");
		
		input.close();
	}
}