package prapp;

import java.io.*;
import java.util.Scanner;

public class AppMenu {
    private final Scanner scanner = new Scanner(System.in);
    private final VerifyData vd = new VerifyData(scanner);
    private final TransportChooser tc = new TransportChooser(vd);
    private final TripChooser tripc = new TripChooser(vd);

    public static void main(String[] args) {
        AppMenu menu = new AppMenu();
        menu.startTheme();
    }

    public void startTheme() {
        System.out.println("Program do liczenia kosztów wycieczek/transportu.");
        while (true) {
            System.out.println();
            System.out.println("Wybierz co chcesz policzyć lub zrobić:");
            System.out.println("1) Oblicz koszta transportu lokalnego");
            System.out.println("2) Oblicz koszta transportu zagranicznego");
            System.out.println("3) Oblicz koszta wycieczki lokalnej");
            System.out.println("4) Oblicz koszta wycieczki zagranicznej");
            System.out.println("5) Informacje o działaniu programu");
            System.out.println("6) Zakończ działanie aplikacji");
            System.out.print("Wprowadzasz numer: ");

            int choice = vd.checkInt();

            switch (choice) {
                case 1:
                    tc.transportOptions(0);
                    break;
                case 2:
                    tc.transportOptions(1);
                    break;
                case 3:
                    tripc.tripOptions(0);
                    break;
                case 4:
                    tripc.tripOptions(1);
                    break;
                case 5:
                    showInfo();
                    break;
                case 6:
                    System.out.println("Zakończono działanie programu.");
                    return;
                default:
                    System.out.println("Nie wybrano poprawnej opcji.");
            }
        }
    }

    private void showInfo() {
        String name = "info.txt";
        System.out.println("");
        try (BufferedReader reader = new BufferedReader(new FileReader(name))) {
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println(text);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


