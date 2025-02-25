package prApp;

import java.util.ArrayList;

public abstract class Trip {
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
        this.kilometers = kilometers;
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
        if (participantsAmount > 0) {
            this.participantsAmount = participantsAmount;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public int getTutorsAmount() {
        return tutorsAmount;
    }

    public void setTutorsAmount(int tutorsAmount) {
        if (tutorsAmount < 0) {
            this.tutorsAmount = tutorsAmount;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public int getPilotsAmount() {
        return pilotsAmount;
    }

    public void setPilotsAmount(int pilotsAmount) {
        if (pilotsAmount < 0) {
            this.pilotsAmount = pilotsAmount;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public int getDriversAmount() {
        return driversAmount;
    }

    public void setDriversAmount(int driversAmount) {
        if (driversAmount < 0) {
            this.driversAmount = driversAmount;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public int getAccommodationAmount() {
        return accommodationAmount;
    }

    public void setAccommodationAmount(int accommodationAmount) {
        if (accommodationAmount < 0) {
            this.accommodationAmount = accommodationAmount;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public ArrayList<Double> getAccommodationCost() {
        return accommodationCost;
    }

    public void setAccommodationCost(ArrayList<Double> accommodationCost) {
        this.accommodationCost = accommodationCost;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void setFoodAmount(int foodAmount) {
        if (foodAmount < 0) {
            this.foodAmount = foodAmount;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public ArrayList<Double> getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(ArrayList<Double> foodCost) {
        this.foodCost = foodCost;
    }

    public double getTutorWage() {
        return tutorWage;
    }

    public void setTutorWage(double tutorWage) {
        if (tutorWage < 0) {
            this.tutorWage = tutorWage;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public double getPilotWage() {
        return pilotWage;
    }

    public void setPilotWage(double pilotWage) {
        if (pilotWage < 0) {
            this.pilotWage = pilotWage;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public double getInsuranceCost() {
        return insuranceCost;
    }

    public void setInsuranceCost(double insuranceCost) {
        if (insuranceCost < 0) {
            this.insuranceCost = insuranceCost;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public int getGuideAmount() {
        return guideAmount;
    }

    public void setGuideAmount(int guideAmount) {
        if (guideAmount < 0) {
            this.guideAmount = guideAmount;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public ArrayList<Double> getGuideCost() {
        return guideCost;
    }

    public void setGuideCost(ArrayList<Double> guideCost) {
        this.guideCost = guideCost;
    }

    public double getEntranceAmount() {
        return entranceAmount;
    }

    public void setEntranceAmount(double entranceAmount) {
        if (entranceAmount < 0) {
            this.entranceAmount = entranceAmount;
        } else {
            System.out.println("Wrong argument provided.");
        }
    }

    public void setEntranceFees(ArrayList<Double> entranceFees) {
        this.entranceFees = entranceFees;
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
            System.out.println("Wrong argument provided.");
        }
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        if (discount < 0 || discount > 100)
            this.discount = discount;
        else {
            System.out.println("Wrong argument provided.");
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
