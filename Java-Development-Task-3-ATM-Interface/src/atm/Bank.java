package atm;

import java.util.ArrayList;

public class Bank {
	private final ArrayList<Account> accounts = new ArrayList<>();

	public void addAccount(Account account) {
		accounts.add(account);
	}

	public Account authenticate(String userId, String pin) {
		for (Account account : accounts) {
			if (account.getUserId().equals(userId) && account.matchesPin(pin)) {
				return account;
			}
		}
		return null;
	}

	public Account findAccount(String userId) {
		for (Account account : accounts) {
			if (account.getUserId().equals(userId)) {
				return account;
			}
		}
		return null;
	}
}
