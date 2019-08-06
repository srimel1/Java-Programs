/***
 * stephanie rimel
 * calc program
 * accepts an infix expression
 * evaluates for x
 * displays appropriate error messages
 */
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
import java.util.InputMismatchException;
public class calc {
	//error exceptions
	public static class ParseException extends Exception {
		public ParseException(String message) { super(message); }
	}
	public static ArrayList<Token> lex(String str) throws ParseException {
		ArrayList<Token> tokens = new ArrayList<>();
		int i = 0;
		while (i < str.length()) {
			char c = str.charAt(i);
			switch (c) {
			case ' ':
				break;
			case '(':
				tokens.add(new Token(TokenKind.LeftParen));
				break;
			case ')':
				tokens.add(new Token(TokenKind.RightParen));
				break;
			case '*':
				tokens.add(new Token(TokenKind.Mul));
				break;
			case '/':
				tokens.add(new Token(TokenKind.Div));
				break;
			case '%':
				tokens.add(new Token(TokenKind.Mod));
				break;
			case '-':
				tokens.add(new Token(TokenKind.Sub));
				break;
			case '+':
				tokens.add(new Token(TokenKind.Add));
				break;
			case 'x':
				tokens.add(new Token(TokenKind.Var));
				break;
			case '0': case '1': case '2':
			case '3': case '4': case '5':
			case '6': case '7': case '8':
			case '9':
				Scanner num = new Scanner(str.substring(i,str.length())).useDelimiter("\\D");
				long l = num.nextLong();
				tokens.add(new Token(TokenKind.Number,l));
				i += (int)(Math.log10(l) + 1);
				continue;
			case '.':
				throw new ParseException("Cannot accept floating point numbers." + 
						"");
			default:
				throw new ParseException("Invalid char: " + c);
			}
			i++;
		}
		return tokens;
	}
	//error messeges
	public static ArrayList<Token> postFix(ArrayList<Token> tokens) throws ParseException {
		ArrayList<Token> output = new ArrayList<>();
		Stack<Token> operators  = new Stack<Token>();
		int balParens = 0;
		Token lastToken = null;
		for (Token current: tokens) {
			switch (current.getTokenKind()) {
			case Var: case Number:
				if (lastToken != null && lastToken.wasOperand()) {
					throw new ParseException("No operator between operands. Also last token must be an operand." );

				}
				output.add(current);
				break;
			case LeftParen:
				if (lastToken != null && !lastToken.wasOperator()) {
					throw new ParseException("No operator between operand and left parentheses.");
				}
				operators.push(current);
				balParens++;
				break;
			case RightParen:
				while (true) {
					if (operators.empty()) {
						throw new ParseException("No matching left parentheses for a right parentheses.");
					}
					Token t = operators.pop();
					if (t.typeIs(TokenKind.LeftParen)) break;
					output.add(t);
				}
				balParens--;
				break;
			case Mul: case Div: case Mod:
			case Sub: case Add:
				if (lastToken != null && lastToken.wasOperator()) {
					String err = "The " + current + " operator cannot be preceded by a " + lastToken + " operator.";
					throw new ParseException(err);
				}
				while (!operators.empty() &&
						current.precedence() <= operators.peek().precedence()) {
					output.add(operators.pop());
				}
				operators.push(current);
				break;
			}
			lastToken = current;
		}
		if (0 < balParens) throw new ParseException("No matching right parentheses for a left parentheses.");
		while (!operators.empty()) {
			output.add(operators.pop());
		}
		return output;
	}
	/**
	 * @preconditions: accepts parameters: tokens and long enviornment
	 * @return evaluated expression
	 **/
	public static Long evaluate(ArrayList<Token> tokens, Long environment) {
		Stack<Long> operands = new Stack<>();
		for (Token current: tokens) {
			TokenKind tk = current.getTokenKind();
			switch (tk) {
			case Var:
				operands.push(environment);
				break;
			case Number:
				operands.push(current.getNumber());
				break;
			default:
				Long op1 = operands.pop();
				Long op2 = operands.pop();
				switch (tk) {
				case Mul:
					operands.push(op2 * op1);
					break;
				case Div:
					operands.push(op2 / op1);
					break;
				case Mod:
					operands.push(op2 % op1);
					break;
				case Sub:
					operands.push(op2 - op1);
					break;
				case Add:
					operands.push(op2 + op1);
					break;
				}
			}
		}
		return operands.pop();
	}
	//main method
	public static void main(String[] args) {
		boolean notFoundValid = true;
		ArrayList<Token> tokens = null;
		//scanner
		Scanner s = new Scanner(System.in);
		
		while (notFoundValid) {
			//user infix input
			System.out.print("Enter infix expression: ");
			String expression = s.nextLine().trim();
			try {
				tokens = postFix(lex(expression));
				String out = "";
				for (Token t: tokens) {
					out += t + " ";
				}
				//the converted expression
				System.out.println("Converted expression: " + out);
				notFoundValid = false;
				//catch error
			} catch (ParseException pe) {
				System.out.println("Error in expression!! " + pe.getMessage());
			}
		}
		boolean running = true;
		while (running) {
			try {
				//user input: the value of x
				System.out.print("Enter value of x: ");
				Long environment = s.nextLong();
				//evaluates epression
				System.out.println("Answer to expression: " + evaluate(tokens,environment));
			} catch (InputMismatchException e) {
				//exit the program
				String quit = s.nextLine();
				if (0 < quit.length() && quit.charAt(0) == 'q') {
					running = false;
					//Goodbye!
					System.out.println("Have a great day!");
				} else {
					System.out.println("Please either enter an integer or 'q' to quit.");
				}
			}
		}

	}
}