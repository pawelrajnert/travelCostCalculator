package prapp;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Trip implements Serializable {
    private int kilometers;
    private int participantsAmount;
    private int tutorsAmount;
    private int pilotsAmount;
    private int driversAmount;
    private int accommodationAmount;
    private ArrayList<Double> accommodationCost;
    private int foodAmount;
    private ArrayList<Double> foodCost;
    private double tutorWage;
    private double pilotWage;
    private double insuranceCost;
    private int guideAmount;
    private ArrayList<Double> guideCost;
    private double entranceAmount;
    private ArrayList<Double> entranceFees;
    private double margin;
    private double discount;

    public abstract double calculateTotalCost();

    public double calculateCostPerPerson() {
        double perPersonCost;
        perPersonCost = calculateTotalCost() / getParticipantsAmount();

        perPersonCost = Math.ceil(perPersonCost);

        return perPersonCost;
    }

    public Trip(int kilometers, int participantsAmount, int tutorsAmount, int pilotsAmount, int driversAmount, int accommodationAmount, ArrayList<Double> accommodationCost, int foodAmount, ArrayList<Double> foodCost, double tutorWage, double pilotWage, double insuranceCost, int guideAmount, ArrayList<Double> guideCost, double entranceAmount, ArrayList<Double> entranceFees, double margin, double discount) {
        this.kilometers = kilometers;
        this.participantsAmount = participantsAmount;
        this.tutorsAmount = tutorsAmount;
        this.pilotsAmount = pilotsAmount;
        this.driversAmount = driversAmount;
        this.accommodationAmount = accommodationAmount;
        this.accommodationCost = accommodationCost;
        this.foodAmount = foodAmount;
        this.foodCost = foodCost;
        this.tutorWage = tutorWage;
        this.pilotWage = pilotWage;
        this.insuranceCost = insuranceCost;
        this.guideAmount = guideAmount;
        this.guideCost = guideCost;
        this.entranceAmount = entranceAmount;
        this.entranceFees = entranceFees;
        this.margin = margin;
        this.discount = discount;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        if (kilometers > 0) {
            this.kilometers = kilometers;
        } else {
            System.out.println("Błędna liczba kilometrów podczas wycieczki.");
        }
    }

    public int getPersons() {
        int persons;
        persons = getParticipantsAmount() + getDriversAmount() + getTutorsAmount() + getPilotsAmount();
        return persons;
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

    public int getAccommodationAmount() {
        return accommodationAmount;
    }

    public void setAccommodationAmount(int accommodationAmount) {
        if (accommodationAmount > 0 && accommodationAmount < 32) { // max 1 month
            this.accommodationAmount = accommodationAmount;
        } else {
            System.out.println("Błędna liczba noclegów (liczba nocy).");
        }
    }

    public ArrayList<Double> getAccommodationCost() {
        return accommodationCost;
    }

    public void setAccommodationCost(ArrayList<Double> accommodationCost) {
        if (accommodationCost.size() > 0) {
            this.accommodationCost = accommodationCost;
        } else {
            System.out.println("Błędny koszt za nocleg.");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        if (foodAmount > 0 && foodAmount < 32) { // max 1 month
            this.foodAmount = foodAmount;
        } else {
            System.out.println("Błędna liczba posiłków.");
        }
    }

    public ArrayList<Double> getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(ArrayList<Double> foodCost) {
        if (foodCost.size() > 0) {
            this.foodCost = foodCost;
        } else {
            System.out.println("Błędny koszt za posiłek.");
        }
    }

    public double getTutorWage() {
        return tutorWage;
    }

    public void setTutorWage(double tutorWage) {
        if (tutorWage > 0) {
            this.tutorWage = tutorWage;
        } else {
            System.out.println("Błędne wynagrodzenie wychowawcy.");
        }
    }

    public double getPilotWage() {
        return pilotWage;
    }

    public void setPilotWage(double pilotWage) {
        if (pilotWage > 0) {
            this.pilotWage = pilotWage;
        } else {
            System.out.println("Błędne wynagrodzenie pilota.");
        }
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(double insuranceCost) {
        if (insuranceCost > 0) {
            this.insuranceCost = insuranceCost;
        } else {
            System.out.println("Błędny koszt ubezpieczenia.");
        }
    }

    public int getGuideAmount() {
        return guideAmount;
    }

    public void setGuideAmount(int guideAmount) {
        if (guideAmount > 0) {
            this.guideAmount = guideAmount;
        } else {
            System.out.println("Błędna liczba przewodników.");
        }
    }

    public ArrayList<Double> getGuideCost() {
        return guideCost;
    }

    public void setGuideCost(ArrayList<Double> guideCost) {
        if (guideCost.size() > 0) {
            this.guideCost = guideCost;
        } else {
            System.out.println("Błędne wynagrodzenie przewodnika.");
        }
    }

    public double getEntranceAmount() {
        return entranceAmount;
    }

    public void setEntranceAmount(double entranceAmount) {
        if (entranceAmount > 0) {
            this.entranceAmount = entranceAmount;
        } else {
            System.out.println("Błędna liczba wstępów.");
        }
    }

    public void setEntranceFees(ArrayList<Double> entranceFees) {
        if (entranceFees.size() > 0) {
            this.entranceFees = entranceFees;
        } else {
            System.out.println("Błędny koszt biletu wstępu.");
        }
    }

    public ArrayList<Double> getEntranceFees() {
        return entranceFees;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        if (margin < 0 || margin > 100) {
            this.margin = margin;
        } else {
            System.out.println("Błędna wartość marży.");
        }
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount < 0 || discount > 100) {
            this.discount = discount;
        } else {
            System.out.println("Błędna wartość rabatu.");
        }
    }

    public int roundAmount() {
        if (getPersons() <= 30) {
            return 30;
        } else if (getPersons() <= 40) {
            return 40;
        } else {
            return 50;
        }
    }
}
