package main;

import main.util.DisplayString;

import java.util.Scanner;

/**
 * UI class to handle user input and output.
 */
public class UI {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println(DisplayString.WELCOME_OPTIONS);

        while (!bankingSystem.isExit()) {
            try {
                String input = scanner.nextLine();
                String display = bankingSystem.process(input);
                System.out.println(display);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println(DisplayString.PROMPT_OPTIONS);
            }
        }
    }

}
