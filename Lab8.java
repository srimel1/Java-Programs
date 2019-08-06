import java.util.Stack;

public class Lab8 {

	public static int postfixEvaluate(String s){
		
		Stack<Integer> mystack = new Stack<Integer>(); //stack of type integer
		
		for(int i = 0; i < s.length(); i++){ //iterates through string by char
						
			char ch = s.charAt(i); //sets char at i to ch
			
			if(ch > 48 && ch < 57){ //ch = 0-9
				
				mystack.push(ch-48); //pushes int to stack (48 = '0', tf, ch-48=num)
				
			}
			else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){ //ch = +,-,*,/
				
				char o = ch; //operator saved as o
				
				int b = mystack.pop(); //pops top
				int a = mystack.pop(); //pops top-1
				
				 if(o == '+'){ //if o is '+', (top-1)+top
					 mystack.push(a + b);
				 }
			     else if(o == '-'){//if o is '-', (top-1)-top
			    	 mystack.push(a - b);
			     }
			     else if(o == '*'){//if o is '*', (top-1)*top
			    	 mystack.push(a * b);
			     }
			     else if(o == '/'){//if o is '/', (top-1)/top
			    	 mystack.push(a / b);
			     }
				
			}
		}
		return mystack.pop(); //return result of postfix
	}
	
	public static void main(String[] args){
		
		System.out.println(postfixEvaluate("6 8 2 / 1 - *"));
		/*6 8 2 / 1 - *
		 * 6 (8/2) 1 - *
		 * 6 (4-1) *
		 * 6*3
		 * 18
		 */
		System.out.println(postfixEvaluate("8 5 * 7 4 2 + * +"));
		/*8 5 * 7 4 2 + * +
		 * 8*5 7 4 2 + * +
		 * 40 7 4+2 * +
		 * 40 7*6 +
		 * 40+42
		 * 82
		 */
		System.out.println(postfixEvaluate("2 3 + 4 5 * +"));
		/*2 3 + 4 5 * +
		 * 2+3 4 5 * +
		 * 5 4*5 +
		 * 5+20
		 * 25
		 */
	}
	
}