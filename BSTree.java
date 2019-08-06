/*
 * You are to write a program name BSTree.java that will:
 * 	
 * 	1) Generate 100 random integer numbers ranging from 1 - 99.
 * 	2) Store these numbers in a data structure of your choice 
 * 	   and display the data on the screen.	(DO NOT SORT THIS DATA STRUCTURE)
 * 	3) Now build a Binary Search Tree using this set of numbers. You MUST
 * 	   insert the values into the tree starting from the first element of your
 * 	   Data Structure and go sequentially.
 * 	4) After building the tree, use an INFIX RECURSIVE METHOD to display
 * 	   the data on the screen.
 * 	5) To build the Binary Search Tree, you must create your own Linked List.
 */

//-----------------------------------------------------------------------------------

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
import java.util.*;

public class BSTree {
	static LinkedList<Integer> treeList = new LinkedList<Integer>();
	private int data;
	private int root;
	private BSTree left;
	private BSTree right;
	static int c = 0;

	// This is the actual binary tree
	static BSTree tree = new BSTree(100);

	public BSTree(int data){
		this.data = data;
	}

	public void setData(int data){
		this.data = data;
	}

	public int getData(){
		return data;
	}

	public void setRoot(int root){
		this.root = root;
	}

	public int getRoot(){
		return root;
	}

	public void setLeft(BSTree left){
		this.left = left;
	}

	public BSTree getLeft(){
		return left;
	}

	public void setRight(BSTree next){
		this.right = next;
	}

	public BSTree getRight(){
		return right;
	}

	public void setLeft(int data){
		BSTree temp = new BSTree(data);
		temp.left = null;
		temp.right = null;
		temp.data = data;

		this.left = temp;
	}

	public void setRight(int data){
		BSTree temp = new BSTree(data);
		temp.left = null;
		temp.right = null;
		temp.data = data;

		this.right = temp;
	}


	//-----------------------------------------------------------------------------	


	// MAIN CLASS
	// 1) Generate 100 random integer numbers ranging from 1 - 99 [CHECK]
	//Precondition: No inputs.
    //Postcondition: Prints out the layout of the output
	// 				 as well as the 100 random integers, console log, and sorted BSTree
	public static void main(String args[]){	
		int count = 0;
		System.out.println();
		System.out.println("\t\t [BINARY SEARCH TREE]\n");
		System.out.println("[---- 100 Random Unsorted Integers (Between 0 - 99) ----]\n");
		System.out.println("\t Random Number        Count\n");
		for(int i = 0; i <= 100; i ++){
			int random = (int)(Math.random() * 100);
			treeList.add(random);
			System.out.println("\t\t" + treeList.get(i) + "\t\t" + count);
			count++;
		}
		
		System.out.println("-----------------------------------------------------");
		System.out.println("[Console]:");
		// Initialized the root as the very first value in the Linked List
		BSTree myBinarySearchTree = new BSTree(treeList.get(0));
		myBinarySearchTree.setRoot(treeList.get(0));

		// Adds sequentially the values in the treeList (linked list)
		// into the BSTree tree that was initialized to hold the values
		// as a binary search tree would
		for(int i = 0; i < treeList.size(); i++){
			//System.out.println(treeList.get(i));
			myBinarySearchTree.add(treeList.get(i));
		}
		
		System.out.println("-----------------------------------------------------");
		System.out.println("\n  [Infix Recursive Method print out]"
				+ "\n     (Duplicates are not included): \n");
		BSTree.printInfix(myBinarySearchTree);
		System.out.println("-----------------------------------------------------");
	}


	//----------------------------------------------------------------------------
	
	//Precondition: Takes in BSTree root to use root value
    //Postcondition: No return.  Prints the root's left and right values or return nothing
	private static void printInfix(BSTree root){
		if(root == null){
			//System.out.println("\t\tif");
			return;
		} else{
			c++;
			printInfix(root.getLeft());
			System.out.println("\t\t" + root.getData());
			printInfix(root.getRight());
		}
	}

	//----------------------------------------------------------------------------

	//Precondition: Takes in an integer
    //Postcondition: returns false if data == data; otherwise returns true plus how the node is inserted
	public boolean add(int data) {
		if (data == this.data){
			System.out.println("Inserting this.data " + data);
			return false; 
		}
		else if (data < this.data) {
			if (left == null) {
				System.out.println("Inserting new node " + data + " to left");
				left = new BSTree(data);
				return true;
			} else{
				return left.add(data);
			}

		} else if (data > this.data) {
			if (right == null) {
				System.out.println("Inserting new node " + data + " to right");
				right = new BSTree(data);
				return true;
			} else
				System.out.println("Inserting " + data + " to right");
			return right.add(data);
		}
		return false;
	}
}