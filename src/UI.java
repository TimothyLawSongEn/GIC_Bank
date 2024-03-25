import java.util.Scanner;

// TODO: 1) cleanup, 2) validation check, 3) exceptions
public class UI {
    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Banking System!");

        while (!bankingSystem.isExit()) {
            String input = scanner.nextLine();
            String display = bankingSystem.process(input);
            System.out.println(display);
//            System.out.println("Is there anything else you'd like to do?\n" +
//                    "[D]eposit \n" +
//                    "[W]ithdraw\n" +
//                    "[P]rint statement\n" +
//                    "[Q]uit");
        }
    }

}
