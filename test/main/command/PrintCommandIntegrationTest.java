package main.command;

import main.model.Account;
import main.util.DisplayString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrintCommandIntegrationTest {

    @Test
    void testExecuteWithEmptyTransactionList() {
        Account account = new Account();
        PrintCommand printCommand = new PrintCommand();

        String expectedMessage = "No transactions found. Your balance is $0.00"
                + System.lineSeparator() + DisplayString.PROMPT;
        assertEquals(expectedMessage, printCommand.execute(account));
    }

}
