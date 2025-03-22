package prapp;

import java.io.Serializable;

public abstract class Transportation implements Serializable {
    private int kmAmount;
    private int participantsAmount;
    private int tutorsAmount;
    private int pilotsAmount;
    private int driversAmount;

    public Transportation(int kmAmount, int participantsAmount, int tutorsAmount, int pilotsAmount, int driversAmount) {
        this.kmAmount = kmAmount;
        this.participantsAmount = participantsAmount;
        this.tutorsAmount = tutorsAmount;
        this.pilotsAmount = pilotsAmount;
        this.driversAmount = driversAmount;
    }

    public abstract double calculateTotalCost();

    public int getKmAmount() {
        return kmAmount;
    }

    public void setKmAmount(int kmAmount) {
        if (kmAmount > 0) {
            this.kmAmount = kmAmount;
        } else {
            System.out.println("Błędna liczba kilometrów przejazdu.");
        }
    }

    public int getParticipantsAmount() {
        return participantsAmount;
    }

    public void setParticipantsAmount(int participantsAmount) {
        if (participantsAmount > 0 && participantsAmount <= 46) { // minimum 1 driver, 1 pilot and 2 tutors
            this.participantsAmount = participantsAmount;
        } else {
            System.out.println("Błędna liczba uczestników. Minimalna liczba to 1, a maksymalna 46.");
        }
    }

    public int getTutorsAmount() {
        return tutorsAmount;
    }

    public void setTutorsAmount(int tutorsAmount) {
        if (tutorsAmount > 0 && tutorsAmount <= 4) {
            this.tutorsAmount = tutorsAmount;
        } else {
            System.out.println("Błedna liczba opiekunów. Minimalna liczba to 1, a maksymalna to 4.");
        }
    }

    public int getPilotsAmount() {
        return pilotsAmount;
    }

    public void setPilotsAmount(int pilotsAmount) {
        if (pilotsAmount > 0 && pilotsAmount <= 2) {
            this.pilotsAmount = pilotsAmount;
        } else {
            System.out.println("Błedna liczba pilotów. Minimalna liczba to 1, a maksymalna to 2.");
        }
        ;
    }

    public int getDriversAmount() {
        return driversAmount;
    }

    public void setDriversAmount(int driversAmount) {
        if (driversAmount > 0 && driversAmount <= 2) {
            this.driversAmount = driversAmount;
        } else {
            System.out.println("Błędna liczba kierowców. Minimalna liczba to 1, a maksymalna to 2.");
        }
    }

    public int getPersons() {
        int persons = 0;
        persons = getParticipantsAmount() + getDriversAmount() + getTutorsAmount() + getPilotsAmount();
        return persons;
    }
}
