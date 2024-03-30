package main.model;

import static org.junit.jupiter.api.Assertions.*;

import main.exception.IllegalMoneyFormatException;
import main.exception.WithdrawInsufficientException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountTest {

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account();
    }

    @Test
    void deposit_validAmount_success() {
        assertDoesNotThrow(() -> account.deposit(50.0));
        assertDoesNotThrow(() -> account.deposit(100.0));
        assertDoesNotThrow(() -> account.deposit(0.01));
        assertDoesNotThrow(() -> account.deposit(1));
    }

    @Test
    void deposit_invalidAmount_exceptionThrown() {
        assertThrows(IllegalMoneyFormatException.class, () -> account.deposit(-50.0));
        assertThrows(IllegalMoneyFormatException.class, () -> account.deposit(-0.01));
        assertThrows(IllegalMoneyFormatException.class, () -> account.deposit(-1));
        assertThrows(IllegalMoneyFormatException.class, () -> account.deposit(0));
        assertThrows(IllegalMoneyFormatException.class, () -> account.deposit(0.001));
        assertThrows(IllegalMoneyFormatException.class, () -> account.deposit(-0.0001));
    }

    @Test
    void withdraw_validAmountsufficientFunds_success() {
        assertDoesNotThrow(() -> account.deposit(50));
        assertDoesNotThrow(() -> account.withdraw(50.0));
        assertDoesNotThrow(() -> account.deposit(100.0));
        assertDoesNotThrow(() -> account.withdraw(40.00));
        assertDoesNotThrow(() -> account.withdraw(60));
    }

    @Test
    void withdraw_validAmountInsufficientFunds_throwsException() throws IllegalMoneyFormatException {
        assertThrows(WithdrawInsufficientException.class, () -> account.withdraw(50.0));
        assertDoesNotThrow(() -> account.deposit(50));
        assertThrows(WithdrawInsufficientException.class, () -> account.withdraw(100.0));
    }

    @Test
    void withdraw_invalidAmount_exceptionThrown() {
        assertDoesNotThrow(() -> account.deposit(5000));
        assertThrows(IllegalMoneyFormatException.class, () -> account.withdraw(-50.0));
        assertThrows(IllegalMoneyFormatException.class, () -> account.withdraw(-0.01));
        assertThrows(IllegalMoneyFormatException.class, () -> account.withdraw(-1));
        assertThrows(IllegalMoneyFormatException.class, () -> account.withdraw(0));
        assertThrows(IllegalMoneyFormatException.class, () -> account.withdraw(0.001));
        assertThrows(IllegalMoneyFormatException.class, () -> account.withdraw(-0.0001));
    }

    @Test
    void getTransactionList_validTransaction_success() {
        assertDoesNotThrow(() -> account.deposit(50.0));
        assertDoesNotThrow(() -> account.deposit(100.0));
        assertDoesNotThrow(() -> account.deposit(0.01));
        assertDoesNotThrow(() -> account.deposit(1));
        assertThrows(IllegalMoneyFormatException.class, () -> account.deposit(-50.0));
        assertEquals(4, account.getTransactionList().size());
    }
}
