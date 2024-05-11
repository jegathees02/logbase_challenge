package inputs;
import java.util.Scanner;

public class input {
    static Scanner scanner = new Scanner(System.in);
    public static int readIntegerInput(String prompt) {
        int input = 0;
        boolean validInput = false;
        do {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Consume invalid input
            }
        } while (!validInput);
        return input;
    }

    public static  double readDoubleInput(String prompt) {
        // Scanner scanner = new Scanner(System.in);
        double input = 0;
        boolean validInput = false;
        do {
            System.out.println(prompt);
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                validInput = true;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Consume invalid input
            }
        } while (!validInput);
        return input;
    }

    public static String readStringInput(String prompt) {
        // Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextLine();
    }
}
