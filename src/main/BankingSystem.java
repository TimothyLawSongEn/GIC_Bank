package main;

import main.model.Account;

import main.command.*;
import main.exception.IllegalCommandException;
import main.exception.IllegalSecondInputException;
import main.util.DisplayString;
import main.parser.Parser;

/**
 * BankingSystem class is the main logic class that processes user input,
 * executes the corresponding command,
 * and returns the corresponding string output.
 */
public class BankingSystem {
    private Account account = new Account();
    private Parser parser = new Parser();
    private boolean isExit = false;
    private static final String FAIL_MSG = "Transaction failed.";

    public String process(String input) {
        try {
            Command cmd = parser.parse(input);
            String response = cmd.execute(account);
            isExit = cmd.isExit();
            return response;
        } catch (IllegalSecondInputException | IllegalCommandException e) {
            return FAIL_MSG + " " + e.getMessage() + System.lineSeparator() + DisplayString.PROMPT;
        }
    }

    public boolean isExit() {
        return isExit;
    }
}
