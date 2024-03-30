package main;

import static org.junit.jupiter.api.Assertions.*;

import main.util.DisplayString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankIntegrationTest {

    private BankingSystem bankingSystem;
    @BeforeEach
    void setup() {
        bankingSystem = new BankingSystem();
    }

    @Test
    void testDepositAndPrintStatement() {
        // Simulate deposit command
        assertEquals("Please enter the amount to deposit:", bankingSystem.process("D"));
        assertEquals("Thank you. $600.00 has been deposited to your account." + System.lineSeparator() + DisplayString.PROMPT, bankingSystem.process("600"));

        // print and assert that print string contains 500.00
        String printString = bankingSystem.process("P");
        assertTrue(printString.contains("600.00"));
        assertTrue(printString.contains(DisplayString.PROMPT));
        assertFalse(printString.contains("fail"));
    }

    @Test
    void testDepositAndWithdraw() {
        // Simulate deposit command
        assertEquals("Please enter the amount to deposit:", bankingSystem.process("D"));
        assertEquals("Thank you. $500.00 has been deposited to your account." + System.lineSeparator() + DisplayString.PROMPT, bankingSystem.process("500"));

        // Simulate withdraw command
        assertEquals("Please enter the amount to withdraw:", bankingSystem.process("W"));
        assertEquals("Thank you. $500.00 has been withdrawn from your account." + System.lineSeparator() + DisplayString.PROMPT, bankingSystem.process("500"));

        // print and assert that print string contains 400.00
        String printString = bankingSystem.process("P");
        assertTrue(printString.contains("500.00"));
        assertTrue(printString.contains("0.00"));
        assertTrue(printString.contains("-500.00"));
        assertTrue(printString.contains(DisplayString.PROMPT));
        assertFalse(printString.contains("fail"));

        // withdraw again
        assertEquals("Please enter the amount to withdraw:", bankingSystem.process("W"));
        assertEquals("Withdraw failed. Insufficient balance." + System.lineSeparator() + DisplayString.PROMPT, bankingSystem.process("500"));
    }

    // quit
    @Test
    void process_quit_success() {
        String expected = "Thank you for banking with AwesomeGIC Bank." + System.lineSeparator() + "Have a nice day!";
        assertEquals(expected, bankingSystem.process("Q"));
        assertTrue(bankingSystem.isExit());
    }



    // negative tests
    @Test
    void process_invalidCommand_fail() {
        assertEquals("Transaction failed. Invalid command provided." + System.lineSeparator() + DisplayString.PROMPT, bankingSystem.process("X"));
    }

    @Test
    void process_invalidAmount_fail() {
        assertEquals("Please enter the amount to deposit:", bankingSystem.process("D"));
        assertEquals("Deposit failed. Invalid Money format provided: Amount must be positive." + System.lineSeparator() + DisplayString.PROMPT, bankingSystem.process("-500"));
    }
}
