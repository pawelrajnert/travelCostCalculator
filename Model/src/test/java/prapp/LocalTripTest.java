package prapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LocalTripTest {

    @Test
    @DisplayName("Calculation of short trip (under 250 km)")
    void shortTripTest() {
        ArrayList<Double> accommodationCost = new ArrayList<>();
        accommodationCost.add(100.0);

        ArrayList<Double> foodCost = new ArrayList<>();
        foodCost.add(50.0);

        ArrayList<Double> guideCost = new ArrayList<>();
        guideCost.add(500.0);

        ArrayList<Double> entranceFees = new ArrayList<>();
        entranceFees.add(30.0);

        LocalTrip trip = new LocalTrip(240,
                30, 2, 2, 1,
                1, accommodationCost,
                1, foodCost,
                200.0, 150.0, 500.0,
                1, guideCost,
                1, entranceFees, 15, 10
        );

        double manualCost = (1700.0 + (100 * 35) + (50 * 35) + (2 * 200) + (2 * 150) + 500 + 500 + (30 * 35));
        manualCost += manualCost * 0.15;
        manualCost -= manualCost * 0.10;
        manualCost = Math.ceil(manualCost);

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + trip.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, trip.calculateTotalCost());

        double ppc = Math.ceil(manualCost / trip.getParticipantsAmount());

        System.out.println("Cost per person calculation: ");
        System.out.println("Calculator: " + trip.calculateCostPerPerson());
        System.out.println("Manual calculation: " + ppc);
        System.out.println();
        assertEquals(ppc, trip.calculateCostPerPerson());
    }

    @Test
    @DisplayName("Calculation of long trip (over 250 km)")
    void longTripTest() {
        ArrayList<Double> accommodationCost = new ArrayList<>();
        accommodationCost.add(100.0);

        ArrayList<Double> foodCost = new ArrayList<>();
        foodCost.add(50.0);

        ArrayList<Double> guideCost = new ArrayList<>();
        guideCost.add(500.0);

        ArrayList<Double> entranceFees = new ArrayList<>();
        entranceFees.add(30.0);

        LocalTrip trip = new LocalTrip(500,
                30, 2, 2, 1,
                1, accommodationCost,
                1, foodCost,
                200.0, 150.0, 500.0,
                1, guideCost,
                1, entranceFees, 15, 10
        );

        double manualCost = ((500 * 8) + (100 * 35) + (50 * 35) + (2 * 200) + (2 * 150) + 500 + 500 + (30 * 35));
        manualCost += manualCost * 0.15;
        manualCost -= manualCost * 0.10;
        manualCost = Math.ceil(manualCost);

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + trip.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, trip.calculateTotalCost());

        double ppc = Math.ceil(manualCost / trip.getParticipantsAmount());

        System.out.println("Cost per person calculation: ");
        System.out.println("Calculator: " + trip.calculateCostPerPerson());
        System.out.println("Manual calculation: " + ppc);
        System.out.println();
        assertEquals(ppc, trip.calculateCostPerPerson());
    }

    @Test
    @DisplayName("Calculation of long trip (over 250 km), but with bigger data")
    void longTripTestv2() {
        ArrayList<Double> accommodationCost = new ArrayList<>();
        accommodationCost.add(100.0);
        accommodationCost.add(130.0);
        accommodationCost.add(120.0);

        ArrayList<Double> foodCost = new ArrayList<>();
        foodCost.add(50.0);
        foodCost.add(70.0);
        foodCost.add(120.0);

        ArrayList<Double> guideCost = new ArrayList<>();
        guideCost.add(500.0);
        guideCost.add(450.0);

        ArrayList<Double> entranceFees = new ArrayList<>();
        entranceFees.add(30.0);
        entranceFees.add(35.0);

        LocalTrip trip = new LocalTrip(1500,
                38, 2, 2, 1,
                1, accommodationCost,
                1, foodCost,
                200.0, 150.0, 500.0,
                1, guideCost,
                2, entranceFees, 15, 10
        );

        double manualCost = ((1500 * 9) + (120 * 43) + (70 * 43) + (50 * 43) + (100 * 43) + (120 * 43) + (130 * 43) + (2 * 200) + (2 * 150) + 500 + 450 + 500 + (30 * 43) + (35 * 43));
        manualCost += manualCost * 0.15;
        manualCost -= manualCost * 0.10;
        manualCost = Math.ceil(manualCost);

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + trip.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, trip.calculateTotalCost());

        double ppc = Math.ceil(manualCost / trip.getParticipantsAmount());

        System.out.println("Cost per person calculation: ");
        System.out.println("Calculator: " + trip.calculateCostPerPerson());
        System.out.println("Manual calculation: " + ppc);
        System.out.println();
        assertEquals(ppc, trip.calculateCostPerPerson());
    }
}