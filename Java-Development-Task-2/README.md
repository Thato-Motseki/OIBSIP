# Java Development Task 2 — Number Guessing Game

## Overview

This project is a console-based Number Guessing Game developed in Java as part of the Oasis Infobyte Java Development internship.

The program generates a random number between 1 and 100. The player attempts to guess the number within a maximum of 7 attempts. After each guess, the program provides feedback indicating whether the guess is too high or too low. If the player guesses correctly, the program displays the number of attempts used.

The game also allows the player to play multiple rounds and keeps track of successfully completed rounds.

## Objectives

The main objectives of this project are to:

* Generate random numbers using Java.
* Accept and process user input.
* Provide feedback after each guess.
* Track the number of attempts.
* Limit the player to a maximum number of attempts.
* Display the correct number when the player loses.
* Allow the player to start another round.
* Track successful rounds.

## Features

### Random Number Generation

A random number between 1 and 100 is generated at the beginning of every round.

### Guess Feedback

The program provides three possible results:

* `Too Low!` — the guess is lower than the secret number.
* `Too High!` — the guess is higher than the secret number.
* `Correct!` — the player has guessed the secret number.

### Attempt Tracking

The player has a maximum of 7 attempts per round. The program displays the number of attempts remaining after each valid guess.

### Losing Condition

If the player uses all 7 attempts without guessing correctly, the game displays:

```text
You Lost!
```

The correct number is then revealed.

### Multiple Rounds

After each round, the player can choose whether to play again.

### Score Tracking

The program records successfully guessed rounds and displays the round number and number of attempts used.

## Technologies Used

* Java
* Java `Scanner`
* Java `Random`
* Java `while` loops
* Java `if-else` statements
* Console input/output

## Concepts Demonstrated

This project demonstrates the following Java programming concepts:

* Variables and data types
* User input
* Random number generation
* Conditional statements
* `while` loops
* Boolean variables
* String comparison
* Input validation
* Counters
* Basic game logic

## How the Program Works

1. The program starts and displays the game title.
2. A random number between 1 and 100 is generated.
3. The player is given 7 attempts.
4. The player enters a guess.
5. The program compares the guess with the secret number.
6. The program displays `Too Low!`, `Too High!`, or `Correct!`.
7. The number of remaining attempts is displayed.
8. If the player uses all attempts, the correct number is revealed.
9. The player is asked whether they want to play another round.
10. At the end, the number of successfully guessed rounds is displayed.

## Example Output

```text
=================================
      NUMBER GUESSING GAME
=================================

Round 1
I have selected a number between 1 and 100.
You have 7 attempts.

Enter your guess: 25
Too Low!
Attempts remaining: 6

Enter your guess: 78
Too High!
Attempts remaining: 5

Enter your guess: 49
Correct!
You guessed the number in 3 attempts.
Round 1 — guessed in 3 attempts

Do you want to play again? (yes/no): no

=================================
          GAME OVER
=================================
Rounds successfully guessed: 1
Thank you for playing!
```

## Project Structure

```text
Java-Development-Task-2-Number-Guessing-Game/
│
├── src/
│   └── NumberGuessingGame.java
│
├── screenshots/
│   └── [project screenshots]
│
└── README.md
```

## How to Run

### Prerequisites

Install Java Development Kit (JDK) on your computer.

### Steps

1. Clone or download the `OIBSIP` repository.
2. Open the project in a Java IDE such as Visual Studio Code, NetBeans, IntelliJ IDEA, or Eclipse.
3. Open:

```text
src/NumberGuessingGame.java
```

4. Compile and run the program.
5. Enter numbers when prompted.
6. Follow the instructions displayed in the console.

## Testing

The program was tested using the following scenarios:

| Test                            | Expected Result          |
| ------------------------------- | ------------------------ |
| Guess lower than secret number  | `Too Low!`               |
| Guess higher than secret number | `Too High!`              |
| Guess correct number            | `Correct!`               |
| Seven unsuccessful attempts     | `You Lost!`              |
| Invalid non-numeric input       | Invalid input message    |
| Number outside 1–100            | Range validation message |
| Enter `yes` after a round       | New round begins         |
| Enter `no` after a round        | Game ends                |

## Internship Task

**Program:** Oasis Infobyte Java Development Internship
**Task:** Task 2 — Number Guessing Game
**Language:** Java
**Application Type:** Console Application

## Author
Thato Motseki
Developed as part of the Oasis Infobyte Java Development internship.
