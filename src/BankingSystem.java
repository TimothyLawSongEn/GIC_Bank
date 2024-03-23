import java.util.Scanner;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

// TODO: need exceptions, need tests, how to make this better?? e.g. abstraction

class Transaction {
    private Date date;
    private double amount;
    private double balance;

    public Transaction(double amount, double balance) {
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy hh:mm:ssa");
        return String.format("%-20s | $%-7.2f | $%-7.2f", sdf.format(date), amount, balance);
    }
}

class Account {
    // account num
    private double balance;
    private ArrayList<Transaction> transactions;

    public Account() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (!isValidAmount(amount)) {
            return;
        }
        balance += amount;
        transactions.add(new Transaction(amount, balance));
        System.out.println("Thank you. $" + String.format("%.2f", amount) + " has been deposited into your account.");
    }

    public void withdraw(double amount) {
        if (!isValidAmount(amount)) {
            return;
        }
        if (balance < amount) {
            System.out.println("Insufficient funds. You have $" + String.format("%.2f", balance) + " in your account.");
            return;
        }
        balance -= amount;
        transactions.add(new Transaction(-amount, balance));
        System.out.println("Thank you. $" + amount + " has been withdrawn from your account.");
    }

    public void printStatement() {
        System.out.println("Date                  | Amount  | Balance");
        System.out.println("--------------------------------------------");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    private boolean isValidAmount(double amount) {
        return isAtMostTwoDecimalPlaces(amount) && isPositive(amount);
    }

    private boolean isAtMostTwoDecimalPlaces(double amount) {
        String amountString = Double.toString(amount);
        int decimalIndex = amountString.indexOf('.');
        if (decimalIndex == -1) {
            return true;
        } else {
            int numDecimalPlaces = amountString.length() - decimalIndex - 1;
            if (numDecimalPlaces > 2) {
                System.out.println("Invalid amount (must have at most 2 decimal places).");
                return false;
            }
            return true;
        }
    }
    private boolean isPositive(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount (must be positive).");
            return false;
        }
        return true;
    }
}

public class BankingSystem {
    public final static String WELCOME_MESSAGE = "Welcome to AwesomeGIC Bank! What would you like to do?";
    public final static String PROMPT_MESSAGE = "Is there anything else you would like to do?";
    public final static String OPTIONS_MESSAGE = "[D]eposit\n[W]ithdraw\n[P]rint statement\n[Q]uit";

    public final static String WELCOME_OPTIONS_MESSAGE = WELCOME_MESSAGE + "\n" + OPTIONS_MESSAGE;
    public final static String PROMPT_OPTIONS_MESSAGE = PROMPT_MESSAGE + "\n" + OPTIONS_MESSAGE;

    public final static String QUIT_MESSAGE = "Thank you for banking with AwesomeGIC Bank.\nHave a nice day!";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();

        System.out.println(WELCOME_OPTIONS_MESSAGE);

        boolean running = true;
        while (running) {
            String choice = scanner.nextLine().toLowerCase().trim();
            switch (choice) {
                case "d":
                    System.out.println("Please enter the amount to deposit:");
                    double depositAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    account.deposit(depositAmount);
                    break;
                case "w":
                    System.out.println("Please enter the amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    account.withdraw(withdrawAmount);
                    break;
                case "p":
                    account.printStatement();
                    break;
                case "q":
                    running = false;
                    System.out.println(QUIT_MESSAGE);
                    break;
                default:
                    System.out.println("Invalid choice. Only [D], [W], [P], and [Q] are accepted. Please try again.");
                    break;
            }
            if (running) {
                System.out.println(PROMPT_OPTIONS_MESSAGE);
            }
        }
        scanner.close();
    }
}
