package main.util;

/**
 * A class that contains the common display strings used in the program.
 */
public class DisplayString {
    public static final String OPTIONS = "[D]eposit" + System.lineSeparator() +
            "[W]ithdraw" + System.lineSeparator() +
            "[P]rint statement" + System.lineSeparator() +
            "[Q]uit";
    public static final String WELCOME_OPTIONS =
            "Welcome to AwesomeGIC Bank! What would you like to do?"
            + System.lineSeparator()
            + OPTIONS;
    public static final String PROMPT_OPTIONS =
            "Is there anything else you'd like to do?"
            + System.lineSeparator()
            + OPTIONS;



}
