
public class PayPalAccount {
	private double balance;
	private int accountID;

	public PayPalAccount(double balance, int accountID) {
		this.balance = balance;
		this.accountID = accountID;
	}
	public int getID() {
		  return accountID;
	  }
	public void setBalance(double balance) {
			this.balance = balance;
	}
	 public String getAccountNumber()
	   {   
	      return String.format("%03d", accountID);
	   }
	 public void setAccountNumber(int newNumber) {
		 this.accountID = newNumber;
	 }
	 
	  public void deposit(double amount) {
	    balance += amount;
	  }

	  public void withdraw(double amount) {
	    balance -= amount;
	  }

	  public double getBalance() {
	    return balance;
	  }
	  public void transfer(PayPalAccount acctB, double amount) {
		  if(balance>amount)
			  balance-=amount;
		  acctB.deposit(amount);
		  
	  }
	  
	  public void close() {
	    balance = 0.0;
	  }
	  public void transferTo(PayPalAccount acct, double x) {
		    if (x <= this.balance) {
		        withdraw(x);
		        acct.deposit(x);
		    } else { 
		        System.out.println("\nTransfer failed, not enough balance!");
		    }
		}
}

