package Command;

import Model.Account;

public abstract class Command {
    public abstract String execute(Account account);
    public boolean isExit() {
        return false;
    }
}
