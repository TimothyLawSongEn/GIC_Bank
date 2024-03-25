package Command;

import Model.Account;
import Model.Transaction;

import java.util.StringJoiner;

public class PrintCommand extends Command {
    private Account account;

    public String execute(Account account) {
        StringJoiner sj = new StringJoiner("\n");
        for (Transaction transaction : account.getTransactionList()) {
            sj.add(transaction.toString());
        }
        return sj.toString();
    }
}
