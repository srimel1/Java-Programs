import java.util.Arrays;


// Stacks are LAST IN LAST OUT
public class TheStack {
	
	private String[] stackArray;
	private int stackSize;
	
	//sets stack as empty
	private int topOfStack = -1;
	
	public TheStack(int size){
		
		stackSize = size;
		
		stackArray = new String[size];
		
		Arrays.fill(stackArray, "-1");
	}
	
	public void push(String input) {
	
		if(topOfStack+1 < stackSize) {
		
			topOfStack++;
			
			stackArray[topOfStack] = input;
		
		}else System.out.println("Sorry the stck is full");
		
		displayTheStack();
		
		System.out.println("PUSH: " + input +" was added to the stack.");
		
	}
	
	public String pop() {
	
		if(topOfStack >= 0) {
		
			displayTheStack();
			
			System.out.println("POP: "+ stackArray[topOfStack] + " was removed from the stack");
			
			stackArray[topOfStack] ="-1"; 
			
			return stackArray[topOfStack--];
		
		}else {
		
			displayTheStack();
			
			System.out.println("Sorry but the stack is empty.");
			
			return "-1";
		
		}
	}
	
	public String peek() {
	
		displayTheStack();
		
		System.out.println("PEEK " + stackArray[topOfStack] +" is at the top of the stack");
		
		return stackArray[topOfStack];
	
	}
	
	public void pushMany(String multipleValues) {
	
		String[] tempString = multipleValues.split(" ");
		
		for(int i = 0; i < tempString.length; i++) {
		
			push(tempString[i]);
		}
	}
	
	public void popDisplayAll() {
	
		String theReverse = "";
		
		for(int i = topOfStack; i >= 0 ; i--) {
		
			theReverse += stackArray[i];
			
		}
		
		System.out.println("The Reverse: " + theReverse);
		
		popAll();
	}
	
	public void popAll() {
		
		for(int i = topOfStack; i >= 0; i--) {
		
			pop();
		}
	}

	public void displayTheStack() {
	
		for(int i = 0; i < 61; i++)
		
			System.out.print("-");
			
		System.out.println();
		
		for(int i = 0; i<stackSize; i++) {
		
			System.out.format("| %2s "+ " ", i);
			
		}
		
		System.out.println("|");
		
		for(int i = 0; i < 61; i++)
		
			System.out.print("-");
			
		System.out.println();
		
		for(int i = 0; i < stackSize; i++) {
		
			if(stackArray[i].equals(-1)) 
			
				System.out.print("|    ");
				
			else System.out.print(String.format("| %2s "+ " ", stackArray[i]));
			
		}
		
		System.out.println("|");
		
		for(int i = 0; i < 61; i++) System.out.print("-");
		
		System.out.println();
	}
	
	
	public static void main(String[] args) {
	
		TheStack theStack = new TheStack(10);
		theStack.displayTheStack();
		theStack.pushMany("1 2 4");
		
		theStack.pop();

		
	}
}
