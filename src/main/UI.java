package main;

import main.util.DisplayString;

import java.util.Scanner;

// TODO: small bug: 1.0000000000001 as input

// Improve: 1) float precision 2) mock test cases 3) dependency injection 4) whr to catch exception 5) System.getProperty(lineseperator)

/**
 * UI class to handle user input and output.
 */
public class UI {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println(DisplayString.WELCOME);
        System.out.println(DisplayString.PROMPT);

        while (!bankingSystem.isExit()) {
            try {
                String input = scanner.nextLine();
                String display = bankingSystem.process(input);
                System.out.println(display);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(DisplayString.PROMPT);
            }
        }
    }

}
