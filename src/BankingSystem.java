import Model.Account;

import java.util.Scanner;
import Command.*;

public class BankingSystem {

    private static Account account = new Account();
    private static Parser parser = new Parser();
    private boolean isExit = false;

    public String process(String input) {
        Command cmd = parser.parse(input);
        String response = cmd.execute(account);
        isExit = cmd.isExit();
        return response;
    }

    public boolean isExit() {
        return isExit;
    }
}
