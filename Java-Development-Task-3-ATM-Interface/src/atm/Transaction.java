package atm;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	private final String description;
	private final double amount;
	private final double balanceAfter;
	private final LocalDateTime timestamp;

	public Transaction(String description, double amount, double balanceAfter) {
		this.description = description;
		this.amount = amount;
		this.balanceAfter = balanceAfter;
		this.timestamp = LocalDateTime.now();
	}

	@Override
	public String toString() {
		return String.format("%-19s %-24s %10s  Balance: %10.2f",
				timestamp.format(DATE_FORMAT), description,
				String.format("%+.2f", amount), balanceAfter);
	}
}
