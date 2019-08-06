

//-----------------------------------------------------------------------------------

/*
 * Stephanie Rimel
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
 * 		- Linked List - just to hold the random values 
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
	class Node_Tree {
		int data;
		Node_Tree Left_child, Right_child;

		public Node_Tree(int item) {
			data = item;
			Left_child = Right_child = null;
		}
	}

	Node_Tree Root_tree;
	BSTree() {
		Root_tree = null;
	}

	void Insert(int data) {
		Root_tree = InsertRec(Root_tree, data);
	}

	Node_Tree InsertRec(Node_Tree Root_tree, int data) {

		if (Root_tree == null) {
			Root_tree = new Node_Tree(data);
			return Root_tree;
		}


		if (data < Root_tree.data)
			Root_tree.Left_child = InsertRec(Root_tree.Left_child, data);
		else if (data > Root_tree.data)
			Root_tree.Right_child = InsertRec(Root_tree.Right_child, data);


		return Root_tree;
	}

	void Inorder() {
		Recusion_Inorder(Root_tree);
	}


	void Recusion_Inorder(Node_Tree Root_tree) {
		if (Root_tree != null) {
			Recusion_Inorder(Root_tree.Left_child);
			System.out.println(Root_tree.data);
			Recusion_Inorder(Root_tree.Right_child);
		}
	}
	public static void main(String args[]){
		BSTree Btree = new BSTree();
		Random rnd=new Random();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		for(int i=0;i<99;i++){
			arr.add(rnd.nextInt(99)+1);
		}
		System.out.print("The numbers are: \n");
		System.out.print(arr);
		for(int i=0;i<arr.size();i++){
			Btree.Insert(arr.get(i));
		}
		System.out.print("Inorder of Btree is :\n");
		Btree.Inorder();
	}
}

