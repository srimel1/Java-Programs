/***
 * Written by Stephanie Rimel
 * CSC2720
 * 11/27/2018
 * 
 * DESCRIPTION
 * Description of Program
 * You are to write a program name BSTree.java that will:
 * 1.	Generate 100 random integer numbers ranging from 1 – 99.
 * 2.	Store these numbers in a data structure of your choice and display the data on the screen. DO NOT SORT THIS DATA STRUCTURE.
 * 3.	Now build a Binary Search Tree using this set of numbers. You MUST insert the values into the tree starting from the first element of your Data Structure and go sequentially.
 * 4.	After building the tree, use an infix recursive method to display the data on the screen. 
 * 5.	To build the Binary Search Tree, you must create your own Linked List.
 * 

 * 
 * 1) THE PURPOSE OF THE PROGRAM
 * 		- The purpose of this program is to gain experience with Binary Search 
 * 		  Trees. To implement the Binary Search Tree. 
 * 		- Use of recursive methods to traverse through the tree and print the values
 * 		  of the binary search tree 
 *	 	
 * 2) SOLUTION ALGORITHMS
 * 		- To generate 100 random integers
 * 				*  Random Class
 * 				*  Stored in linked list
 * 		- To display the original 100 unsorted numbers 
 * 		- Recursively insert randomly generated values into the Binary Search Tree.
 * 				* implement an insert method
 * 				* Depending on the value of the integer, insert to either left or right 
 * 				* Or create a new node
 * 		- Use an infix recursive method to traverse through the tree and print the values to the screen without sorting.

 * 
 * 3) LIST THE DATA STRUCTURES
 * 		- Linked List - to store random values.
 * 
 * 4) DESCRIPTION FOR USING THE PROGRAM LIKE MENTIONING INPUT AND OUTPUT HANDLING
 * 		- No input is required. 
 * 
 * 5) DESCRIBE PURPOSE OF EACH CLASS/METHOD DEVELOPED
 * 		- Main 
 * 				* to create random integers
 * 				* call the methods from the BSTree class.
 * 		- inorderRec
 * 				* uses an infix recursive method to traverse the tree and print the values to the screen.
 * 		- insert
 * 				* inserts the data into the root node.
 * 		- insertRec - uses recursion to traverse through the tree and insert node in proper place.
 * 
 * 
 * 
 * 8) NAME OF PROGRAM:
 * 		- BSTree.java
 * 
 */

import java.util.*;
public class BSTree {
	//node class 
	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	Node root;
	//BSTree constructor, with no parameters.
	BSTree() {
		root = null;
	}
	//method to insert data
	//accepts an integer data as a parameter.
	void insert(int data) {
		root = insertRec(root, data);
	}
	//recursive method to insert.
	//accepts root and data as parameters.
	Node insertRec(Node root, int data) {
		//if root node is empty, create a new noce and return the root.
		if (root == null) {
			root = new Node(data);
			return root;
		}
		//if data is less than the root, insert left.
		if (data < root.data)
			root.left = insertRec(root.left, data);
		//if data is greater than root, insert right.
		else if (data > root.data)
			root.right = insertRec(root.right, data);

		return root;
	}
	//traverse
	void Inorder() {
		InorderRec(root);
	}
	//traverse recursively
	//PRECONDITION: accepts root as a parameter.
	void InorderRec(Node root) {
		if (root != null) {
			InorderRec(root.left);
			System.out.println(root.data);
			InorderRec(root.right);
		}
	}
	private boolean containsNodeRecursive(Node current, int value) {
	    if (current == null) {
	        return false;
	    } 
	    if (value == current.data) {
	        return true;
	    } 
	    return value < current.data
	      ? containsNodeRecursive(current.left, value)
	      : containsNodeRecursive(current.right, value);
	}
	public boolean containsNode(int value) {
	    return containsNodeRecursive(root, value);
	}
	private Node deleteRecursive(Node current, int value) {
		if (current.left == null && current.right == null) {
		    return null;
		}
		if (current == null) {
	        return null;
	    }
		if (current.right == null) {
		    return current.left;
		}
		 
		if (current.left == null) {
		    return current.right;
		}
	    if (value == current.data) {
	        // Node to delete found
	        // ... code to delete the node will go here
	    } 
	    if (value < current.data) {
	        current.left = deleteRecursive(current.left, value);
	        return current;
	    }
	    current.right = deleteRecursive(current.right, value);
	    return current;
	    
	}
	public void delete(int value) {
	    root = deleteRecursive(root, value);
	    
	}
	private int findSmallestValue(Node root) {
	    return root.left == null ? root.data : findSmallestValue(root.left);
	}
	//The in-order traversal consists of first visiting the left sub-tree, then the root node, and finally the right sub-tree:
	//If we call this method, the console output will show the in-order traversal:
	//3 4 5 6 7 8 9
	public void traverseInOrder(Node node) {
	    if (node != null) {
	        traverseInOrder(node.left);
	        System.out.print(" " + node.data);
	        traverseInOrder(node.right);
	    }
	}
	//Pre-order traversal visits first the root node, then the left subtree, and finally the right subtree:
	//6 4 3 5 8 7 9
	public void traversePreOrder(Node node) {
	    if (node != null) {
	        System.out.print(" " + node.data);
	        traversePreOrder(node.left);
	        traversePreOrder(node.right);
	    }
	}
	//Post-order traversal visits the left subtree, the right subtree, and the root node at the end:
	//nodes in post order:
	//3 5 4 7 9 8 6
	public void traversePostOrder(Node node) {
	    if (node != null) {
	        traversePostOrder(node.left);
	        traversePostOrder(node.right);
	        System.out.print(" " + node.data);
	    }
	}
	/***
	 * Breadth-First Search
This is another common type of traversal that visits all the nodes of a level before going to the next level.

This kind of traversal is also called level-order and visits all the levels of the tree starting from the root, and from left to right.

For the implementation, we’ll use a Queue to hold the nodes from each level in order. We’ll extract each node from the list, print its values, then add its children to the queue:

In this case, the order of the nodes will be:

6 4 8 3 5 7 9	
	 */
	
