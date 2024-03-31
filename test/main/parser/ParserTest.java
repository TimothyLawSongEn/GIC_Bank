package main.parser;

import main.command.*;
import main.exception.IllegalCommandException;
import main.exception.IllegalSecondInputException;
import main.parser.Parser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

class ParserTest {

    private Parser parser;

    @BeforeEach
    void setup() {
        parser = new Parser();
    }

    @Test
    void testValidDepositCommandParsing() throws Exception {
        Command command = parser.parse("d");
        assertTrue(command instanceof DepositCommand);
    }

    @Test
    void testValidWithdrawCommandParsing() throws Exception {
        Command command = parser.parse("w");
        assertTrue(command instanceof WithdrawCommand);
    }

    @Test
    void testValidPrintCommandParsing() throws Exception {
        Command command = parser.parse("p");
        assertTrue(command instanceof PrintCommand);
    }

    @Test
    void testValidQuitCommandParsing() throws Exception {
        Command command = parser.parse("q");
        assertTrue(command instanceof QuitCommand);
    }

    @Test
    void parse_invalidCommand_exceptionThrown() {
        assertThrows(IllegalCommandException.class, () -> parser.parse("x"));
    }

    @Test
    void parse_depositCommandValidSecondInput_depositCommandReturned() throws Exception {
        Command command = parser.parse("d");
        assertTrue(command instanceof DepositCommand);
        Command command2 = parser.parse("100");
        assertTrue(command2 instanceof DepositCommand);
    }

    @Test
    void parse_withdrawCommandValidSecondInput_withdrawCommandReturned() throws Exception {
        Command command = parser.parse("w");
        assertTrue(command instanceof WithdrawCommand);
        Command command2 = parser.parse("100");
        assertTrue(command2 instanceof WithdrawCommand);
    }

    @Test
    void parse_depositCommandInvalidSecondInput_exceptionThrown() throws Exception {
        Command command = parser.parse("d");
        assertTrue(command instanceof DepositCommand);
        assertThrows(IllegalSecondInputException.class, () -> parser.parse("abc"));
    }
}
