package Command;

import Model.Account;

public class InvalidCommand extends Command {
    @Override
    public String execute(Account account) {
        return "Invalid command. Please try again.";
    }
}
