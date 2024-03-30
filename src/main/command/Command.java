package main.command;

import main.model.Account;

/**
 * Abstract Command class to represent a command object.
 * A command object has an executable command that can be executed on an account.
 */
public abstract class Command {
    public abstract String execute(Account account);
    public boolean isExit() {
        return false;
    }
}
