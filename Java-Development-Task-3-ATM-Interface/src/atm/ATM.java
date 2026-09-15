package atm;

import java.util.List;
import java.util.Scanner;

public class ATM {
	private static final int MAX_LOGIN_ATTEMPTS = 3;
	private final Bank bank;
	private final Scanner scanner;

	public ATM(Bank bank, Scanner scanner) {
		this.bank = bank;
		this.scanner = scanner;
	}

	public void start() {
		Account account = login();
		if (account == null) {
			return;
		}

		boolean running = true;
		while (running) {
			displayMenu();
			String choice = scanner.nextLine().trim();
			switch (choice) {
				case "1":
					showBalance(account);
					break;
				case "2":
					deposit(account);
					break;
				case "3":
					withdraw(account);
					break;
				case "4":
					transfer(account);
					break;
				case "5":
					showHistory(account);
					break;
				case "6":
					running = false;
					System.out.println("Thank you for using the ATM. Goodbye!");
					break;
				default:
					System.out.println("Invalid option. Please choose 1-6.");
			}
		}
	}

	private Account login() {
		for (int attempt = 1; attempt <= MAX_LOGIN_ATTEMPTS; attempt++) {
			System.out.print("User ID: ");
			String userId = scanner.nextLine().trim();
			System.out.print("PIN: ");
			String pin = scanner.nextLine().trim();
			Account account = bank.authenticate(userId, pin);
			if (account != null) {
				System.out.println("Login successful. Welcome, " + account.getUserId() + "!");
				return account;
			}
			System.out.println("Incorrect User ID or PIN. Attempts remaining: " + (MAX_LOGIN_ATTEMPTS - attempt));
		}
		System.out.println("Too many incorrect attempts. Access denied.");
		return null;
	}

	private void displayMenu() {
		System.out.println("\n===== ATM MENU =====");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Transfer");
		System.out.println("5. Transaction History");
		System.out.println("6. Exit");
		System.out.print("Choose an option: ");
	}

	private void showBalance(Account account) {
		System.out.printf("Current balance: $%.2f%n", account.getBalance());
	}

	private void deposit(Account account) {
		double amount = readAmount("Deposit amount: ");
			if (!Double.isFinite(amount) || amount <= 0) {
			return;
		}
		account.deposit(amount, "Cash deposit");
		System.out.printf("Deposit successful. New balance: $%.2f%n", account.getBalance());
	}

	private void withdraw(Account account) {
		double amount = readAmount("Withdrawal amount: ");
		if (amount <= 0) {
			return;
		}
		if (amount > account.getBalance()) {
			System.out.println("Insufficient Funds");
			return;
		}
		account.withdraw(amount, "Cash withdrawal");
		System.out.printf("Withdrawal successful. New balance: $%.2f%n", account.getBalance());
	}

	private void transfer(Account account) {
		System.out.print("Recipient User ID: ");
		String recipientId = scanner.nextLine().trim();
		Account recipient = bank.findAccount(recipientId);
		if (recipient == null || recipient == account) {
			System.out.println("Recipient account not found.");
			return;
		}
		double amount = readAmount("Transfer amount: ");
		if (amount <= 0) {
			return;
		}
		if (amount > account.getBalance()) {
			System.out.println("Insufficient Funds");
			return;
		}
		account.withdraw(amount, "Transfer to " + recipientId);
		recipient.deposit(amount, "Transfer from " + account.getUserId());
		System.out.printf("Transfer successful. New balance: $%.2f%n", account.getBalance());
	}

	private void showHistory(Account account) {
		List<Transaction> transactions = account.getTransactions();
		System.out.println("\n===== TRANSACTION HISTORY =====");
		if (transactions.isEmpty()) {
			System.out.println("No transactions found.");
			return;
		}
		for (Transaction transaction : transactions) {
			System.out.println(transaction);
		}
	}

	private double readAmount(String prompt) {
		System.out.print(prompt);
		try {
			double amount = Double.parseDouble(scanner.nextLine().trim());
			if (!Double.isFinite(amount) || amount <= 0) {
				System.out.println("Amount must be greater than zero.");
				return -1;
			}
			return amount;
		} catch (NumberFormatException exception) {
			System.out.println("Please enter a valid numeric amount.");
			return -1;
		}
	}
}