	public void traverseLevelOrder() {
	    if (root == null) {
	        return;
	    }
	 
	    Queue<Node> nodes = new LinkedList<>();
	    nodes.add(root);
	 
	    while (!nodes.isEmpty()) {
	 
	        Node node = nodes.remove();
	 
	        System.out.print(" " + node.data);
	 
	        if (node.left != null) {
	            nodes.add(node.left);
	        }
	 
	        if (node.right!= null) {
	            nodes.add(node.right);
	        }
	    }
	}
	
	@Test
	public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
	    BSTree bt = createBinaryTree();
	 
	    assertTrue(bt.containsNode(9));
	    bt.delete(9);
	    assertFalse(bt.containsNode(9));
	}
	
	public void givenABinaryTree_WhenAddingElements_ThenTreeContainsThoseElements() {
	    BSTree bt = createBinaryTree();
	 
	    assertTrue(bt.containsNode(6));
	    assertTrue(bt.containsNode(4));
	  
	    assertFalse(bt.containsNode(1));
	}
	//main method.
	//this is a driver to test the BSTree 
	public static void main(String args[]){
		BSTree tree = new BSTree();
		Random rnd=new Random();
		LinkedList<Integer> treeList=new LinkedList<Integer>();
		//adds 100 random integers to LinkedList
		for(int i=0;i<99;i++){
			treeList.add(rnd.nextInt(100)+1);
		}
		//print
		System.out.print("The randomly generated numbers are as follows: \n");
		System.out.print(treeList);
		System.out.println();
		// Inserts the values from the treeList (linked list)
		// into the BSTree tree 
		for(int i=0;i<treeList.size();i++){
			tree.insert(treeList.get(i));
		}
		//prints out the BSTree inorder.
		//duplicates are not included.
		System.out.println("\nThe infix recursive inorder traversal of the tree is as follows: ");
		tree.Inorder();
		BSTree t = new BSTree();
		t.insert(10);
		t.insert(12);
		t.insert(15);
		t.insert(4);
		t.insert(6);
		t.insert(7);
		t.insert(18);
		t.insert(25);
		t.insert(2);
		t.insert(14);
		t.insert(9);
		t.insert(15);
		t.insert(9);
		t.insert(12);
		t.insert(65);
		t.insert(80);
		t.insert(40);
		t.insert(12);
		t.insert(35);
		t.insert(2);
		t.insert(8);
		t.insert(44);
		t.insert(50);
		t.insert(22);
		t.Inorder();
	}
}
//end







