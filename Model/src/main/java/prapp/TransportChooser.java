package prapp;

public class TransportChooser {
    private final VerifyData vd;

    public TransportChooser(VerifyData vd) {
        this.vd = vd;
    }

    public void transportOptions(int type) {
        if (type == 0) {
            System.out.println("Kalkulator kosztów transportu lokalnego");
        }

        if (type == 1) {
            System.out.println("Kalkulator kosztów transportu zagranicznego");
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
                    createNewTransport(0);
                    break;
                }
                if (type == 1) {
                    createNewTransport(1);
                    break;
                }
            }
            case 2: {
                if (type == 0) {
                    loadTransport(0);
                    break;
                }
                if (type == 1) {
                    loadTransport(1);
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

    public void createNewTransport(int type) {
        System.out.println("\nInformacje o długości trasy ");
        System.out.print("Wprowadź odległość (km): ");
        int kmAmount = vd.checkInt();
        while (kmAmount <= 0) {
            System.out.print("Błędna liczba kilometrów przejazdu. Wprowadź poprawną wartość: ");
            kmAmount = vd.checkInt();
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

        System.out.print("Wprowadź liczbę pilotów: ");
        int pilotsAmount = vd.checkInt();
        while (pilotsAmount <= 0 || pilotsAmount > 2) {
            System.out.print("Błędna liczba pilotów. Wprowadź poprawną wartość: ");
            pilotsAmount = vd.checkInt();
        }

        System.out.print("Wprowadź liczbę kierowców: ");
        int driversAmount = vd.checkInt();
        while (driversAmount <= 0 || driversAmount > 2) {
            System.out.print("Błędna liczba kierowców. Wprowadź poprawną wartość: ");
            driversAmount = vd.checkInt();
        }

        switch (type) {
            case 0: {
                FileDao<LocalTransportation> ltDao = new FileDao<>(LocalTransportation.class);
                LocalTransportation transport = new LocalTransportation(kmAmount, participantsAmount, tutorsAmount, pilotsAmount, driversAmount);

                System.out.println("Wyniki kalkulacji dla transportu krajowego");
                System.out.println("Całkowity koszt transportu wynosi: " +
                        transport.calculateTotalCost() + " zł\n");

                System.out.print("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
                vd.nL();
                String fileName = vd.checkString();

                ltDao.write(fileName, transport);
                System.out.print("Zapisano do pliku: " + fileName);
                break;
            }
            case 1: {
                FileDao<ForeignTransportation> ftDao = new FileDao<>(ForeignTransportation.class);
                ForeignTransportation transport = new ForeignTransportation(kmAmount, participantsAmount, tutorsAmount, pilotsAmount, driversAmount);

                System.out.println("Wyniki kalkulacji dla transportu zagranicznego");
                System.out.println("Całkowity koszt transportu wynosi: " +
                        transport.calculateTotalCost() + " zł\n");

                System.out.print("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
                vd.nL();
                String fileName = vd.checkString();


                ftDao.write(fileName, transport);
                System.out.print("Zapisano do pliku: " + fileName);
                break;
            }
            default: {
                System.out.println("Wybrano nieprawidłową opcję.");
            }
        }
    }

    private void loadTransport(int type) {
        System.out.print("\nPodaj nazwę pliku do odczytu: ");
        vd.nL();
        String fileName = vd.checkString();

        if (type == 0) {
            FileDao<LocalTransportation> ltDao = new FileDao<>(LocalTransportation.class);
            LocalTransportation transport = ltDao.read(fileName);
            System.out.println(transport); // simple way of displaying it- to modify in the future
        }
        if (type == 1) {
            FileDao<ForeignTransportation> ftDao = new FileDao<>(ForeignTransportation.class);
            ForeignTransportation transport = ftDao.read(fileName);
            System.out.println(transport); //simple way of displaying it- to modify in the future
        }
    }

    private void loadAndModifyL() {
        System.out.print("\nPodaj nazwę pliku do odczytu: ");
        vd.nL();
        String fileName = vd.checkString();

        FileDao<LocalTransportation> ltDao = new FileDao<>(LocalTransportation.class);
        LocalTransportation transport = ltDao.read(fileName);

        if (transport != null) {
            System.out.println("Poprawnie odczytano dane.\n\n");

            System.out.println("Jeżeli chcesz zmodyfikować jakąś daną wpisz inną wartość, nie wpisz (0) aby pozostawić obecne wartości:");

            System.out.print("Zmień długość trasy lub pozostaw obecną wartość [" + transport.getKmAmount() + " km]: ");
            int kmAmount = vd.checkInt();
            if (kmAmount != 0) {
                transport.setKmAmount(kmAmount);
            }

            System.out.print("Zmień liczbę uczetników lub pozostaw obecną wartość [" + transport.getParticipantsAmount() + " os.]: ");
            int participantsAmount = vd.checkInt();
            if (participantsAmount != 0) {
                transport.setParticipantsAmount(participantsAmount);
            }

            System.out.print("Zmień liczbę opiekunów lub pozostaw obecną wartość [" + transport.getTutorsAmount() + " os.]: ");
            int tutorsAmount = vd.checkInt();
            if (tutorsAmount != 0) {
                transport.setTutorsAmount(tutorsAmount);
            }

            System.out.print("Zmień liczbę pilotów lub pozostaw obecną wartość [" + transport.getPilotsAmount() + " os.]: ");
            int pilotsAmount = vd.checkInt();
            if (pilotsAmount != 0) {
                transport.setPilotsAmount(pilotsAmount);
            }

            System.out.print("Zmień liczbę kierowców lub pozostaw obecną wartość [" + transport.getDriversAmount() + " os.]: ");
            int driversAmount = vd.checkInt();
            if (driversAmount != 0) {
                transport.setDriversAmount(driversAmount);
            }

            System.out.println("Wyniki kalkulacji dla transportu krajowego");
            System.out.println("Całkowity koszt transportu wynosi: " +
                    transport.calculateTotalCost() + " zł\n");

            System.out.print("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
            vd.nL();
            String newFileName = vd.checkString();

            ltDao.write(newFileName, transport);
            System.out.println("Zapisano do pliku: " + newFileName);
        } else {
            System.out.println("Nie udało się odczytać danych z pliku.");
        }
    }

    private void loadAndModifyF() {
        System.out.print("\nPodaj nazwę pliku do odczytu: ");
        vd.nL();
        String fileName = vd.checkString();

        FileDao<ForeignTransportation> ftDao = new FileDao<>(ForeignTransportation.class);
        ForeignTransportation transport = ftDao.read(fileName);

        if (transport != null) {
            System.out.println("Poprawnie odczytano dane.\n\n");

            System.out.println("Jeżeli chcesz zmodyfikować jakąś daną wpisz inną wartość, nie wpisz (0) aby pozostawić obecne wartości:");

            System.out.print("Zmień długość trasy lub pozostaw obecną wartość [" + transport.getKmAmount() + " km]: ");
            int kmAmount = vd.checkInt();
            if (kmAmount != 0) {
                transport.setKmAmount(kmAmount);
            }

            System.out.print("Zmień liczbę uczetników lub pozostaw obecną wartość [" + transport.getParticipantsAmount() + " os.]: ");
            int participantsAmount = vd.checkInt();
            if (participantsAmount != 0) {
                transport.setParticipantsAmount(participantsAmount);
            }

            System.out.print("Zmień liczbę opiekunów lub pozostaw obecną wartość [" + transport.getTutorsAmount() + " os.]: ");
            int tutorsAmount = vd.checkInt();
            if (tutorsAmount != 0) {
                transport.setTutorsAmount(tutorsAmount);
            }

            System.out.print("Zmień liczbę pilotów lub pozostaw obecną wartość [" + transport.getPilotsAmount() + " os.]: ");
            int pilotsAmount = vd.checkInt();
            if (pilotsAmount != 0) {
                transport.setPilotsAmount(pilotsAmount);
            }

            System.out.print("Zmień liczbę kierowców lub pozostaw obecną wartość [" + transport.getDriversAmount() + " os.]: ");
            int driversAmount = vd.checkInt();
            if (driversAmount != 0) {
                transport.setDriversAmount(driversAmount);
            }

            System.out.println("Wyniki kalkulacji dla transportu zagranicznego");
            System.out.println("Całkowity koszt transportu wynosi: " +
                    transport.calculateTotalCost() + " zł\n");

            System.out.print("\n \nWprowadź nazwę pliku do którego chcesz zapisać dane: ");
            vd.nL();
            String newFileName = vd.checkString();

            ftDao.write(newFileName, transport);
            System.out.println("Zapisano do pliku: " + newFileName);
        } else {
            System.out.println("Nie udało się odczytać danych z pliku.");
        }
    }

}
