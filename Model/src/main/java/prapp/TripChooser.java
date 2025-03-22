package prapp;

import java.util.ArrayList;

public class TripChooser {
    private final VerifyData vd;

    public TripChooser(VerifyData vd) {
        this.vd = vd;
    }

    public void tripOptions(int type) {
        if (type == 0) {
            System.out.println("Kalkulator kosztów wycieczki lokalnej");
        }

        if (type == 1) {
            System.out.println("Kalkulator kosztów wycieczki zagranicznej");
        }

        System.out.println("Wybierz odpowiednią opcję: ");
        System.out.println("1) Utwórz nową kalkulację.");
        System.out.println("2) Odczytaj dane kalkulacji.");
        System.out.println("3) Modyfikuj dane kalkulacji.");
        System.out.print("Wprowadzasz numer: ");

        int choice = vd.checkInt();

        switch (choice) {
            case 1: {
                if (type == 0) {
                    createNewTrip(0);
                    break;
                }
                if (type == 1) {
                    createNewTrip(1);
                    break;
                }
            }
            case 2: {
                if (type == 0) {
                    loadTrip(0);
                    break;
                }
                if (type == 1) {
                    loadTrip(1);
                    break;
                }
            }
            case 3: {
                if (type == 0) {
                    loadAndModifyL();
                    break;
                }
                if (type == 1) {
                    loadAndModifyF();
                    break;
                }
            }
        }
    }

