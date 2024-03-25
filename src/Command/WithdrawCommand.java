package Command;

import Model.Account;

public class WithdrawCommand extends Command {
    private Account account;
    private Double amount;

    public WithdrawCommand() {
        this.amount = null;
    }
    public WithdrawCommand(double amount) {
        this.amount = amount;
    }

    public String execute(Account account) {
        if (amount == null) {
            return "Please enter the amount to withdraw:";
        } else {
            account.withdraw(amount);
            return "Thank you. AMOUNT has been withdrawn.";
        }
    }
}
