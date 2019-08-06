public class IsInRecur
{
	public static boolean IsIn(String w){   
		if ( w.length() == 0 ) //Base case, ie we reduced the string to size 0. Hence returns true.
		{
			return true;
		}
		else if ( w.contains( "ABB" )) //Logical case, check if the string has AnB3n substring,
		{
			// if yes then we reduce ABBB from it recur, till we reduce it to length 0. (Base case)
			System.out.println(w);
			w = w.replace("ABB","");

			return IsIn(w);
		}
		else
		{
			// this is the case when the string doesnt match the format AnB3n, so return false.

			return false;
		}

	}


	public static void main(String[] args)
	{
		//String str ="AAABBBBBBBBB";
		String s = "AABBB";
		System.out.println(check(s));
//		if(IsIn(str))
//			System.out.println("The string " + str + " is in the language.");
//		else
//			System.out.println("The string " + str + " is in NOT the language.");

	}
	public static boolean check(String w){
		if(w.length()==0) return true;
		else if(w.substring(0,2).equals("AA") && w.substring(w.length()-3).equals("BBB"))
			return check(w.substring(2, w.length()-3));
		return false;
	}

}