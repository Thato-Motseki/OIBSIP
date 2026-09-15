package atm;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank();
		bank.addAccount(new Account("user123", "1234", 1000.00));
		bank.addAccount(new Account("user456", "4321", 500.00));

		ATM atm = new ATM(bank, new java.util.Scanner(System.in));
		atm.start();
	}
}
