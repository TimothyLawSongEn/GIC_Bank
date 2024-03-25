package Command;

import Model.Account;

public class QuitCommand extends Command {

    public String execute(Account account) {
        return "Thank you for banking with AwesomeGIC Bank." + System.lineSeparator() + "Have a nice day!";
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
