public class Stack {

	private int top;
	private int size;
	private char[] stack;
	
	public Stack(int arraySize) {
		size = arraySize;
		stack = new char[size];
		top = -1;
	}
	
	public boolean pop() {
		
		System.out.println("Pop opperation done!\n" + (top) + " is popped");
		
		if(isEmpty() == false) {
			
			top = top-1;
		}
		else {
			
			System.out.println("Stack is empty. Can't pop.");
		}
		return false ;
	}
	
	public boolean push(char a) {
		
		System.out.println("Element " + a + " is pushed to Stack!");
		
		if(top == (size-1)) {
			System.out.println("Stack is full");
		}
		else {
			top = top+1;
			stack[top] = a;
		}
		return false;
	}
	
	public char peek() {
		
		System.out.println("Peek is: " + stack[top]);
		return stack[top];
	}
	
	public boolean isEmpty() {
		
		System.out.print("Is the stack empty? ");
		
		if(top == -1) {
			
			return true;
		}
		return false;
	}
	
	public void printStack() {
		
		System.out.println("Elements in the stack are (top -> bottom):");
		
		for(int i = 0; i <= top; i++) {
			System.out.print(stack[i] + " ");
		}
		
		System.out.println("\n");
	}
	
	
}