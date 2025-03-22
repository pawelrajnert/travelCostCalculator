package prapp;

import java.util.Scanner;

public class VerifyData {
    private final Scanner scanner;

    public VerifyData(Scanner scanner) {
        this.scanner = scanner;
    }

    public int checkInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Wprowadzono złą wartość (oczekiwana wartość całkowita).");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public double checkDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Wprowadzono złą wartość (oczekiwana wartość zmiennoprzecinkowa).");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public String checkString() {
        String input;
        do {
            input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Wprowadzono złą wartość (oczekiwana wartość tekstowa).");
            }
        } while (input.isEmpty());
        return input;
    }

    public void nL() {
        scanner.nextLine();
    }

}
