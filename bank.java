/*
 * You are to write a program named bank.java that stimulates a bank. The program
 * will prompt the user asking if they want to run the program again. If yes, then 
 * start the program over. If no, then terminate the program.
 * 
 * @ Execution phase - run for 2 minutes ---> Customers arrive randomly (2 - 6 seconds) 
 * 					  a placed into queue	
 * @ Customers have property - time with teller - randomly (2 - 5 seconds) [CHECK]
 * @ Maximum of 5 availableBanker - to attend to the customers [CHECK]
 * @ When simulation starts - availableBanker are occupied. [CHECK]
 * @ Need to generate a random time for each of the first 5 customers occupying the 
 * 	 the availableBanker are the beginning of the 2 min simulation. [CHECK]
 * @ Once time is up for teller and customer - teller becomes available for next customer (in queue) [CHECK]
 * @ As customer is removed from the queue and sent to an "available" teller, then availability set to "False".
 * @ Customers allocated to any one of the 5 availableBanker that become available... and so on...
 *   until the time of 2 minutes for the simulation is over.
 * @ If after 2 minutes, customers still in queue, discard them, but still count them in the total
 *   count of customers that visited the bank. 
 *   - Also add into the total count of customers - first 5 original customers
 *     as well as individual availableBanker totals
 *     
 * @ FINAL DISPLAY ON SCREEN (at end of each execution)
 *       - 1 - Total amount of customers that visited the bank for that 2 minutes
 *       - 2 - Total amount of customers that each teller helped.
 *       - 3 - Total amount of time that each teller was occupied. 
 *       - 4 - Total amount of customers that did not get to see a teller. 
 *       
 * -------------------------------------------------------------------------------------------------------------------
 *       
 * AUTHOR: LAWRENCE CHEN
 * 
 * 1) *** THE PURPOSE OF THE PROGRAM ***
 * 
 * 		- The purpose of this program is to gain experience with Queues by simulating a bank. 
 * 		  banks have waiting lines and they work in the same way queues do.
 * 
 * 		- Also it is to gain experience with library functions like random so that
 * 		  we learn how to generate random numbers and time.
 * 
 * 		- Also, we gained experience with arrays and/ or vectors. 
 *	 	
 * 2) *** SOLUTION ALGORITHMS ***
 * 
 * 		- To customerArrival 
 * 				*  Math random and multiplied it by 5 - 2 --> (2 - 5 seconds)
 * 				*  set as an integer value called randomTime
 * 
 * 		- To create a maxiumum of 5 bankers
 * 				* Only initialized values needed for 5 bankers
 * 				* And created an array to hold each banker + values
 * 
 * 		- To show if banker is free or not
 * 				* Created boolean variables - true if free - false if not
 * 
 * 		- To set timer equal to 120 seconds which is 2 mins
 * 				* if(timer == 120) then print values
 * 				* else continue to run simulation and recorded results
 * 
 * 		- Created individual variables for each banker 
 * 				* variable for # of customers helped and variable for time spent by banker
 * 
 * 		- To get the customers that did not get to see a teller
 * 				* bankLine.size() - to get the customers that were still left in the line, who never got help
 * 
 *		- To get total amount of customers that visited the bank 
 *				* sum all of the customers each teller helped
 *
 *		- Took into account the very 5 original customers that occupied the tellers - initially
 * 
 * 3) *** LIST THE DATA STRUCTURES ***
 * 		- Linked List -
 * 		- Queue -	  - bankLine was a linked list - Queue implementation
 * 				* take customer from the front of the line and assigned him to a random teller
 * 
 * 		- Two arrays -
 * 				* One array for available bank 1-5
 * 				* One array for random teller value 
 * 
 * 4) *** DESCRIPTION FOR USING THE PROGRAM LIKE MENTIONING INPUT AND OUTPUT HANDLING ***
 * 		- Used a scanner to prompt the user if they wanted to run the simulation
 * 				* Requires user input - yes or no 
 *  
 * 		- There will be an output of:
 * 				* 1 - Verification that the simulation was executed.
 * 				* 2 - Then a console log
 * 						.to show the progress of the simulation
 * 				* 3 - Final results page of the bank simulation
 * 
 * 5) *** DESCRIBE PURPOSE OF EACH CLASS/METHOD DEVELOPED ***
 * 		- Main 
 * 				* Holds everything
 * 				* Contains the switch statement
 * 				* Contains the runnable 
 * 					* And runnable's run method
 * 				* Runnable prints output and runs simulation based on the 120 second timer
 *
 * 		- public void run Method
 * 				*  runs the bank simulation
 * 					- tests if and else statements 
 * 					- to see if bankers are available 
 * 					- keeps track of other needed values like: helped and time spent
 * 
 * 6) *** FOR EACH METHOD GIVE PRE AND POST CONDITION AND INVARIANT ***
 * 		- ONE PRE AND POST CONDITION
 * 
 * 			* public void run method
 * 				.runs when runnable is declared
 * 				.returns no value - just runs everything within it's borders
 * 
 * 7) *** PROGRAM EXECUTION ***
 * 		- Program does not work to it's fullest extenet
 * 			- Run errors, algorithmic issues somewhere within code
 * 			- Only issue is that there is a loop that is being repeated
 * 			- That is because of the time condition statement (if statement)
 * 
 * 8) *** NAME OF PROGRAM IS SAME AS REQUIRED *** 
 * 		- bank.java --> which was the name we were supposed to use
 * 
 * 9) *** PRINT OUT ***
 * 					- Did not print. E-mailed output.txt
 * 				  as an attachment - this is the output of the program
 * 
 */

