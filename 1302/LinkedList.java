/**
 * implement your own linked list
 * create a linkedlist class that will have two variables:
 * 1.value: will store value (string or int)
 * 2. next: will store another linkedlist object
 * methods:
 * 1. genNext(): returns next linkedlist object
 * 2. getValue(): shoild return its own value
 * 3. add(LinkedList to Add)
 * a. this linkedlist should point to toAdd
 * b. makes sure that this linkedlist is not already pointing to another one, or if next is not null.
 * 
 *
 */
public class LinkedList {
	private int value;
	private LinkedList next;
	LinkedList toAdd;
	LinkedList current;
	
	public void add(LinkedList toAdd) {
		this.next = toAdd;
	//	if(next != null) {
			
			
	//	}else(next == null){
	}
	public LinkedList getNext() {
		return next;
	}
	public int getValue() {
		return value;
	}
	
}
