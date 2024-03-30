package main.parser;

import main.command.*;
import main.exception.IllegalCommandException;
import main.exception.IllegalSecondInputException;

/**
 * Parser class to parse user input and return the corresponding Command object.
 */
public class Parser {
    private Command commandExpectingArg;

    public Parser() {
        this.commandExpectingArg = null;
    }

    public Command parse(String input) throws IllegalSecondInputException, IllegalCommandException {
        String trimmedLowerInput = input.trim().toLowerCase();
        if (commandExpectingArg != null) { // expecting input to be an argument following a main.command
            double amount;
            try {
                amount = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                commandExpectingArg = null;
                throw new IllegalSecondInputException();
            }

            Command newCommand;
            if (commandExpectingArg instanceof DepositCommand) {
                newCommand = new DepositCommand(amount);
            } else if (commandExpectingArg instanceof WithdrawCommand) {
                newCommand = new WithdrawCommand(amount);
            } else {
                commandExpectingArg = null;
                throw new RuntimeException("Unexpected command-expecting-argument.");
            }
            commandExpectingArg = null;
            return newCommand;

        } else { // expecting input to be a main.command
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
                    throw new IllegalCommandException();
            }
        }
    }
}
