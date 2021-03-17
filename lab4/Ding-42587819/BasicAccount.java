package labs.lab4;

public class BasicAccount extends BankAccount{
	
	public BasicAccount(double balance) {
		super(balance);
	}
	
	public void withdraw(double amount) {
		if((super.getBalance()- amount)<0) {
			super.withdraw(amount+30.0);
		}
		else {
			super.withdraw(amount);
		}
	}
	
}