import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class bank {
	public static void main(String args[]){
		
//---------- WELCOME MESSAGE MENU -----------------------------------------------------------------------------------	
		
		// SCANNER OBJECT!
		Scanner sc = new Scanner(System.in);
		
		// THIS IS THE WELCOME MESSAGE
		System.out.println("Hello! I am Bank simulator! \n\n" 
				+ "I simulate a bank which consist of customers and availableBanker.\n"
				+ "My simulation last for 2 minutes! During this time, I will be keeping track of: \n\n"
				+ " 1) Total amount of customers that visited the bank. \n" +  " 2) Total amount of customers that each teller helped.\n" 
				+ " 3) Total amount of time that each teller was occupied. \n" + " 4) Total amount of customers that did not get to see a teller.\n");
		System.out.println(" - Would you like me to run my simulation? Enter Y or N: ");
		String runCmd = sc.nextLine().toLowerCase();
		
		// SWITCH COMMAND - prompts user if they want to run the simulation or not
		// Takes in user input; Three cases; If y - then runs simlation; If n - then exits; If anything else - prints "you broke me"
		switch(runCmd){
		case "y": System.out.println("Loading . . .");
				  System.out.println("Bank Simulation Executed!");
				  System.out.println("Please wait 2 minutes. Simulation is currently running . . .\n");
				  System.out.println("-------------------------------------------------------------------\n");
				  System.out.println("CONSOLE LOG: ");
				  Runnable runBank = new Runnable(){
					  
//-------- DECLARED VARIABLES ----------------------------------------------------------------------------------
						
		Random randy = new Random();	// Implemented random class - 
		
		Queue<Integer> bankLine = new LinkedList<Integer>();	// Implement of Queue class 
		
		int totalNumCustomers = 0;		// Total number of customers that visited the bank
		
		boolean teller1 = false; 	
		boolean teller2 = false; 	// Initial availability set to false
		boolean teller3 = false;	// From beginning of simulation - availableBanker are occupied
		boolean teller4 = false; 
		boolean teller5 = false;
		
		// Array of bankers
		boolean[] availableBanker = {teller1, teller2, teller3, teller4, teller5};
		
		// Process time int variable 
		int processTime = 1, processTime2 = 1, processTime3 = 1, processTime4 = 1, processTime5 = 1;
		
		// Timer for the 2 min count - 120 seconds
		int timer = 0;				
		
		// Customer helped
		int helped1 = 0, helped2 = 0, helped3 = 0, helped4 = 0, helped5 = 0;
		
		// Time spent with customer
		int timeSpent1 = 0, timeSpent2 = 0, timeSpent3 = 0, timeSpent4 = 0, timeSpent5 = 0;
		
		// Teller available
		int banker1, banker2, banker3, banker4, banker5;
						
		// Random time with teller (2 - 5 seconds random) 
		int[] randTeller = { (randy.nextInt(5 - 2) + 2), (randy.nextInt(5 - 2) + 2), (randy.nextInt(5 - 2) + 2)
							, (randy.nextInt(5 - 2) + 2), (randy.nextInt(5 - 2) + 2)};
							
//---------- START OF RUN METHOD --------------------------------------------------------------------------------
		
		
		// Method to be ran by the runnable which is triggered by the switch statement (entering y)
		public void run(){
			// Initialized at a lower number just for testing purposes - 2 mins is too long to wait
			// OUTPUT MESSAGE - BANK SIMULATION RESULTS
			
			// RUN MAIN IF CONDITION
			// IF Timer is equal to time requested to run - change equal value to whatever needed
			// THEN print out all recorded results
			if(timer == 25){
				
				totalNumCustomers = helped1 + helped2 + helped3 + helped4 + helped5 + bankLine.size();
				
				System.out.println("\n-------------------------------------------------------------------------------\n");
				System.out.println("                        *** BANK SIMULATION RESULTS ***           \n");
				System.out.println("\t   - Total amount of customers that visited the bank: " + totalNumCustomers + "\n");
				System.out.println("\t   - Teller #1 helped: " + helped1 + " customers" + "\tTotal occupied time: " + timeSpent1 + " seconds");
				System.out.println("\t   - Teller #2 helped: " + helped2 + " customers" + "\tTotal occupied time: " + timeSpent2 + " seconds");
				System.out.println("\t   - Teller #3 helped: " + helped3 + " customers" + "\tTotal occupied time: " + timeSpent3 + " seconds");
				System.out.println("\t   - Teller #4 helped: " + helped4 + " customers" + "\tTotal occupied time: " + timeSpent4 + " seconds");
				System.out.println("\t   - Teller #5 helped: " + helped5 + " customers" + "\tTotal occupied time: " + timeSpent5 + " seconds");
				System.out.println("\n\t  - Total amount of customers that did not get help: " + bankLine.size());
				System.out.println("\n-------------------------------------------------------------------------------\n");
				
				System.exit(-1);
				
				// RUN MAIN ELSE CONDITION
				} else {
					// Random time with teller 2 - 5 seconds
					if(randy.nextInt(2) < 6){
						int randomTime = (randy.nextInt(5 - 2) + 3);
						bankLine.add(randomTime);
						}
					
					// BANKER 1------------------------------------------------------------------
					while(banker1 == 1){
						processTime = timer;
						banker1 = 0;
					}
					if((timer - processTime) >= randTeller[0]){
							System.out.println("Teller is now available.");
							availableBanker[0] = true; 			// Teller is now available
						}
							if(availableBanker[0] == true && bankLine.isEmpty() == false){
								timeSpent1 = timeSpent1 + randTeller[0];
								randTeller[0] = bankLine.poll();
								banker1 = 1;
								System.out.println("A customer was served successfully served. (1)");
								helped1++;
							}
					
					// BANKER 2------------------------------------------------------------------
					// This starts the timer until the teller is done with the customer. Then it resets.
					while(banker2 == 1){
						processTime2 = timer;
						banker2 = 0;
					}
						if((timer - processTime2) >= randTeller[1]){
							System.out.println("Teller is now available.");
							availableBanker[1] = true; 			// Teller is now available
						}
							if(availableBanker[1] == true && bankLine.isEmpty() == false){
								timeSpent2 = timeSpent2 + randTeller[1];
								randTeller[1] = bankLine.poll();
								banker2 = 1;
								System.out.println("A customer was served successfully served. (2)");
								helped2++;
							}
					
					
					// BANKER 3------------------------------------------------------------------
					while(banker3 == 1){
						processTime3 = timer;
						banker3 = 0;
					}
						if((timer - processTime3) >= randTeller[2]){
							System.out.println("Teller is now available.");
							availableBanker[2] = true; 			// Teller is now available
						}
							if(availableBanker[2] == true && bankLine.isEmpty() == false){
								timeSpent3 = timeSpent3 + randTeller[2];
								randTeller[2] = bankLine.poll();
								banker3 = 1;
								System.out.println("A customer was served successfully served. (3)");
								helped3++;
							
							}
					
					
					// BANKER 4------------------------------------------------------------------
					while(banker4 == 1){
						processTime4 = timer;
						banker3 = 0;
					}
						if((timer - processTime4) >= randTeller[3]){
							System.out.println("Teller is now available.");
							availableBanker[3] = true; 			// Teller is now available
						}
							if(availableBanker[3] == true && bankLine.isEmpty() == false){
								timeSpent4 = timeSpent4 + randTeller[3];
								randTeller[3] = bankLine.poll();
								banker4 = 1;
								System.out.println("A customer was served successfully served. (4)");
								helped4++;	
							}
					
					
					// BANKER 5------------------------------------------------------------------
					while(banker5 == 1){
						processTime5 = timer;
						banker5 = 0;
					}
						if((timer - processTime5) >= randTeller[4]){
							System.out.println("Teller is now available.");
							availableBanker[4] = true; 			// Teller is now available
						}
							if(availableBanker[4] == true && bankLine.isEmpty() == false){
								timeSpent5 = timeSpent5 + randTeller[4];
								randTeller[4] = bankLine.poll();
								banker5 = 1;
								System.out.println("A customer was served successfully served. (5)");
								helped5++;	
							}
							
					timer++;
					
				} // End of timer == value	
			
			} // End of void run			
			
		};	// End of runnable
		
		// Tells when to execute a task
		ScheduledThreadPoolExecutor go = new ScheduledThreadPoolExecutor(1);
		
		// scheduleAtFixedRate - runBank 
		go.scheduleAtFixedRate(runBank, 0, 1, TimeUnit.SECONDS); 
		
		// End of switch case - break
		break;	
//---------------------------------------------------------------------------------------------------------------		
		
		// NO --> EXIT PROGRAM
		case "n": System.out.println("That's okay . . .! I didn't want to work anyways . . .");
				  System.exit(-1);
				  break;
				  
		// ANYTHING ELSE --> EXITS PROGRAM				  
		default: System.out.println("You didn't put Y or N!\n" + "You broke meeee . . .\n" + "Good-bye cruel wooooorld . . .");
				 System.exit(-1);
				 break;
						 
		} // End Switch
	} // End Main
} // End Class
