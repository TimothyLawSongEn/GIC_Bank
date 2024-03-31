package main.command;

import main.model.Account;
import main.util.DisplayString;
import main.exception.IllegalMoneyFormatException;

/**
 * A DepositCommand object has an execute method that deposits a specified amount to an account.
 */
public class DepositCommand extends Command{
    private final Double amount;

    public DepositCommand() {
        this.amount = null;
    }
    public DepositCommand(double amount) {
        this.amount = amount;
    }

    public String execute(Account account) {
        if (amount == null) {
            return "Please enter the amount to deposit:";
        }
        try {
            account.deposit(amount);
        } catch (IllegalMoneyFormatException e) {
            return "Deposit failed. " + e.getMessage() + System.lineSeparator() + DisplayString.PROMPT_OPTIONS;
        }
        return String.format("Thank you. $%.2f has been deposited to your account.", amount) + System.lineSeparator() + DisplayString.PROMPT_OPTIONS;
    }
}
