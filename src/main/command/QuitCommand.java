package main.command;

import main.model.Account;

/**
 * A QuitCommand object has an execute method that returns a goodbye message and quits the program.
 */
public class QuitCommand extends Command {

    public String execute(Account account) {
        return "Thank you for banking with AwesomeGIC Bank." + System.lineSeparator() + "Have a nice day!";
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
