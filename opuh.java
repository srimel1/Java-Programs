/*
 * AUTHOR: LAWRENCE CHEN
 * 
 * 1) THE PURPOSE OF THE PROGRAM
 * 		- The purpose of this program is to gain experience with Binary Search 
 * 		  Trees and building my own Linked List in order to implement the Binary
 * 		  Search Tree. 
 * 		- Binary Search Tree concept through recursion method to print the values
 * 		  of the binary search tree 
 *	 	
 * 2) SOLUTION ALGORITHMS
 * 		- To generate 100 random integers between 0 - 99
 * 				*  Math random and multiplied it by 100
 * 				*  Put into a for loop and saved into a data structure (Linked List)
 * 		- To display the original 100 unsorted numbers 
 * 				* For loop printing get(index)
 * 		- To insert the numbers from the data structure to the BSTree
 * 				* Created an add method 
 * 				* Depending if its larger or greater it would go to the left or right
 * 				* Or create a new node
 * 		- To print it recursively 
 * 				* I would take the Binary Search Tree and get the root
 * 				* If the root is equal to null - return
 * 				* Plus the left and right values along with the root
 * 
 * 3) LIST THE DATA STRUCTURES
 * 		- Linked List - just to hold the random values (I don't really know why I picked linked list)
 * 		- Created my own Linked list implementation
 * 
 * 4) DESCRIPTION FOR USING THE PROGRAM LIKE MENTIONING INPUT AND OUTPUT HANDLING
 * 		- No input is required. 
 * 		- There will be an output of:
 * 				* 1 - The original 100 random integers (UNSORTED)
 * 				* 2 - Didn't have too, but I showed how the numbers were inserted into the BSTREE
 * 				* 3 - The sorted 100 random numbers - however duplicates are not shown
 * 
 * 5) DESCRIBE PURPOSE OF EACH CLASS/METHOD DEVELOPED
 * 		- Main 
 * 				* Creates random integers
 * 				* Calls methods 
 * 		- printInfix
 * 				* Prints out the values of the Binary search tree - sorts it
 * 		- add
 * 				* Add's the values into the binary search tree into their
 * 				  appropriate postitons (less than or greater than) 
 * 
 * 6) FOR EACH METHOD GIVE PRE AND POST CONDITION AND INVARIANT
 * 		- Done above each method
 * 
 * 7) PROGRAM EXECUTION
 * 		- Runs properly
 * 
 * 8) NAME OF PROGRAM IS SAME AS REQUIRED
 * 		- BSTree.java
 * 
 * 9) PRINT OUT - seperately printed - given to TA
 * 
 */