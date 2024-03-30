package main.exception;

/**
 * An IllegalCommandException object is thrown when the command given by the user is not valid.
 */
public class IllegalCommandException extends Exception {

        @Override
        public String getMessage() {
            return "Invalid command provided.";
        }
}
