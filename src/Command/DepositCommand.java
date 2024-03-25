package Command;

import Model.Account;

public class DepositCommand extends Command{
    private Double amount;

    public DepositCommand() {
        this.amount = null;
    }
    public DepositCommand(double amount) {
        this.amount = amount;
    }

    public String execute(Account account) {
        if (amount == null) {
            return "Please enter the amount to deposit:";
        } else {
            account.deposit(amount);
            return "Thank you. AMOUNT has been deposited to your account.";
        }
    }
}
