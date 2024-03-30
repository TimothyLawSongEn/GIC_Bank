package main.validator;
import main.exception.IllegalMoneyFormatException;

/**
 * MoneyValidator class is used to validate the money format provided by the user.
 * The money format is invalid if 1) it is not a number or 2) it is not positive or 3) it has more than 2 decimal places.
 */
public class MoneyValidator {
    public static void validate(double amount) throws IllegalMoneyFormatException {
        if (amount <= 0) {
            throw new IllegalMoneyFormatException("Amount must be positive.");
        }
        if (amount * 100 % 1 > 0.000000001) {
            throw new IllegalMoneyFormatException("Amount must have at most 2 decimal places.");
        }
    }
}
