package main.command;

import main.model.Account;
import main.util.DisplayString;
import main.exception.IllegalMoneyFormatException;
import main.exception.WithdrawInsufficientException;

/**
 * A WithdrawCommand object has an execute method that withdraws a specified amount from an account.
 */
public class WithdrawCommand extends Command {
    private final Double amount;

    public WithdrawCommand() {
        this.amount = null;
    }
    public WithdrawCommand(double amount) {
        this.amount = amount;
    }

    public String execute(Account account) {
        if (amount == null) {
            return "Please enter the amount to withdraw:";
        }
        try {
            account.withdraw(amount);
            return String.format("Thank you. $%.2f has been withdrawn from your account.", amount) + System.lineSeparator() + DisplayString.PROMPT_OPTIONS;
        } catch (IllegalMoneyFormatException | WithdrawInsufficientException e) {
            return "Withdraw failed. " + e.getMessage() + System.lineSeparator() + DisplayString.PROMPT_OPTIONS;
        }
    }
}
