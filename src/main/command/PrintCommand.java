package main.command;

import main.model.Account;
import main.model.Transaction;
import main.util.DisplayString;

import java.util.StringJoiner;

/**
 * A PrintCommand object has an execute method that prints the transaction history of an account.
 */
public class PrintCommand extends Command {

    public String execute(Account account) {
        StringJoiner sj = new StringJoiner(System.lineSeparator());
        if (account.getTransactionList().isEmpty()) {
            sj.add("No transactions found. Your balance is $0.00");
        } else {
            sj.add("Date                   | Amount  | Balance");
            sj.add("------------------------------------------");

            for (Transaction transaction : account.getTransactionList()) {
                sj.add(transaction.toString());
            }
            sj.add("------------------------------------------");
        }

        sj.add(DisplayString.PROMPT);
        return sj.toString();
    }
}
