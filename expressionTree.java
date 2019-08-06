/*Author Ryan Henao expressionTree.java
 * Date 12/2/2013
 * Hw #6 Bhola CSC 3410  MW 1:30-2:45
 * 1.The purpose of this program is to write a calculator that takes an expression and gives an answer.
 * It can also take in variables and use those to evaluate the expression. It checks for errors in the expression
 * and creates an expression tree as well.
 * 2. The solution to the problem is to take the infix expression and convert it to postfix.
 * This is done using an operator stack. The postfix expression is then parsed into an expression tree 
 * and is also sent into the calculator. The calculator uses an operand stack to evaluate the input
 * and create an output. The tree should also hold the expression as well. 
 * 3.The data structures used in this program are- arrays, linked lists, stacks, and binary trees.
 * Arrays are used to hold the expression. The stacks are used to perform conversions. 
 * The binary tree is used to hold the expression in tree parse format.
 * 4. The input to this program is an expression that should be valid but it does offer basic error checking.
 * The expression must use valid characters as well. The other input is a variable.
 * The output is the evaluation of the expression including variables. This will be an integer number
 * 5.there are five Classes. expression Tree is the main and it is the driver class. 
 * It also provides error checking. TreeParse builds the tree given the expression.
 * postFix converts the expression to postFix. And calculator evaluates the expression.
 * Node is used to store the node info
 */

import java.util.Stack;
import java.util.Scanner;
public class expressionTree {
		
	public static Stack<Object> operatorStack = new Stack<Object>();
		
	public static Stack<Object> operandStack = new Stack<Object>();
		
	public static Stack<Object> treeStack = new Stack<Object>();
	
	public static Stack<Object> parenStack = new Stack<Object>();
	
	public static void main(String args[]){
		
		String[] expression;
		
		Scanner input = new Scanner(System.in); //get user input
		
		System.out.print("Enter an expression:  ");
		String answer = input.nextLine().replaceAll("\\s+",""); //remove all spaces
		
		if(errorCheck(answer)) //check for errors
			System.exit(0);
		
		expression = postFix.convertPost(answer);  //convert to postfix then send to parseLine
		
		System.out.print("Converted expression: ");
		for(String string: expression)
			System.out.print(string);
		
		TreeParse.parseLine(answer); //creates an expression tree
		
		System.out.println(); //new line
		
		while(true){
			System.out.println("Enter an x value: ");
			String x = input.nextLine();
				if(x.equals("q")){
					break;
				}
				
			int y = Integer.parseInt(x);
			Calculator.calculate(expression,y);
		}
		
		
		input.close();
	}
	
