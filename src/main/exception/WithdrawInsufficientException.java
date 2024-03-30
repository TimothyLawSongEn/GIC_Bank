package main.exception;

/**
 * A WithdrawInsufficientException object is thrown when the user tries to withdraw more money than the balance.
 */
public class WithdrawInsufficientException extends Exception {
    @Override
    public String getMessage() {
        return "Insufficient balance.";
    }
}
