# ATM Interface

A console-based ATM simulation built with Java and object-oriented programming. The project also includes a static HTML and CSS dashboard preview.

## Features

- User ID and PIN authentication
- Access denied after three incorrect login attempts
- Balance checks before withdrawals and transfers
- Deposits, withdrawals, and account-to-account transfers
- Insufficient funds handling
- Transaction history stored in an `ArrayList`
- Encapsulated account, bank, ATM, and transaction classes
- Responsive browser dashboard preview

## Technologies

- Java
- `ArrayList` collections
- Java console input with `Scanner`
- HTML5 and CSS3

## Project structure

```text
Java-Development-Task-3-ATM-Interface/
|-- src/atm/
|   |-- Account.java
|   |-- ATM.java
|   |-- Bank.java
|   |-- Main.java
|   `-- Transaction.java
|-- web/
|   |-- index.html
|   `-- styles.css
|-- screenshots/
`-- README.md
```

## Run the Java application

From the repository root, compile the source files:

```powershell
javac -d Java-Development-Task-3-ATM-Interface\out Java-Development-Task-3-ATM-Interface\src\atm\*.java
```

Start the ATM:

```powershell
java -cp Java-Development-Task-3-ATM-Interface\out atm.Main
```

### Demo accounts

| User ID | PIN | Opening balance |
| --- | --- | ---: |
| `user123` | `1234` | $1,000.00 |
| `user456` | `4321` | $500.00 |

After signing in, choose an option from the menu to check the balance, deposit cash, withdraw funds, transfer money, view transaction history, or exit.

## View the web preview

Open [web/index.html](web/index.html) directly in a browser. The dashboard is a static visual companion to the Java console application; its styles are defined in [web/styles.css](web/styles.css).

## Requirements

- Java Development Kit (JDK) 8 or later
- A modern web browser for the HTML preview
