import phonedir.directory;

// #### Data Structure Lab #### //
// I have implemented a skeleton for custom LinedList that we were discussing previously.
// Understand the following code and fill in the rest of Todo implementations.
// Test all of the implemented methods.
// Extend this linked list to handle forward linking(Double LinkedList)? That means each node will also point to the previous Node:
	 // I have added an attribute 'previous' in Node class.
	// Use conventions getLastReverse(), removeLastReverse(), addFirstReverse()... so on...

//Discuss the following:
//1. Why root, getLastNode and, Node are private?
//2. Why Node class is inside LinkedList? What if I put it in another .java file and use by importing?
//3. Now think about how abstraction has been used to implement LinkedList(an abstract datatytpe?)

class LinkedList{
    private Node head;
    
    public void addLast(Object o){
        if (this.head == null) this.head = new Node(o);
        else getLastNode().next = new Node(o);
    }
    
    
    private Node getLastNode(){
       Node last = this.head;
	// Why two conditions in while loop
       while(last!=null && last.next!=null){ 
            last = last.next;
       }
       return last;
    }
    
    public Object getLast(){
	//Why return .value instead of just Node?
        return this.getLastNode().value;
    }
    
    public void addFirst(Object o)
    {
       this.head = new Node(o);
    }
    
    public void remove(Object key){
        // Todo
    	if(head == null) throw new RuntimeException("cannot delete");
    	if(head.equals(key) == true) {
    		head = head.next;
    	return;
    	}
    	Node current = head;
    	Node previous = null;
    	
    	while(current != null && !current.equals(key)) {
    		previous = current;
    		current = current.next;
    	}
    	if(current == null) throw new RuntimeException("cannot delete");
    	previous = current.next;
    	
    }
    
    public void removeFirst(){
        // Todo
    	this.head = null;
    }
    
    public Node getFirst(){
        // Todo
        return head;
    }
    
    private Node getFirstNode() {
		return head;
	}

	public int size(){
        // Todo
        return 0;
    }
    
    private class Node{
	Node previous;
        Object value;
        Node next;
        public Node(Object value){
            this.value = value;
        }
    }

	public directory get(int currentData) {
		// TODO Auto-generated method stub
		return null;
	}
     
}

public class App{
    public static void main(String []args){
        LinkedList ll = new LinkedList();
        ll.addLast("Apple");
        ll.addLast("Red Apple");
        System.out.println(ll.getLast());
     }
}
 
