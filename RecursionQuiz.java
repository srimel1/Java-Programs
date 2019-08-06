import java.util.Arrays;
import java.util.Scanner;


public class RecursionQuiz {
	public static void main(String[] args){
		String search = "AAB";
		String w = "AABB";
		char[] ch = search.toCharArray(); 
		System.out.println(Arrays.toString(ch));
		System.out.println(String.valueOf(ch));
		String s4 = String.valueOf(ch);
	    w = w.replace(s4,"");
		System.out.println(w);
		System.out.println(s4);
		
		
		Scanner s = new Scanner(System.in);
		String again = null;
		String str = null;

		do {
			System.out.println("Please enter a string of A's and B's to check if it is in the language: ");
			str = s.nextLine().toUpperCase().trim();

			if(IsIn(str)){
				System.out.println("The string " + str + " is in the language.");
			}
			else{
				System.out.println("The string " + str + " is NOT in the language ");
			}

			System.out.print("\nWould you like to run the program again(Y/N)?"); //ask user if the want to run the program again.
			again = s.next().toUpperCase();
		} while (again.equalsIgnoreCase("Y"));

	}
	public static boolean IsIn(String w){
		
		String search = "ABB";//pattern to search for
		
		//if the string is empty, return false
		if(w==null)
			return false;
		
		//if there is only one character, A or B, returns true
		if(w.length() == 0){ 
			return true;
		}
		//if the string is longer than 0...
		else if(w.length() != 0){

			//...scan the string for the pattern 'AAB'
			if(w.contains(search)){ 

				//if target pattern is found, split the string input into a character array.
				char[] ch = search.toCharArray(); 
				
				//traverse through the character array
				for(int i = 0; i < ch.length; i++){ 

					String s = String.valueOf(ch); 

					w = w.replace(s, ""); 
				}
				return IsIn(w); 
			}
		}
		return false; 
	}
}