	//takes a string that should be an expression and stops program if error found
	public static boolean errorCheck(String answer){
		if(answer.indexOf(".") != -1){
			System.out.println("Error cannot accept floating points");
			return true;
		}else if(!TreeParse.checkOperand(answer.substring(answer.length()-1)) && !answer.substring(answer.length()-1).equals(")") ){
			System.out.println("Error, need operand as last Token");
			return true;
		}
		//check for error on parentheses
		for(int i =0;i<answer.length();i++){
			String curr = answer.substring(i,i+1);
			if(curr.equals("(")){
				parenStack.push(curr);
			}else if(curr.equals(")") && (parenStack.empty() || parenStack.peek().equals(")")) ){
				parenStack.push(curr);
			}else if(curr.equals(")") && parenStack.peek().equals("(")){
				parenStack.pop();
			}
		}
		if(!parenStack.empty()){
			System.out.println("Error parentheses do not match");
			return true;
		}
		return false;		
	}
	//returns true or false. Program terminates on false
	
}
 class postFix {
	//takes a string and returns it in postfix array format
	public static String[] convertPost(String string) {
		int index = 0;
		String[] result = new String[string.length()+20];
		for(int x = 0;x<result.length;x++){
			result[x]="";
		}
		//assuming input string is already error checked and has had spaces removed
		for(int i = 0;i<string.length();i++){
			String currentChar = string.substring(i,i+1);
			String topOfStack = "";
			
			if(!expressionTree.operatorStack.empty()){
				topOfStack  = (String) expressionTree.operatorStack.peek();
			}
			
			if(TreeParse.checkOperand(currentChar)){
				result[index]+=currentChar;
				//result+=currentChar;
			}else{
				index++;
				if(expressionTree.operatorStack.empty()){
					expressionTree.operatorStack.push(currentChar);
				}else if(precedenceCheck(currentChar, topOfStack)){
					expressionTree.operatorStack.push(currentChar);
				}else{
					while(!expressionTree.operatorStack.empty() && !precedenceCheck(currentChar, topOfStack) && !topOfStack.equals("(")){
						result[index]+=topOfStack;
						expressionTree.operatorStack.pop();
						if(!expressionTree.operatorStack.empty())
							topOfStack = (String) expressionTree.operatorStack.peek();
					}
					
					if(currentChar.equals(")"))
						expressionTree.operatorStack.pop();
					else
						expressionTree.operatorStack.push(currentChar);
				}
				index++;
			}
			
		}
		if(!result[index].equals(null))
			index++;
		while(!expressionTree.operatorStack.empty()){
			result[index]+=expressionTree.operatorStack.peek();
			//result+=expressionTree.operatorStack.peek();
			expressionTree.operatorStack.pop();
			index++;
		}
		return result;
	}
	//result is now an array with each element representing one char or number
	//also is in postfix
	
	// returns true if currentChar is higher on precedence than topOfStack
	public static boolean precedenceCheck(String currentChar, String topOfStack){
		int curChar = 0;
		int stackChar = 0;
		
		//give precedence and compare
		switch(currentChar){
		case "(": curChar = 4;
			break;
		case "_": curChar = 3;
			break;
		case "&": curChar = 3;
			break;
		case "*": curChar = 2;
			break;
		case "/": curChar = 2;
			break;
		case "%": curChar = 2;
			break;
		case "+": curChar = 1;
			break;
		case "-": curChar = 1;
			break;
		}
		
		switch(topOfStack){
		case "_": stackChar = 3;
			break;
		case "&": stackChar = 3;
			break;
		case "*": stackChar = 2;
			break;
		case "/": stackChar = 2;
			break;
		case "%": stackChar = 2;
			break;
		case "+": stackChar = 1;
			break;
		case "-": stackChar = 1;
			break;
		case "(": stackChar = 0;
		break;
	}
		
	if(curChar > stackChar)
		return true;
	return false;
	}
}
  class Calculator {
		
		//takes an and variable array and calculates using stack
		//variable must be given but it might not be used if not in expression
		public static void calculate(String[] input,int x){
			expressionTree.operandStack.removeAllElements();
			
			for(int i = 0;i<input.length;i++){
				String currentChar = input[i];
				if(currentChar.equals("") || currentChar == null){
					continue;
				}
				if(TreeParse.checkOperand(currentChar)){
					expressionTree.operandStack.push(currentChar);
				}else{
					checkOp(currentChar,x); //method that performs stack operations
				}
			}
			System.out.println(expressionTree.operandStack.peek());
		}
		
		//does an operation depending on the symbol
		//takes the symbol and the possible variable x
		//operates on top two stack elements unless unary
		public static void checkOp(String currentChar,int x){
			int opA;
			int opB;
			int c;
			
			if(currentChar.equals("+")){
				try{
					opA = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opA = x;
				}
				
				expressionTree.operandStack.pop();
				
				try{
					opB = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opB = x;
				}
				
				expressionTree.operandStack.pop();
				
				c = opB+opA;
				expressionTree.operandStack.push(c+"");
			}else if(currentChar.equals("-")){
				try{
					opA = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opA = x;
				}
				
				expressionTree.operandStack.pop();
				
				try{
					opB = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opB = x;
				}
				expressionTree.operandStack.pop();
				
				c = opB-opA;
				expressionTree.operandStack.push(c+"");
			}else if(currentChar.equals("*")){
				try{
					opA = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opA = x;
				}
				
				expressionTree.operandStack.pop();
				
				try{
					opB = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opB = x;
				}
				expressionTree.operandStack.pop();
				
				c = opB*opA;
				expressionTree.operandStack.push(c+"");
			}else if(currentChar.equals("/")){
				try{
					opA = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opA = x;
				}
				
				expressionTree.operandStack.pop();
				
				try{
					opB = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opB = x;
				}
				expressionTree.operandStack.pop();
				
				c = opB/opA;
				expressionTree.operandStack.push(c+"");
			}else if(currentChar.equals("%")){
				try{
					opA = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opA = x;
				}
				
				expressionTree.operandStack.pop();
				
				try{
					opB = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opB = x;
				}
				expressionTree.operandStack.pop();
				
				c= opB%opA;
				expressionTree.operandStack.push(c+"");
			}else if(currentChar.equals("_")){
				try{
					opA = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opA = x;
				}
				
				expressionTree.operandStack.pop();
			
				c = opA*-1;
				expressionTree.operandStack.push(c+"");
			}else{
				try{
					opA = Integer.parseInt((String) expressionTree.operandStack.peek());
				}catch(Exception e){
					opA = x;
				}
				
				expressionTree.operandStack.pop();
				
				c = opA;
				
				expressionTree.operandStack.push(c+"");
			}
				
		}
		//top two elements have now been operated on
	}