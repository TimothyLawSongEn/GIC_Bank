package main.command;

import main.model.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class QuitCommandIntegrationTest {

    private Account account;
    private QuitCommand quitCommand;

    @BeforeEach
    void setup() {
        account = new Account();
        quitCommand = new QuitCommand();
    }

    @Test
    void testExecute() {
        String expectedMessage = "Thank you for banking with AwesomeGIC Bank." + System.lineSeparator() + "Have a nice day!";
        assertEquals(expectedMessage, quitCommand.execute(account));
    }

    @Test
    void testIsExit() {
        assertTrue(quitCommand.isExit());
    }
}
