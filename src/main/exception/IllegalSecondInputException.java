package main.exception;

/**
 * An IllegalSecondInputException object is thrown when the second input provided is invalid.
 * The second input is invalid if it is not a parsable double.
 */
public class IllegalSecondInputException extends Exception {

    @Override
    public String getMessage() {
        return "Invalid second input provided.";
    }
}
