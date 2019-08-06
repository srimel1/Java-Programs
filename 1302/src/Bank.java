//Stephanie Rimel 
import java.util.ArrayList ;
import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
import java.io.IOException ;

/**
   This bank contains a collection of PayPal accounts.
*/
public class Bank{   
	public static void main(String[] args) throws IOException  {
		int numOfAccounts = 0;
		Scanner s = new Scanner(System.in);
		//prompts user to enter the number of accounts they wish to create
		System.out.println("How many accounts do you want to create?");
		if(numOfAccounts<=1000) {
		 numOfAccounts = s.nextInt();
		}else {
			System.out.println("You can only create up to 1000 accounts.");
		}
		
		Random rand = new Random();
		//creates a new bank
		Bank bank = new Bank() ;
		//creates an array of account objects
		PayPalAccount[] acct = new PayPalAccount[numOfAccounts];
		

		
		//generates random numbers and assigns them as the balances in all accounts, count is assigned as the accountID
		for(int i = 0; i < acct.length; i++) {
			acct[i] = new PayPalAccount(rand.nextDouble()*1000, i);
			bank.addAccount( acct[i] ) ;
			}
		
		//displays the accounts
		bank.printList();
		
		//searches for an account with an ID of 001. If there is not account 
		//then the last account is changed to 001 and the balance of the 1st 
		//account is transfered to the last account.
		String accountNumber = "001";
        PayPalAccount target = bank.find(accountNumber) ;
        if (target == null) {
            System.out.println("\nNo account with number " + accountNumber) ;
      	acct[acct.length-1].setAccountNumber(50);
      	acct[0].transferTo(acct[acct.length-1], acct[0].getBalance());
      	System.out.println("Last account number changed to " + accountNumber +". Balance of account 0 transfered to account " + accountNumber);
      	bank.printList();
	      	 
      	 }else {
            System.out.printf("  %nAccount with number %s has balance of $%.2f%n",
                               accountNumber, target.getBalance() ) ;
      	 }
        //sets account the account balance of 001 to my last 5 digis of my gsu id 
        //divided by 100.0
        double balance2 = 96018/100.0;
        acct[001].setBalance(balance2);
        bank.printList();
        
        //returns the account with the largest balance
        PayPalAccount max = bank.getMaximum();
        System.out.printf( "  %nAccount with number %s has the largest balance"
                + " ($%.2f)%n", max.getAccountNumber(),
                max.getBalance()) ;
	
        //returns the account with the lowest balance
        PayPalAccount min = bank.getMinimum();
        System.out.printf( "  %nAccount with number %s has the lowest balance"
                + " ($%.2f)%n", min.getAccountNumber(),
                min.getBalance()) ;
        
        //computes the average of all account balances.
        DecimalFormat df = new DecimalFormat("#.00");
		double average = bank.getAverageBalance();
		System.out.println("  \nAverage of all accounts is: " + 
                df.format(average) ) ;
		
		s.close();
	}
		


   private ArrayList<PayPalAccount> accounts ;  // a list of BankAccount objects
   
   /*
      Constructs a bank with no bank accounts.
   */
   public Bank()
   {
      accounts = new ArrayList<PayPalAccount>() ;
   }

   /**
      Adds an account to this bank.
      @param a the account to add
   */
   public void addAccount(PayPalAccount a)
   {
      accounts.add(a) ;		// calls "add" method of ArrayList class
   } 
   
   /**
      Print data for all accounts to the screen
   */
   public void printList() throws IOException 
   {
            
      // print headings to screen
      System.out.printf("%15s%20s%n","Account Number","Account Balance") ;
      
      System.out.printf("%15s%20s%n","==============","===============") ;
        
      // for each account in this bank
      for ( int i = 0 ; i < accounts.size() ; i++ )
      {
         PayPalAccount current = accounts.get( i ) ;	  // get next account
         
         // print account number and balance to screen
         System.out.printf("%15s     $%14.2f%n",current.getAccountNumber(),
                           current.getBalance()) ;

      }
      
   
   }
/**
 * 
 * @returns the average of all accounts
 */

   public double getAverageBalance()
   {
	  
      double total = 0;
      
      // for each account in this bank
      for ( int index = 0 ; index < accounts.size() ; index++)
      {
    	  
          PayPalAccount current = accounts.get(index) ;   // get the account
          total = total + current.getBalance() ;  // add its balance to accum
          
      }
      return total/accounts.size();
   }

   

   /**
      Search to find a bank account with a given account number.
      @param acctID the number to find
      @return the account with the given number
   */
   public PayPalAccount find(String acctID)
   {
      for ( int i = 0 ; i < accounts.size() ; i++ )
      {
         PayPalAccount current = accounts.get( i ) ;          // get the account
	 String accountNum = current.getAccountNumber()	;  // get account number
	 if ( accountNum.equals(acctID) )  		   
             return current ;			
      } 
      return null ; // No match in the entire array list
   }

   /**
      Gets the bank account with the largest balance.
      @return the account with the largest balance, or null if the
      bank has no accounts
   */
   public PayPalAccount getMaximum()
   {
      if (accounts.size() == 0) 		// if no accounts, return null
        return null;
      
      // assume first account is the largest 
      PayPalAccount largest = accounts.get(0) ;
      
      // for all other accounts
      for ( int i = 1; i < accounts.size(); i++ ) 
      {
         PayPalAccount current = accounts.get(i) ;		// get next account
         // is current account > highest so far?
         if (current.getBalance() > largest.getBalance())
            largest = current ;
      }
      return largest ;
   }
   public PayPalAccount getMinimum()
   {
      if (accounts.size() == 0) 		// if no accounts, return null
        return null;
      
      // assume first account is the largest 
      PayPalAccount lowest = accounts.get(0) ;
      
      // for all other accounts
      for ( int i = 1; i < accounts.size(); i++ ) 
      {
         PayPalAccount current = accounts.get(i) ;		// get next account
         // is current account > highest so far?
         if (current.getBalance() < lowest.getBalance())
            lowest = current ;
      }
      return lowest ;
   }
}