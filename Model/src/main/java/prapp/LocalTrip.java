package prapp;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.ArrayList;

public class LocalTrip extends Trip {
    public LocalTrip(int kilometers, int participantsAmount, int tutorsAmount, int pilotsAmount, int driversAmount, int accommodationAmount, ArrayList<Double> accommodationCost, int foodAmount, ArrayList<Double> foodCost, double tutorWage, double pilotWage, double insuranceCost, int guideAmount, ArrayList<Double> guideCost, int entranceAmount, ArrayList<Double> entranceFees, double margin, double discount) {
        super(kilometers, participantsAmount, tutorsAmount, pilotsAmount, driversAmount, accommodationAmount, accommodationCost, foodAmount, foodCost, tutorWage, pilotWage, insuranceCost, guideAmount, guideCost, entranceAmount, entranceFees, margin, discount);
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = 0;

        if (getAccommodationAmount() > 0) {
            for (double cost : getAccommodationCost()) {
                totalCost += cost * getPersons();
            }
        }

        if (getFoodAmount() > 0) {
            for (double cost : getFoodCost()) {
                totalCost += cost * getPersons();
            }
        }

        totalCost += getTutorsAmount() * getTutorWage();
        totalCost += getPilotsAmount() * getPilotWage();
        totalCost += getInsuranceCost();

        if (getGuideAmount() > 0) {
            for (double cost : getGuideCost()) {
                totalCost += cost;
            }
        }

        if (getEntranceAmount() > 0) {
            for (double cost : getEntranceFees()) {
                totalCost += cost * getPersons();
            }
        }

        if (getKilometers() < 250) {
            totalCost += Under250km.valueOf("busshort" + roundAmount()).getShortTripRate();
        } else {
            LocalTransportCost transportCost = enumChooser();
            totalCost += getKilometers() * transportCost.getKmRateLocal();
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

    private LocalTransportCost enumChooser() {
        if (getPersons() <= 30) {
            return LocalTransportCost.bus30;
        } else if (getPersons() <= 40) {
            return LocalTransportCost.bus40;
        } else {
            return LocalTransportCost.bus50;
        }
    }

    @Override
    public int roundAmount() {
        return super.roundAmount();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
