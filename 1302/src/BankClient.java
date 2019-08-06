
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class BankClient {
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
            System.out.printf("%nAccount with number %s has balance of $%.2f%n",
                               accountNumber, target.getBalance() ) ;
      	 }
        //sets account the account balance of 001 to my last 5 digis of my gsu id 
        //divided by 100.0
        double balance2 = 96018/100.0;
        acct[001].setBalance(balance2);
        bank.printList();
        
        //returns the account with the largest balance
        PayPalAccount max = bank.getMaximum();
        System.out.printf( "%nAccount with number %s has the largest balance"
                + " ($%.2f)%n", max.getAccountNumber(),
                max.getBalance()) ;
	
        //returns the account with the lowest balance
        PayPalAccount min = bank.getMinimum();
        System.out.printf( "%nAccount with number %s has the lowest balance"
                + " ($%.2f)%n", min.getAccountNumber(),
                min.getBalance()) ;
        
        //computes the average of all account balances.
        DecimalFormat df = new DecimalFormat("#.00");
		double average = bank.getAverageBalance();
		System.out.println("\nAverage of all accounts is: " + 
                df.format(average) ) ;
		
		s.close();
	}
		
}
