package main.command;

import main.model.Account;
import main.util.DisplayString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DepositCommandIntegrationTest {

    private Account account;

    @BeforeEach
    void setup() {
        account = new Account();
    }

    @Test
    void execute_validAmount_success() {
        DepositCommand depositCommand = new DepositCommand(100.0);

        String expectedMessage = "Thank you. $100.00 has been deposited to your account." + System.lineSeparator() + DisplayString.PROMPT;

        assertEquals(expectedMessage, depositCommand.execute(account));
    }

    @Test
    void execute_nullAmount_prompt() {
        DepositCommand depositCommand = new DepositCommand();

        String expectedMessage = "Please enter the amount to deposit:";

        assertEquals(expectedMessage, depositCommand.execute(account));
    }

    @Test
    void execute_excessDecimalAmount_exceptionThrown() {
        DepositCommand depositCommand = new DepositCommand(5.0001);

        String expectedMessage = "Deposit failed. Invalid Money format provided: Amount must have at most 2 decimal places." + System.lineSeparator() + DisplayString.PROMPT;

        assertEquals(expectedMessage, depositCommand.execute(account));
    }

    @Test
    void execute_negativeAmount_exceptionThrown() {
        DepositCommand depositCommand = new DepositCommand(-50.0);

        String expectedMessage = "Deposit failed. Invalid Money format provided: Amount must be positive." + System.lineSeparator() + DisplayString.PROMPT;

        assertEquals(expectedMessage, depositCommand.execute(account));
    }
}
