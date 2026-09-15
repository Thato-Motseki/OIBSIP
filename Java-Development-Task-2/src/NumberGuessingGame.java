import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int round = 1;
        int totalRounds = 0;

        System.out.println("=================================");
        System.out.println("      NUMBER GUESSING GAME");
        System.out.println("=================================");

        boolean playAgain = true;

        while (playAgain) {

            int secretNumber = random.nextInt(100) + 1;
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round);
            System.out.println("I have selected a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts && !guessedCorrectly) {

                System.out.print("\nEnter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess < 1 || guess > 100) {
                    System.out.println("Please enter a number between 1 and 100.");
                    continue;
                }

                if (guess < secretNumber) {
                    System.out.println("Too Low!");
                    System.out.println("Attempts remaining: "
                            + (maxAttempts - attempts));

                } else if (guess > secretNumber) {
                    System.out.println("Too High!");
                    System.out.println("Attempts remaining: "
                            + (maxAttempts - attempts));

                } else {
                    guessedCorrectly = true;
                    totalRounds++;

                    System.out.println("Correct!");
                    System.out.println("You guessed the number in "
                            + attempts + " attempts.");
                    System.out.println("Round " + round
                            + " — guessed in " + attempts + " attempts");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou Lost!");
                System.out.println("The correct number was: " + secretNumber);
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String answer = scanner.next();

            if (answer.equalsIgnoreCase("yes")) {
                round++;
            } else {
                playAgain = false;
            }
        }

        System.out.println("\n=================================");
        System.out.println("          GAME OVER");
        System.out.println("=================================");
        System.out.println("Rounds successfully guessed: " + totalRounds);
        System.out.println("Thank you for playing!");

        scanner.close();
    }
}