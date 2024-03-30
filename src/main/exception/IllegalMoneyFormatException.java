package main.exception;

/**
 * An IllegalMoneyFormatException object is thrown when the money format provided is invalid.
 * The money format is invalid if 1) it is not a number or 2) it is not positive or 3) it has more than 2 decimal places.
 */
public class IllegalMoneyFormatException extends Exception {

    public IllegalMoneyFormatException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "Invalid Money format provided: " + super.getMessage();
    }
}
