/*Written by Stephanie Rimel
Data Structures Fall 2018 Bhola
This program uses scanner input to populate and display 2 matrices. Then the matrices are multiplied 
and displayed. A timer keeps track of the time it takes to multiply the matrices and displays the time.
Gives the option to restart the program. */

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Matrix {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in); //Scanner declaration
		String again = "";

		//prompts the user to enter the number of columns and rows desired in their matrices. <=50.
		do {			
			System.out.print("How many columns do you want in your matrix? Enter a number less than or equal to 50: "); //prompts user for number groups to generate
			int col = s.nextInt();
			System.out.println("How many rows do you want in your matrix? enter a number less than or equal to 50: ");
			int row = s.nextInt();

			//checks to make sure that the number is <= 50
			//if numbers are greater than 50, program prompts the user to reenter acceptable numbers.
			while (col > 50 || row > 50){ 
				System.out.print("Columns must be bewteen 1 and 50. Try again: ");
				col = s.nextInt();
				System.out.println("Rows must be between 1 and 50. Try again:");
				row = s.nextInt();
			}

			
			

			//matrix declaration
			int[][] matrix1 = new int[row][col];
			int[][] matrix2 = new int[row][col];


			//populates the matrix
			populate2d(matrix1);
			populate2d(matrix2);

			//displays the matrices
			System.out.printf("%-17s %19s %n","   Matrix","One") ; //formats
			System.out.printf("%-17s %19s %n","   ============","===========") ;
			
			print2D(matrix1);
			System.out.println();
			System.out.printf("%-15s %19s %n","   Matrix","Two") ; //formats
			System.out.printf("%-15s %19s %n","   ============","===========") ;
			print2D(matrix2);
			System.out.println();

			//starts the stopwatch
			long start = System.currentTimeMillis(); 
			int width = 10*col;
			//calls the method multiply, finds the product of the two matrixes and assigns the 
			//products to the relevant index in the new product matrix.
			int[][] multMat = multiply(matrix1, matrix2, row, col); 
			System.out.printf("%-15s %19s %n"," Multiplied","Matrix") ; //formats
			System.out.printf("%-15s %19s %n"," ============","===========") ;
			print2D(multMat); //prints the new multiplied matrix.


			long end = System.currentTimeMillis(); //ends the stopwatch
			long time = end-start;
			System.out.println("\nTime to mutliply array: " + time +" milliseconds."); //prints the time it took to multiply the matricies.


			System.out.print("\nWould you like to run the program again(Y/N)?"); //ask user if the want to run the program again.
			again = s.next().toUpperCase();
		} while (again.equalsIgnoreCase("Y")); //handles yes answer

		if (again.equalsIgnoreCase("N")){ //handles no answer
			System.out.println("Thanks for playing! Goodbye! \n"); //Goodbye
		}


		s.close(); //Closes scanner 


	}

	//method populates the matrix
	public static void populate2d(int mat[][]) {
		for(int i = 0; i < mat.length; i++) {  // loops through columns and rows
			for(int j = 0; j < mat[i].length; j++) {
				mat[i][j] = (int) (Math.random()*99+1); //random numfrom math class to populate the matrix with random integers
			}
		}

	}
	//method to display the matrix
	public static void print2D(int mat[][]) {	//loops through columns and rows
		for(int i = 0; i<mat.length; i++) {
			for(int j = 0; j<mat[i].length; j++) {
				System.out.printf("%5d ", mat[i][j]); //formatting to display the matrix justified
			}
			System.out.println();
		}

	}

	public static int[][] multiply(int[][] mat1, int[][] mat2, int row, int col) {
		int[][] multMat = new int[row][col]; //declares the new multiplied matrix
		int product = 0;
		for(int i = 0; i < mat1.length; i++) {
			for(int j = 0; j < mat1[i].length; j++) { //loops through columns and rows
				product = mat1[i][j] * mat2[i][j];  //multiplies the number of the first matrix by the number from the second matrix of the same index
				multMat[i][j] = product;  //the product is assigned the the same cooresponding index in the new multiplied matrix.

			}
		}
		return multMat; //returns the matrix
	}

}

