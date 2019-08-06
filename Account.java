
public class Account {
	private double balance;
	public Account(double initialBalance) {
		balance = initialBalance;
		
		
	}
	public Account() {
		balance=0;
	}
	public void deposit(double amount) {
		balance+=amount;
	}
	public void withdraw(double amount) {
		balance-=amount;
	}
	public double getBalance() {
		return balance;
	}
	public void close() {
		balance = 0;
	}

}