    private void createNewTrip(int type) {
        double euroRate = 0;

        if (type == 1) {
            System.out.println("\nInformacje o przeliczaniu walut ");
            System.out.print("(*) Wprowadź kurs EURO do obliczeń: ");
            euroRate = vd.checkDouble();
            while (euroRate <= 0 || euroRate > 6) {
                System.out.print("Błędny kurs EURO. Wprowadź poprawną wartość: ");
                euroRate = vd.checkDouble();
            }
        }

        System.out.println("\nInformacje o długości trasy ");
        System.out.print("Wprowadź odległość (km): ");
        int kilometers = vd.checkInt();
        while (kilometers <= 0) {
            System.out.print("Błędna liczba kilometrów podczas wycieczki. Wprowadź poprawną wartość: ");
            kilometers = vd.checkInt();
        }

        System.out.println("\nInformacje o uczestnikach przejazdu ");
        System.out.print("Wprowadź liczbę uczestników: ");
        int participantsAmount = vd.checkInt();
        while (participantsAmount <= 0 || participantsAmount > 46) {
            System.out.print("Błędna liczba uczestników. Wprowadź poprawną wartość: ");
            participantsAmount = vd.checkInt();
        }

        System.out.print("Wprowadź liczbę opiekunów: ");
        int tutorsAmount = vd.checkInt();
        while (tutorsAmount <= 0 || tutorsAmount > 4) {
            System.out.print("Błędna liczba opiekunów. Wprowadź poprawną wartość: ");
            tutorsAmount = vd.checkInt();
        }

        System.out.print("Wprowadź stawkę opiekuna (za cały wyjazd w PLN): ");
        double tutorWage = vd.checkDouble();
        while (tutorWage <= 0) {
            System.out.print("Błędna stawka opiekuna. Wprowadź poprawną wartość: ");
            tutorWage = vd.checkDouble();
        }

        System.out.print("Wprowadź liczbę pilotów: ");
        int pilotsAmount = vd.checkInt();
        while (pilotsAmount <= 0 || pilotsAmount > 2) {
            System.out.print("Błędna liczba pilotów. Wprowadź poprawną wartość: ");
            pilotsAmount = vd.checkInt();
        }

        System.out.print("Wprowadź stawkę pilota (za cały wyjazd w PLN): ");
        double pilotWage = vd.checkDouble();
        while (pilotWage <= 0) {
            System.out.print("Błędna stawka pilota. Wprowadź poprawną wartość: ");
            pilotWage = vd.checkDouble();
        }

        System.out.print("Wprowadź liczbę kierowców: ");
        int driversAmount = vd.checkInt();
        while (driversAmount <= 0 || driversAmount > 2) {
            System.out.print("Błędna liczba kierowców. Wprowadź poprawną wartość: ");
            driversAmount = vd.checkInt();
        }

        System.out.println("\nInformacje o noclegach");
        System.out.print("Wprowadź liczbę noclegów (ilość nocy): ");
        int accomodationAmount = vd.checkInt();
        while (accomodationAmount <= 0 || accomodationAmount > 31) {
            System.out.print("Błędna liczba noclegów. Wprowadź poprawną wartość: ");
            accomodationAmount = vd.checkInt();
        }

        ArrayList<Double> accommodationCosts = new ArrayList<>();
        for (int i = 0; i < accomodationAmount; i++) {
            if (type == 0) {
                System.out.print("Podaj koszt noclegu za noc " +
                        (i + 1) + ", w walucie PLN za osobę: ");
            }
            if (type == 1) {
                System.out.print("(*) Podaj koszt noclegu za noc " +
                        (i + 1) + ", w walucie EURO za osobę: ");
            }

            double cost = vd.checkDouble();

            while (cost <= 0) {
                System.out.print("Błędny koszt noclegu. Wprowadź poprawną wartość: ");
                cost = vd.checkDouble();
            }
            accommodationCosts.add(cost);
        }

        System.out.println("\nInformacje o jedzeniu");
        System.out.print("Wprowadź liczbę posiłków: ");
        int foodAmount = vd.checkInt();
        while (foodAmount <= 0 || foodAmount > 31) {
            System.out.print("Błędna liczba posiłków. Wprowadź poprawną wartość: ");
            foodAmount = vd.checkInt();
        }

        ArrayList<Double> foodCosts = new ArrayList<>();
        for (int i = 0; i < foodAmount; i++) {
            if (type == 0) {
                System.out.print("Podaj koszt posiłku/wyżywienia " +
                        (i + 1) + ", w walucie PLN za osobę: ");
            }
            if (type == 1) {
                System.out.print("(*) Podaj koszt posiłku/wyżywienia " +
                        (i + 1) + ", w walucie EURO za osobę: ");
            }

            double cost = vd.checkDouble();

            while (cost <= 0) {
                System.out.print("Błędny koszt posiłku. Wprowadź poprawną wartość: ");
                cost = vd.checkDouble();
            }

            foodCosts.add(cost);
        }

        System.out.println("\nKoszta dodatkowe");
        System.out.print("Wprowadź liczbę przewodników: ");
        int guideAmount = vd.checkInt();
        while (guideAmount <= 0) {
            System.out.print("Błędna liczba przewodników. Wprowadź poprawną wartość: ");
            guideAmount = vd.checkInt();
        }

        ArrayList<Double> guideCosts = new ArrayList<>();
        for (int i = 0; i < guideAmount; i++) {
            if (type == 0) {
                System.out.print("Podaj koszt przewodnika " +
                        (i + 1) + ", w walucie PLN za grupę: ");
            }
            if (type == 1) {
                System.out.print("(*) Podaj koszt przewodnika " +
                        (i + 1) + ", w walucie EURO za grupę: ");
            }

            double cost = vd.checkDouble();

            while (cost <= 0) {
                System.out.print("Błędna stawka przewodnika. Wprowadź poprawną wartość: ");
                cost = vd.checkDouble();
            }

            guideCosts.add(cost);
        }

        System.out.print("Wprowadź liczbę wstępów: ");
        int entranceAmount = vd.checkInt();
        while (entranceAmount <= 0) {
            System.out.print("Błędna liczba wstępów. Wprowadź poprawną wartość: ");
            entranceAmount = vd.checkInt();
        }

        ArrayList<Double> entranceFees = new ArrayList<>();
        for (int i = 0; i < entranceAmount; i++) {
            if (type == 0) {
                System.out.print("Podaj koszt biletu wstępu " +
                        (i + 1) + ", w walucie PLN za osobę: ");
            }
            if (type == 1) {
                System.out.print("(*) Podaj koszt biletu wstępu " +
                        (i + 1) + ", w walucie EURO za osobę: ");
            }
            double cost = vd.checkDouble();

            while (cost <= 0) {
                System.out.print("Błędny koszt biletu wstępu. Wprowadź poprawną wartość: ");
                cost = vd.checkDouble();
            }

            entranceFees.add(cost);
        }

        System.out.print("Wprowadź koszt ubezpieczenia (za całą grupę w PLN): ");
        double insuranceCost = vd.checkDouble();
        while (insuranceCost <= 0) {
            System.out.print("Błędny koszt ubezpieczenia. Wprowadź poprawną wartość: ");
            insuranceCost = vd.checkDouble();
        }

        System.out.println("\nOstatnie ewentualne zmiany przed obliczeniem kosztów- marża i zniżki.");
        System.out.println("Wpisanie w pole '0' jest równoważne z pominięciem danej sekcji.");
        System.out.print("Wprowadź marżę w %: ");
        double margin = vd.checkDouble();
        while (margin < 0 || margin > 100) {
            System.out.print("Błędna wartość marży. Wprowadź poprawną wartość: ");
            margin = vd.checkDouble();
        }

        System.out.print("Wprowadź zniżkę dla grupy w %: ");
        double discount = vd.checkDouble();
        while (discount < 0 || discount > 100) {
            System.out.print("Błędna wartość rabatu. Wprowadź poprawną wartość: ");
            discount = vd.checkDouble();
        }

        if (type == 0) {
            FileDao<LocalTrip> ltDao = new FileDao<>(LocalTrip.class);
            LocalTrip trip = new LocalTrip(kilometers, participantsAmount, tutorsAmount, pilotsAmount, driversAmount, accomodationAmount, accommodationCosts, foodAmount, foodCosts, tutorWage, pilotWage, insuranceCost, guideAmount, guideCosts, entranceAmount, entranceFees, margin, discount);

            System.out.println("Wprowadzono poprawnie wszystkie dane, obliczanie kosztów wycieczki");
            System.out.println("==================================================================");
            System.out.println("Całkowity koszt wycieczki: " + trip.calculateTotalCost() + " zł");
            System.out.println("Koszt wycieczki na osobę: " + trip.calculateCostPerPerson() + " zł\n");

            System.out.print("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
            vd.nL();
            String fileName = vd.checkString();

            ltDao.write(fileName, trip);
            System.out.print("Zapisano do pliku: " + fileName);
        }

        if (type == 1) {
            FileDao<ForeignTrip> ftDao = new FileDao<>(ForeignTrip.class);
            ForeignTrip trip = new ForeignTrip(kilometers, participantsAmount, tutorsAmount, pilotsAmount, driversAmount, accomodationAmount, accommodationCosts, foodAmount, foodCosts, tutorWage, pilotWage, insuranceCost, guideAmount, guideCosts, entranceAmount, entranceFees, margin, discount, euroRate);

            System.out.println("Wprowadzono poprawnie wszystkie dane, obliczanie kosztów wycieczki");
            System.out.println("==================================================================");
            System.out.println("Całkowity koszt wycieczki: " + trip.calculateTotalCost() + " zł");
            System.out.println("Koszt wycieczki na osobę: " + trip.calculateCostPerPerson() + " zł\n");

            System.out.print("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
            vd.nL();
            String fileName = vd.checkString();

            ftDao.write(fileName, trip);
            System.out.print("Zapisano do pliku: " + fileName);
        }
    }

    private void loadTrip(int type) {
        System.out.print("\nPodaj nazwę pliku do odczytu: ");
        vd.nL();
        String fileName = vd.checkString();

        if (type == 0) {
            FileDao<LocalTrip> ltDao = new FileDao<>(LocalTrip.class);
            LocalTrip trip = ltDao.read(fileName);
            System.out.println(trip); // simple way of displaying it- to modify in the future
        }
        if (type == 1) {
            FileDao<ForeignTrip> ftDao = new FileDao<>(ForeignTrip.class);
            ForeignTrip trip = ftDao.read(fileName);
            System.out.println(trip); // simple way of displaying it- to modify in the future
        }
    }

    private void loadAndModifyL() {
        System.out.print("\nPodaj nazwę pliku do odczytu: ");
        vd.nL();
        String fileName = vd.checkString();

        FileDao<LocalTrip> ltDao = new FileDao<>(LocalTrip.class);
        LocalTrip trip = ltDao.read(fileName);

        if (trip != null) {
            System.out.println("Poprawnie odczytano dane.\n\n");

            System.out.println("Jeżeli chcesz zmodyfikować jakąś daną wpisz inną wartość, nie wpisz (0) aby pozostawić obecne wartości:");

            System.out.print("Zmień długość trasy lub pozostaw obecną wartość [" + trip.getKilometers() + " km]: ");
            int kilometers = vd.checkInt();
            if (kilometers != 0) {
                trip.setKilometers(kilometers);
            }

            System.out.print("Zmień liczbę uczestników lub pozostaw obecną wartość [" + trip.getParticipantsAmount() + " os.]: ");
            int participantsAmount = vd.checkInt();
            if (participantsAmount != 0) {
                trip.setParticipantsAmount(participantsAmount);
            }

            System.out.print("Zmień liczbę opiekunów lub pozostaw obecną wartość [" + trip.getTutorsAmount() + " os.]: ");
            int tutorsAmount = vd.checkInt();
            if (tutorsAmount != 0) {
                trip.setTutorsAmount(tutorsAmount);
            }

            System.out.print("Zmień stawkę opiekuna lub pozostaw obecną wartość [" + trip.getTutorWage() + " zł (za cały wyjazd)]: ");
            double tutorWage = vd.checkDouble();
            if (tutorWage != 0) {
                trip.setTutorWage(tutorWage);
            }

            System.out.print("Zmień liczbę pilotów lub pozostaw obecną wartość [" + trip.getPilotsAmount() + " os.]: ");
            int pilotsAmount = vd.checkInt();
            if (pilotsAmount != 0) {
                trip.setPilotsAmount(pilotsAmount);
            }

            System.out.print("Zmień stawkę pilota lub pozostaw obecną wartość [" + trip.getPilotWage() + " zł (za cały wyjazd)]: ");
            double pilotWage = vd.checkDouble();
            if (pilotWage != 0) {
                trip.setPilotWage(pilotWage);
            }

            System.out.print("Zmień liczbę kierowców lub pozostaw obecną wartość [" + trip.getDriversAmount() + " os.]: ");
            int driversAmount = vd.checkInt();
            if (driversAmount != 0) {
                trip.setDriversAmount(driversAmount);
            }

            System.out.print("Zmień liczbę noclegów lub pozostaw obecną wartość [" + trip.getAccommodationAmount() + "]: ");
            int accommodationAmount = vd.checkInt();
            if (accommodationAmount != 0) {
                trip.setAccommodationAmount(accommodationAmount);

                ArrayList<Double> accommodationCosts = new ArrayList<>();
                for (int i = 0; i < accommodationAmount; i++) {
                    System.out.print("Podaj koszt noclegu za noc" + (i + 1) + " (za osobę w PLN): ");
                    accommodationCosts.add(vd.checkDouble());
                }
                trip.setAccommodationCost(accommodationCosts);
            }

            System.out.print("Zmień liczbę posiłków lub pozostaw obecną wartość [" + trip.getFoodAmount() + "]: ");
            int foodAmount = vd.checkInt();
            if (foodAmount != 0) {
                trip.setFoodAmount(foodAmount);

                ArrayList<Double> foodCosts = new ArrayList<>();
                for (int i = 0; i < foodAmount; i++) {
                    System.out.print("Podaj koszt posiłku " + (i + 1) + " (za osobę w PLN): ");
                    foodCosts.add(vd.checkDouble());
                }
                trip.setFoodCost(foodCosts);
            }

            System.out.print("Zmień liczbę przewodników lub pozostaw obecną wartość [" + trip.getGuideAmount() + "]: ");
            int guideAmount = vd.checkInt();
            if (guideAmount != 0) {
                trip.setGuideAmount(guideAmount);

                ArrayList<Double> guideCosts = new ArrayList<>();
                for (int i = 0; i < guideAmount; i++) {
                    System.out.print("Podaj koszt przewodnika " + (i + 1) + " (za grupę w PLN): ");
                    guideCosts.add(vd.checkDouble());
                }
                trip.setGuideCost(guideCosts);
            }

            System.out.print("Zmień liczbę wstępów lub pozostaw obecną wartość [" + trip.getEntranceAmount() + "]: ");
            int entranceAmount = vd.checkInt();
            if (entranceAmount != 0) {
                trip.setEntranceAmount(entranceAmount);

                ArrayList<Double> entranceFees = new ArrayList<>();
                for (int i = 0; i < entranceAmount; i++) {
                    System.out.print("Podaj koszt wstępu " + (i + 1) + " (za osobę w PLN): ");
                    entranceFees.add(vd.checkDouble());
                }
                trip.setEntranceFees(entranceFees);
            }

            System.out.print("Zmień koszt ubezpieczenia lub pozostaw obecną wartość [" + trip.getInsuranceCost() + " zł]: ");
            double insuranceCost = vd.checkDouble();
            if (insuranceCost != 0) {
                trip.setInsuranceCost(insuranceCost);
            }

            System.out.print("Zmień marżę lub pozostaw obecną wartość [" + trip.getMargin() + " %]: ");
            double margin = vd.checkDouble();
            if (margin != 0) {
                trip.setMargin(margin);
            }

            System.out.print("Zmień zniżkę lub pozostaw obecną wartość [" + trip.getDiscount() + " %]: ");
            double discount = vd.checkDouble();
            if (discount != 0) {
                trip.setDiscount(discount);
            }

            System.out.print("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
            vd.nL();
            String newFileName = vd.checkString();

            ltDao.write(newFileName, trip);
            System.out.println("Zaktualizowano dane i zapisano do pliku: " + newFileName);
        } else {
            System.out.println("Nie udało się odczytać danych z pliku.");
        }
    }

    private void loadAndModifyF() {
        System.out.print("\nPodaj nazwę pliku do odczytu: ");
        vd.nL();
        String fileName = vd.checkString();
        FileDao<ForeignTrip> ftDao = new FileDao<>(ForeignTrip.class);
        ForeignTrip trip = ftDao.read(fileName);

        if (trip != null) {
            System.out.println("Poprawnie odczytano dane.\n\n");

            System.out.println("Jeżeli chcesz zmodyfikować jakąś daną wpisz inną wartość, nie wpisz (0) aby pozostawić obecne wartości:");

            System.out.print("Zmień kurs EURO lub pozostaw obecną wartość [" + trip.getEuroRate() + " EURO]: ");
            double euroRate = vd.checkDouble();
            if (euroRate != 0) {
                trip.setEuroRate(euroRate);
            }

            System.out.print("Zmień długość trasy lub pozostaw obecną wartość [" + trip.getKilometers() + " km]: ");
            int kilometers = vd.checkInt();
            if (kilometers != 0) {
                trip.setKilometers(kilometers);
            }

            System.out.print("Zmień liczbę uczestników lub pozostaw obecną wartość [" + trip.getParticipantsAmount() + " os.]: ");
            int participantsAmount = vd.checkInt();
            if (participantsAmount != 0) {
                trip.setParticipantsAmount(participantsAmount);
            }

            System.out.print("Zmień liczbę opiekunów lub pozostaw obecną wartość [" + trip.getTutorsAmount() + " os.]: ");
            int tutorsAmount = vd.checkInt();
            if (tutorsAmount != 0) {
                trip.setTutorsAmount(tutorsAmount);
            }

            System.out.print("Zmień stawkę opiekuna lub pozostaw obecną wartość [" + trip.getTutorWage() + " zł (za cały wyjazd)]: ");
            double tutorWage = vd.checkDouble();
            if (tutorWage != 0) {
                trip.setTutorWage(tutorWage);
            }

            System.out.print("Zmień liczbę pilotów lub pozostaw obecną wartość [" + trip.getPilotsAmount() + " os.]: ");
            int pilotsAmount = vd.checkInt();
            if (pilotsAmount != 0) {
                trip.setPilotsAmount(pilotsAmount);
            }

            System.out.print("Zmień stawkę pilota lub pozostaw obecną wartość [" + trip.getPilotWage() + " zł (za cały wyjazd)]: ");
            double pilotWage = vd.checkDouble();
            if (pilotWage != 0) {
                trip.setPilotWage(pilotWage);
            }

            System.out.print("Zmień liczbę kierowców lub pozostaw obecną wartość [" + trip.getDriversAmount() + " os.]: ");
            int driversAmount = vd.checkInt();
            if (driversAmount != 0) {
                trip.setDriversAmount(driversAmount);
            }

            System.out.print("Zmień liczbę noclegów lub pozostaw obecną wartość [" + trip.getAccommodationAmount() + "]: ");
            int accommodationAmount = vd.checkInt();
            if (accommodationAmount != 0) {
                trip.setAccommodationAmount(accommodationAmount);

                ArrayList<Double> accommodationCosts = new ArrayList<>();
                for (int i = 0; i < accommodationAmount; i++) {
                    System.out.print("Podaj koszt noclegu za noc" + (i + 1) + " (za osobę w EURO): ");
                    accommodationCosts.add(vd.checkDouble());
                }
                trip.setAccommodationCost(accommodationCosts);
            }

            System.out.print("Zmień liczbę posiłków lub pozostaw obecną wartość [" + trip.getFoodAmount() + "]: ");
            int foodAmount = vd.checkInt();
            if (foodAmount != 0) {
                trip.setFoodAmount(foodAmount);

                ArrayList<Double> foodCosts = new ArrayList<>();
                for (int i = 0; i < foodAmount; i++) {
                    System.out.print("Podaj koszt posiłku " + (i + 1) + " (za osobę w EURO): ");
                    foodCosts.add(vd.checkDouble());
                }
                trip.setFoodCost(foodCosts);
            }

            System.out.print("Zmień liczbę przewodników lub pozostaw obecną wartość [" + trip.getGuideAmount() + "]: ");
            int guideAmount = vd.checkInt();
            if (guideAmount != 0) {
                trip.setGuideAmount(guideAmount);

                ArrayList<Double> guideCosts = new ArrayList<>();
                for (int i = 0; i < guideAmount; i++) {
                    System.out.print("Podaj koszt przewodnika " + (i + 1) + " (za grupę w EURO): ");
                    guideCosts.add(vd.checkDouble());
                }
                trip.setGuideCost(guideCosts);
            }

            System.out.print("Zmień liczbę wstępów lub pozostaw obecną wartość [" + trip.getEntranceAmount() + "]: ");
            int entranceAmount = vd.checkInt();
            if (entranceAmount != 0) {
                trip.setEntranceAmount(entranceAmount);

                ArrayList<Double> entranceFees = new ArrayList<>();
                for (int i = 0; i < entranceAmount; i++) {
                    System.out.print("Podaj koszt wstępu " + (i + 1) + " (za osobę w EURO): ");
                    entranceFees.add(vd.checkDouble());
                }
                trip.setEntranceFees(entranceFees);
            }

            System.out.print("Zmień koszt ubezpieczenia lub pozostaw obecną wartość [" + trip.getInsuranceCost() + " zł]: ");
            double insuranceCost = vd.checkDouble();
            if (insuranceCost != 0) {
                trip.setInsuranceCost(insuranceCost);
            }

            System.out.print("Zmień marżę lub pozostaw obecną wartość [" + trip.getMargin() + " %]: ");
            double margin = vd.checkDouble();
            if (margin != 0) {
                trip.setMargin(margin);
            }

            System.out.print("Zmień zniżkę lub pozostaw obecną wartość [" + trip.getDiscount() + " %]: ");
            double discount = vd.checkDouble();
            if (discount != 0) {
                trip.setDiscount(discount);
            }

            System.out.print("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
            vd.nL();
            String newFileName = vd.checkString();

            ftDao.write(newFileName, trip);
            System.out.println("Zaktualizowano dane i zapisano do pliku: " + newFileName);
        } else {
            System.out.println("Nie udało się odczytać danych z pliku.");
        }
    }
}
