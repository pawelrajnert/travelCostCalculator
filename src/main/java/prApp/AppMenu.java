package prApp;

import java.util.ArrayList;
import java.util.Scanner;

public class AppMenu {
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AppMenu menu = new AppMenu();
        menu.startTheme();
    }

    public void startTheme() {
        System.out.println("Program do liczenia kosztów wycieczek/transportu.");
        while (true) {
            System.out.println("Wybierz co chcesz policzyć:");
            System.out.println("1) Koszta transportu lokalnego");
            System.out.println("2) Koszta transportu zagranicznego");
            System.out.println("3) Koszta wycieczki lokalnej");
            System.out.println("4) Koszta wycieczki zagranicznej");
            System.out.println("5) Informacje o działaniu programu");
            System.out.println("6) Zakończ działanie aplikacji");
            System.out.print("Wprowadzasz numer: ");

            int choice = checkInt();

            switch (choice) {
                case 1:
                    pickLocalTransport();
                    break;
                case 2:
                    pickForeignTransport();
                    break;
                case 3:
                    pickLocalTrip();
                    break;
                case 4:
                    pickForeignTrip();
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
        StringBuilder info = new StringBuilder()
                .append("\t\t\tTransport krajowy i transport zagraniczny\n")
                .append("W zależności od wyboru transportu krajowego lub zagranicznego różni się stawka za autobus.\n")
                .append("Dla opcji krajowych stawka kilometrowa to: 9 zł za bus50, 8 zł za bus40, 6.5 zł za bus30.\n")
                .append("(Bus + liczba oznacza autobus o danej pojemności osób.)\n")
                .append("UWAGA, DLA TRAS PONIŻEJ 250 km ISTNIEJE USTALONA Z GÓRY STAWKA (NIE JEST TO STAWKA KILOMETROWA)\n")
                .append("2000 zł za bus50, 1700 zł za bus40 oraz 1400 zł za bus30")
                .append("Dla opcji transportu zagranicznego obecnie jedyną ustaloną stawką kilometrową jest 12 zł (bus50).\n\n")
                .append("\t\t\tWycieczki krajowe i wycieczki zagraniczne\n")
                .append("W przypadku wycieczek krajowych wszystkie kwoty do wpisania są w walucie PLN,\n")
                .append("natomiast dla wycieczek zagranicznych opcje wymagające kwoty w walucie EURO są dodatkowo oznaczone symbolem (*)\n")
                .append("UWAGA KOŃCOWA, PROGRAM PRZYJMUJE SEPARATOR DZIESIĘTNY (,) PRZYKŁAD: PRAWIDŁOWO WPROWADZONY KOSZT BILETU ZA PIĘĆ I PÓŁ EURO TO (5,5)\n");

        System.out.println(info);

    }

    private void pickLocalTransport() {
        System.out.println("Kalkulator kosztów transportu lokalnego:");

        System.out.println("\nInformacje o długości trasy ");
        System.out.print("Wprowadź odległość (km): ");
        int kmAmount = checkInt();

        System.out.println("\nInformacje o uczestnikach przejazdu ");
        System.out.print("Wprowadź liczbę uczestników: ");
        int participantsAmount = checkInt();

        System.out.print("Wprowadź liczbę opiekunów: ");
        int tutorsAmount = checkInt();

        System.out.print("Wprowadź liczbę pilotów: ");
        int pilotsAmount = checkInt();

        System.out.print("Wprowadź liczbę kierowców: ");
        int driversAmount = checkInt();

        LocalTransportation transport = new LocalTransportation(kmAmount, participantsAmount, tutorsAmount, pilotsAmount, driversAmount);

        System.out.println("Wyniki kalkulacji dla transportu krajowego");
        System.out.println("Całkowity koszt transportu wynosi: " +
                transport.calculateTotalCost() + " zł\n");

        System.out.println("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
        scanner.nextLine();
        String fileName = checkString();

        FileDao<LocalTransportation> ltDao = new FileDao<>();

        ltDao.write(fileName, transport);
        System.out.println("Zapisano do pliku: " + fileName + ".txt");
    }

    private void pickForeignTransport() {
        System.out.println("Kalkulator kosztów transportu zagranicznego:");

        System.out.println("\nInformacje o długości trasy ");
        System.out.print("Wprowadź odległość (km): ");
        int kmAmount = checkInt();

        System.out.println("\nInformacje o uczestnikach przejazdu ");
        System.out.print("Wprowadź liczbę uczestników: ");
        int participantsAmount = checkInt();

        System.out.print("Wprowadź liczbę opiekunów: ");
        int tutorsAmount = checkInt();

        System.out.print("Wprowadź liczbę pilotów: ");
        int pilotsAmount = checkInt();

        System.out.print("Wprowadź liczbę kierowców: ");
        int driversAmount = checkInt();

        ForeignTransportation transport = new ForeignTransportation(kmAmount, participantsAmount, tutorsAmount, pilotsAmount, driversAmount);

        System.out.println("Wyniki kalkulacji dla transportu krajowego");
        System.out.println("Całkowity koszt transportu wynosi: " +
                transport.calculateTotalCost() + " zł\n");

        System.out.println("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
        scanner.nextLine();
        String fileName = checkString();

        FileDao<ForeignTransportation> ftDao = new FileDao<>();

        ftDao.write(fileName, transport);
        System.out.println("Zapisano do pliku: " + fileName + ".txt");
    }

    private void pickLocalTrip() {
        System.out.println("Kalkulator kosztów wycieczki lokalnej:");

        System.out.println("\nInformacje o długości trasy ");
        System.out.print("Wprowadź odległość (km): ");
        int kilometers = checkInt();

        System.out.println("\nInformacje o uczestnikach przejazdu ");
        System.out.print("Wprowadź liczbę uczestników: ");
        int participantsAmount = checkInt();

        System.out.print("Wprowadź liczbę opiekunów: ");
        int tutorsAmount = checkInt();

        System.out.print("Wprowadź stawkę opiekuna (za cały wyjazd): ");
        double tutorWage = checkDouble();

        System.out.print("Wprowadź liczbę pilotów: ");
        int pilotsAmount = checkInt();

        System.out.print("Wprowadź stawkę pilota (za cały wyjazd): ");
        double pilotWage = checkDouble();

        System.out.print("Wprowadź liczbę kierowców: ");
        int driversAmount = checkInt();

        System.out.println("\nInformacje o noclegach");
        System.out.print("Wprowadź liczbę noclegów (ilość nocy): ");
        int accomodationAmount = checkInt();

        ArrayList<Double> accommodationCosts = new ArrayList<>();
        for (int i = 0; i < accomodationAmount; i++) {
            System.out.print("Podaj koszt noclegu za noc " +
                    (i + 1) + ", w walucie PLN za osobę: ");
            accommodationCosts.add(checkDouble());
        }

        System.out.println("\nInformacje o jedzeniu");
        System.out.print("Wprowadź liczbę posiłków: ");
        int foodAmount = checkInt();

        ArrayList<Double> foodCosts = new ArrayList<>();
        for (int i = 0; i < foodAmount; i++) {
            System.out.print("Podaj koszt posiłku/wyżywienia " +
                    (i + 1) + ", w walucie PLN za osobę: ");
            foodCosts.add(checkDouble());
        }

        System.out.println("\nKoszta dodatkowe");
        System.out.print("Wprowadź liczbę przewodników: ");
        int guideAmount = checkInt();

        ArrayList<Double> guideCosts = new ArrayList<>();
        for (int i = 0; i < guideAmount; i++) {
            System.out.print("Podaj koszt przewodnika " +
                    (i + 1) + ", w walucie PLN za grupę: ");
            guideCosts.add(checkDouble());
        }

        System.out.print("Wprowadź liczbę wstępów: ");
        int entranceAmount = checkInt();

        ArrayList<Double> entranceFees = new ArrayList<>();
        for (int i = 0; i < entranceAmount; i++) {
            System.out.print("Podaj koszt biletu wstępu " +
                    (i + 1) + ", w walucie PLN za osobę: ");
            entranceFees.add(checkDouble());
        }

        System.out.print("Wprowadź koszt ubezpieczenia (za całą grupę): ");
        double insuranceCost = checkDouble();

        System.out.println("\nOstatnie ewentualne zmiany przed obliczeniem kosztów- marża i zniżki.");
        System.out.println("Wpisanie w pole '0' jest równoważne z pominięciem danej sekcji.");
        System.out.print("Wprowadź marżę w %: ");
        double margin = checkDouble();

        System.out.print("Wprowadź zniżkę dla grupy w %: ");
        double discount = checkDouble();

        LocalTrip trip = new LocalTrip(kilometers, participantsAmount, tutorsAmount, pilotsAmount, driversAmount, accomodationAmount, accommodationCosts, foodAmount, foodCosts, tutorWage, pilotWage, insuranceCost, guideAmount, guideCosts, entranceAmount, entranceFees, margin, discount);

        System.out.println("Wprowadzono poprawnie wszystkie dane, obliczanie kosztów wycieczki");
        System.out.println("==================================================================");
        System.out.println("Całkowity koszt wycieczki: " + trip.calculateTotalCost() + " zł");
        System.out.println("Koszt wycieczki na osobę: " + trip.calculateCostPerPerson() + " zł\n");

        System.out.println("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
        scanner.nextLine();
        String fileName = checkString();

        FileDao<LocalTrip> ltDao = new FileDao<>();

        ltDao.write(fileName, trip);
        System.out.println("Zapisano do pliku: " + fileName + ".txt");

    }

    private void pickForeignTrip() {
        System.out.println("Kalkulator kosztów wycieczki zagranicznej:");

        System.out.println("\nInformacje o przeliczaniu walut ");
        System.out.print("(*) Wprowadź kurs EURO do obliczeń: ");
        double euroRate = checkDouble();

        System.out.println("\nInformacje o długości trasy ");
        System.out.print("Wprowadź odległość (km): ");
        int kilometers = checkInt();

        System.out.println("\nInformacje o uczestnikach przejazdu ");
        System.out.print("Wprowadź liczbę uczestników: ");
        int participantsAmount = checkInt();

        System.out.print("Wprowadź liczbę opiekunów: ");
        int tutorsAmount = checkInt();

        System.out.print("Wprowadź stawkę opiekuna (za cały wyjazd): ");
        double tutorWage = checkDouble();

        System.out.print("Wprowadź liczbę pilotów: ");
        int pilotsAmount = checkInt();

        System.out.print("Wprowadź stawkę pilota (za cały wyjazd): ");
        double pilotWage = checkDouble();

        System.out.print("Wprowadź liczbę kierowców: ");
        int driversAmount = checkInt();

        System.out.println("\nInformacje o noclegach");
        System.out.print("Wprowadź liczbę noclegów (ilość nocy): ");
        int accomodationAmount = checkInt();

        ArrayList<Double> accommodationCosts = new ArrayList<>();
        for (int i = 0; i < accomodationAmount; i++) {
            System.out.print("(*) Podaj koszt noclegu za noc " +
                    (i + 1) + ", w walucie EURO za osobę: ");
            accommodationCosts.add(checkDouble());
        }

        System.out.println("\nInformacje o jedzeniu");
        System.out.print("Wprowadź liczbę posiłków: ");
        int foodAmount = checkInt();

        ArrayList<Double> foodCosts = new ArrayList<>();
        for (int i = 0; i < foodAmount; i++) {
            System.out.print("(*) Podaj koszt posiłku/wyżywienia " +
                    (i + 1) + ", w walucie EURO za osobę: ");
            foodCosts.add(checkDouble());
        }

        System.out.println("\nKoszta dodatkowe");
        System.out.print("Wprowadź liczbę przewodników: ");
        int guideAmount = checkInt();

        ArrayList<Double> guideCosts = new ArrayList<>();
        for (int i = 0; i < guideAmount; i++) {
            System.out.print("(*) Podaj koszt przewodnika " +
                    (i + 1) + ", w walucie EURO za grupę: ");
            guideCosts.add(checkDouble());
        }

        System.out.print("Wprowadź liczbę wstępów: ");
        int entranceAmount = checkInt();

        ArrayList<Double> entranceFees = new ArrayList<>();
        for (int i = 0; i < entranceAmount; i++) {
            System.out.print("(*) Podaj koszt biletu wstępu " +
                    (i + 1) + ", w walucie EURO za osobę: ");
            entranceFees.add(checkDouble());
        }

        System.out.print("Wprowadź koszt ubezpieczenia (za całą grupę): ");
        double insuranceCost = checkDouble();

        System.out.println("\nOstatnie ewentualne zmiany przed obliczeniem kosztów- marża i zniżki.");
        System.out.println("Wpisanie w pole '0' jest równoważne z pominięciem danej sekcji.");
        System.out.print("Wprowadź marżę w %: ");
        double margin = checkDouble();

        System.out.print("Wprowadź zniżkę dla grupy w %: ");
        double discount = checkDouble();

        ForeignTrip trip = new ForeignTrip(kilometers, participantsAmount, tutorsAmount, pilotsAmount, driversAmount, accomodationAmount, accommodationCosts, foodAmount, foodCosts, tutorWage, pilotWage, insuranceCost, guideAmount, guideCosts, entranceAmount, entranceFees, margin, discount, euroRate);

        System.out.println("Wprowadzono poprawnie wszystkie dane, obliczanie kosztów wycieczki");
        System.out.println("==================================================================");
        System.out.println("Całkowity koszt wycieczki: " + trip.calculateTotalCost() + " zł");
        System.out.println("Koszt wycieczki na osobę: " + trip.calculateCostPerPerson() + " zł\n");

        System.out.println("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
        scanner.nextLine();
        String fileName = checkString();

        FileDao<ForeignTrip> ftDao = new FileDao<>();

        ftDao.write(fileName, trip);
        System.out.println("Zapisano do pliku: " + fileName + ".txt");
    }


    private int checkInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Wrong number provided (type correct integer)");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private double checkDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Wrong number provided (type correct double)");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private String checkString() {
        while (!scanner.hasNextLine() || scanner.nextLine().isEmpty()) {
            System.out.println("Wrong input provided");
        }
        return scanner.nextLine();
    }
}


