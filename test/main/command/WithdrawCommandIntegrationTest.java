package main.command;

import main.exception.IllegalMoneyFormatException;
import main.model.Account;
import main.util.DisplayString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WithdrawCommandIntegrationTest {

    private Account account;

    @BeforeEach
    void setup() {
        account = new Account();
    }

    @Test
    void execute_validAmount_success() throws IllegalMoneyFormatException {
        account.deposit(500.0);
        WithdrawCommand withdrawCommand = new WithdrawCommand(100.0);

        String expectedMessage = "Thank you. $100.00 has been withdrawn from your account." + System.lineSeparator() + DisplayString.PROMPT_OPTIONS;

        assertEquals(expectedMessage, withdrawCommand.execute(account));
    }

    @Test
    void execute_nullAmount_prompt() throws IllegalMoneyFormatException {
        account.deposit(500.0);
        WithdrawCommand withdrawCommand = new WithdrawCommand();

        String expectedMessage = "Please enter the amount to withdraw:";

        assertEquals(expectedMessage, withdrawCommand.execute(account));
    }

    @Test
    void execute_insufficientFunds_exceptionThrown() {
        WithdrawCommand withdrawCommand = new WithdrawCommand(600.0);

        String expectedMessage = "Withdraw failed. Insufficient balance." + System.lineSeparator() + DisplayString.PROMPT_OPTIONS;

        assertEquals(expectedMessage, withdrawCommand.execute(account));
    }

    @Test
    void execute_excessDecimalAmount_exceptionThrown() throws IllegalMoneyFormatException {
        account.deposit(500.0);
        WithdrawCommand withdrawCommand = new WithdrawCommand(5.0001);

        String expectedMessage = "Withdraw failed. Invalid Money format provided: Amount must have at most 2 decimal places." + System.lineSeparator() + DisplayString.PROMPT_OPTIONS;

        assertEquals(expectedMessage, withdrawCommand.execute(account));
    }

    @Test
    void execute_negativeAmount_exceptionThrown() throws IllegalMoneyFormatException {
        account.deposit(500.0);
        WithdrawCommand withdrawCommand = new WithdrawCommand(-50.0);

        String expectedMessage = "Withdraw failed. Invalid Money format provided: Amount must be positive." + System.lineSeparator() + DisplayString.PROMPT_OPTIONS;

        assertEquals(expectedMessage, withdrawCommand.execute(account));
    }

}