/*The program must prompt the user to ender a number for the amount of groups
	they want to generate. The groups will be made up of two sets of numbers. The
	numbers must be randomly generated from the range 1 - 69 for the first group
	and 1 - 26 for the second group. There must be no repetition of numbers in the
	same subgroup.
	
	Generating the Lotto Numbers:
	First I used one 2D array to store the subgroup with the larger number then another
	1D array to store subgroup 1. Then I sorted the array and compared every 2 numbers to
	check if the matched, if they did, I generated a new number in that place. I used a
	four loop to print the arrays.
*/

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class numbers {
	public static void main(String[] args) {	
		Scanner input = new Scanner(System.in); 
		Random rand = new Random();
		
		String again = "";
		do {			
			System.out.print("Enter a number between 1 and 5 for the number of groups you want to generate: "); //prompts user for number groups to generate
			int groups = input.nextInt();
			
			while (groups < 1 || groups > 5){ //takes user input for number of groups to generate
				System.out.print("The number must be bewteen 1 and 5. Try again: ");
				groups = input.nextInt();
			}
			
			int[][] lottNumbers = new int[groups][5]; //Subgroup 1 stored in a 2d array
			int [] powerBall = new int[groups]; //Subgroup 2 stored in 1d array
			
			for (int i = 0;i < lottNumbers.length; i++){ //for loop fills subgroup 1 array
				for (int j = 0; j < lottNumbers[i].length; j++){
					lottNumbers[i][j] = rand.nextInt(69-1) + 1;
				}
				Arrays.sort(lottNumbers[i]); //sorts array
				powerBall[i] = rand.nextInt(25-1)+1; //fills subgroup 2 array
			}

			for (int i = 0;i < lottNumbers.length; i++){ //for loop checks if subgroup 1 have repeating numbers
				for (int j = 1; j < lottNumbers[i].length; j++){
					
					if (lottNumbers[i][j] == lottNumbers[i][j-1]){
						lottNumbers[i][j-1] = rand.nextInt(69-1) + 1;
					}
					Arrays.sort(lottNumbers[i]); //sorts array
				}
			}
			
			for (int i = 0;i < lottNumbers.length; i++){ //prints out arrays
				for (int j = 0; j < lottNumbers[i].length; j++){ //subgroup 1 array
					System.out.print(lottNumbers[i][j]+ " ");
				}
				System.out.println("\t" + powerBall[i]); //subgroup 2 array
			}
				
			System.out.print("Would you like to run the program again(Y/N)?"); //ask user if the want to generate more groups
			again = input.next();
		} while (again.equalsIgnoreCase("y")); //handles if user what to generate more groups
		
		if (again.equalsIgnoreCase("N")){
			System.out.println("Alright then, Goodbye."); //pleasant goodbye
		}
		input.close(); //Close scanner object
	} //end of main
}
