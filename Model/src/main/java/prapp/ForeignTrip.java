package prapp;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;

public class ForeignTrip extends Trip {
    private double euroRate;

    public ForeignTrip(int kilometers, int participantsAmount, int tutorsAmount, int pilotsAmount, int driversAmount, int accommodationAmount, ArrayList<Double> accommodationCost, int foodAmount, ArrayList<Double> foodCost, double tutorWage, double pilotWage, double insuranceCost, int guideAmount, ArrayList<Double> guideCost, double entranceAmount, ArrayList<Double> entranceFees, double margin, double discount, double euroRate) {
        super(kilometers, participantsAmount, tutorsAmount, pilotsAmount, driversAmount, accommodationAmount, accommodationCost, foodAmount, foodCost, tutorWage, pilotWage, insuranceCost, guideAmount, guideCost, entranceAmount, entranceFees, margin, discount);
        this.euroRate = euroRate;
    }

    public double getEuroRate() {
        return euroRate;
    }

    public void setEuroRate(double euroRate) {
        this.euroRate = euroRate;
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = 0;

        for (double cost : getAccommodationCost()) {
            totalCost += cost * getPersons() * getEuroRate();
        }

        for (double cost : getFoodCost()) {
            totalCost += cost * getPersons() * getEuroRate();
        }

        totalCost += getTutorsAmount() * getTutorWage();
        totalCost += getPilotsAmount() * getPilotWage();
        totalCost += getInsuranceCost();

        for (double cost : getGuideCost()) {
            totalCost += cost * getEuroRate();
        }

        for (double cost : getEntranceFees()) {
            totalCost += cost * getPersons() * getEuroRate();
        }

        if (getKilometers() < 250) {
            totalCost += Under250km.valueOf("busshort50").getShortTripRate();
        } else {
            ForeignTransportCost transportCost = enumChooser();
            totalCost += getKilometers() * transportCost.getKmRateForeign();
        }

        totalCost += totalCost * (getMargin() / 100);

        if (getDiscount() != 0) {
            totalCost -= totalCost * (getDiscount() / 100);
        }

        totalCost = Math.ceil(totalCost);

        return totalCost;
    }

    @Override
    public double calculateCostPerPerson() {
        return super.calculateCostPerPerson();
    }

    private ForeignTransportCost enumChooser() {
        return ForeignTransportCost.bus50;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
