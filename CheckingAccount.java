
public class CheckingAccount extends Account{
	private int numChecks;
	public CheckingAccount(double initialBalance) {
		super(initialBalance);
		
	}
	public CheckingAccount(double initialBalance, int numChecks) {
		super.deposit(initialBalance);
		numChecks=0;
	}
	public void deposit(double amount) {
		numChecks++;
		super.deposit(amount);
		
	}
	public void withdraw(double amount) {//overriden
		numChecks++;
		super.withdraw(amount);
	}
	public void getNumChecks(int numChecks) {
		this.numChecks=numChecks;
	}
	public void transferTo(CheckingAccount acctB, double ammount) {
		if(getBalance()>ammount) {
		withdraw(ammount);
		acctB.deposit(ammount);
		}
	}
	
}
