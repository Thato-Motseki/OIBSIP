package atm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {
	private final String userId;
	private final String pin;
	private double balance;
	private final ArrayList<Transaction> transactions;

	public Account(String userId, String pin, double openingBalance) {
		if (!Double.isFinite(openingBalance) || openingBalance < 0) {
			throw new IllegalArgumentException("Opening balance cannot be negative.");
		}
		this.userId = userId;
		this.pin = pin;
		this.balance = openingBalance;
		this.transactions = new ArrayList<>();
		if (openingBalance > 0) {
			addTransaction("Opening balance", openingBalance);
		}
	}

	public String getUserId() {
		return userId;
	}

	public boolean matchesPin(String enteredPin) {
		return pin.equals(enteredPin);
	}

	public double getBalance() {
		return balance;
	}

	public List<Transaction> getTransactions() {
		return Collections.unmodifiableList(transactions);
	}

	public boolean withdraw(double amount, String description) {
		if (!Double.isFinite(amount) || amount <= 0 || amount > balance) {
			return false;
		}
		balance -= amount;
		addTransaction(description, -amount);
		return true;
	}

	public void deposit(double amount, String description) {
		if (!Double.isFinite(amount) || amount <= 0) {
			throw new IllegalArgumentException("Amount must be greater than zero.");
		}
		balance += amount;
		addTransaction(description, amount);
	}

	private void addTransaction(String description, double amount) {
		transactions.add(new Transaction(description, amount, balance));
	}
}
