import Command.*;

import java.util.Scanner;

public class Parser {

    private Command commandExpectingArg;

    public Parser() {
        this.commandExpectingArg = null;
    }

    public Command parse(String input) {
        String trimmedLowerInput = input.trim().toLowerCase();
        if (commandExpectingArg != null) {
            if (!input.matches("\\d+")) {
                throw new IllegalArgumentException("Please enter a number.");
            }
            if (commandExpectingArg instanceof DepositCommand) {
                commandExpectingArg = null;
                return new DepositCommand(Double.parseDouble(input));
            } else if (commandExpectingArg instanceof WithdrawCommand) {
                commandExpectingArg = null;
                return new WithdrawCommand(Double.parseDouble(input));
            } else {
                commandExpectingArg = null;
                throw new IllegalArgumentException("Invalid command.");
            }
        }

        switch(trimmedLowerInput) {
            case "d":
                DepositCommand depositCommand = new DepositCommand();
                commandExpectingArg = depositCommand;
                return depositCommand;
            case "w":
                WithdrawCommand withdrawCommand = new WithdrawCommand();
                commandExpectingArg = withdrawCommand;
                return withdrawCommand;
            case "p":
                return new PrintCommand();
            case "q":
                return new QuitCommand();
            default:
                return new InvalidCommand();
        }
    }
}
