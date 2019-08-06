public class Test {

	public static void main(String[] args) {
		
		
		Character[] arr = {'H','E','Y','Y','E','Y','A','A','E','Y'}; 
			
		Stack s = new Stack(arr.length);
		
		System.out.println(s.isEmpty() + "\n");
		
		for(int i = 0; i < arr.length; i++) {
			
			s.push(arr[i]);
			s.printStack();
		
		}
		
		s.pop();
		s.printStack();
		
		s.peek();
		s.printStack();
		
		System.out.println(s.isEmpty() + "\n");
	
	}
}