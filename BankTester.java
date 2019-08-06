import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class BankTester
{
   public static void main(String[] args) throws IOException
   {
      // create Bank object
      Bank firstBankOfJava = new Bank() ;
      
      // "priming" read
      
      String input = JOptionPane.showInputDialog
              ("Enter first account number and initial balance" +
               "\n(separated by spaces)  (Cancel to quit)") ;
             
      while ( input != null )	// while not eof
      {
      	 Scanner scan = new Scanner(input) ;
         String accountNumber = scan.next() ;
      	 double balance = scan.nextDouble() ;
      	 // create BankAccount object
      	 BankAccount next = new BankAccount(accountNumber, balance) ;  
      	 // add to list   
      	 firstBankOfJava.addAccount( next ) ;
         input = JOptionPane.showInputDialog
              ("Enter next account number and initial balance" +
               "\n(separated by spaces)  (Cancel to quit)") ;
      }
      // here at eof - list has been populated      
 
      // print the list of accounts
      firstBankOfJava.printList() ;
      
      // get total on deposit, all accounts
      System.out.printf( "%nTotal on deposit in all accounts is $%.2f%n", 
                         firstBankOfJava.getTotalBalance() ) ;
           
      // find number of accounts with balance of at least specified amount
      
      input = JOptionPane.showInputDialog
                     ("Find number of accounts with what minimum balance?" ) ;
      double threshold = Double.parseDouble(input) ;
      int count = firstBankOfJava.count(threshold) ;
      System.out.printf("%nFound %d accounts with balance of at least $%.2f%n",
                          count,threshold) ;
      
      // find account with greatest balance

      BankAccount max = firstBankOfJava.getMaximum() ;
      if ( max != null )  // there are accounts
         System.out.printf( "%nAccount with number %s has the largest balance"
                             + " ($%.2f)%n", max.getAccountNumber(),
                             max.getBalance()) ;
      else
         System.out.println( "\nSorry, no accounts!" ) ;
      
      // search the list for some specific accounts
      
      String accountNumber = JOptionPane.showInputDialog
                    ("Enter account number to search for (or Cancel to quit)") ;
      while ( accountNumber != null )			// while not eof
      {
      	 BankAccount target = firstBankOfJava.find(accountNumber) ;
      	 if (target == null) 
            System.out.println("\nNo account with number " + accountNumber) ;
         else
            System.out.printf("%nAccount with number %s has balance of $%.2f%n",
                               accountNumber, target.getBalance() ) ;
         accountNumber = JOptionPane.showInputDialog
           ("Enter next account number to search for (or Cancel to quit)") ;
      }
      System.exit(0) ;
   }
}