/***Write a recursive program thst checks if a user gives language tht belongs to the following language
 * L = {S : S is in the form of L = {S:S is in the form of A^nB^2n for some n>=0}
 * Thus a string is in L if and only if it starts with an a and is followed by twice as many B's for example, ABB, AABBB, are in L but AAB or ABBB etc are not in L the empty string also exists in L.
 * @author 
 *
 */
import java.util.Scanner;

public class Quiz2 {

   public static void main(String[] args) {
	   //create scanner
	   Scanner sc = new Scanner(System.in);
       String str;
       char ch;
       //do this until the user enters 'n'
       do{

    	   System.out.println("Enter a string over A,B");
    	   
    	   str = sc.nextLine();
    	   
    	   //Create the language
    	   Language al = new Language();
    	   
    	   //checks the string for the string entered by the user
    	   boolean b = al.check(str);
      
    	   //when b is true, the string is in the language
    	   if(b==true)
           
    		   System.out.println("String belongs to this language");
    	   
    	   //when b is false, it is not in the language
    	   else
           
    		   System.out.println("String does not belong to this language");
           
    	   //prompt user to try again or quit
    	   System.out.println("Do you want to try again(y/n)");
         
    	   ch = sc.nextLine().charAt(0);
          
       }while(ch!='n');
   }
}

//creates the language class to define your language
 class Language{
	
//method to check the string
   public boolean check(String s){
       int i, acount=0, bcount=0;
       
       //loop to scan through the string
       for(i=0;i<s.length();i++){
        
    	   char x = s.charAt(i); //scans each character at the index
           
    	   if(x=='A'){
    		   acount++;
    	   }
           
    	   if(x=='B'){
    		   bcount++;
    	   }
    	   
    	   check(s.substring(1));
       }
       
       if(acount/2==bcount) return true;
     
       else return false;
    	   
   }
}


