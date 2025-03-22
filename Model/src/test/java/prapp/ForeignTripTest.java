package prapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ForeignTripTest {
    @Test
    @DisplayName("Calculation of short foreign trip (under 250 km)")
    void shortTripTest() {
        ArrayList<Double> accommodationCost = new ArrayList<>();
        accommodationCost.add(50.0);

        ArrayList<Double> foodCost = new ArrayList<>();
        foodCost.add(15.0);

        ArrayList<Double> guideCost = new ArrayList<>();
        guideCost.add(200.0);

        ArrayList<Double> entranceFees = new ArrayList<>();
        entranceFees.add(15.0);

        ForeignTrip trip = new ForeignTrip(240,
                30, 2, 2, 1,
                1, accommodationCost,
                1, foodCost,
                200.0, 150.0, 500.0,
                1, guideCost,
                1, entranceFees, 15, 10, 4.2
        );

        double manualCost = (2000.0 + (50 * 35 * 4.2) + (15 * 35 * 4.2) + (2 * 200) + (2 * 150) + (200 * 4.2) + 500 + (15 * 35 * 4.2));
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
    @DisplayName("Calculation of long foreign trip (over 250 km)")
    void longTripTest() {
        ArrayList<Double> accommodationCost = new ArrayList<>();
        accommodationCost.add(55.0);

        ArrayList<Double> foodCost = new ArrayList<>();
        foodCost.add(15.0);

        ArrayList<Double> guideCost = new ArrayList<>();
        guideCost.add(500.0);

        ArrayList<Double> entranceFees = new ArrayList<>();
        entranceFees.add(15.0);

        ForeignTrip trip = new ForeignTrip(500,
                30, 2, 2, 1,
                1, accommodationCost,
                1, foodCost,
                200.0, 150.0, 500.0,
                1, guideCost,
                1, entranceFees, 15, 10, 4.2
        );

        double manualCost = ((500 * 12) + (15 * 35 * 4.2) + (55 * 35 * 4.2) + (2 * 200) + (2 * 150) + (500 * 4.2) + 500 + (15 * 35 * 4.2));
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
    @DisplayName("Calculation of long foreign trip (over 250 km), but with bigger data")
    void longTripTestv2() {
        ArrayList<Double> accommodationCost = new ArrayList<>();
        accommodationCost.add(60.0);
        accommodationCost.add(65.0);
        accommodationCost.add(70.0);

        ArrayList<Double> foodCost = new ArrayList<>();
        foodCost.add(15.0);
        foodCost.add(17.0);
        foodCost.add(12.5);

        ArrayList<Double> guideCost = new ArrayList<>();
        guideCost.add(500.0);
        guideCost.add(450.0);

        ArrayList<Double> entranceFees = new ArrayList<>();
        entranceFees.add(15.0);
        entranceFees.add(12.0);

        ForeignTrip trip = new ForeignTrip(1500,
                38, 2, 2, 1,
                1, accommodationCost,
                1, foodCost,
                200.0, 150.0, 500.0,
                1, guideCost,
                2, entranceFees, 15, 10, 4.2
        );

        double manualCost = ((1500 * 12) + (60 * 43 * 4.2) + (65 * 43 * 4.2) + (70 * 43 * 4.2) + (15 * 43 * 4.2) + (12.5 * 43 * 4.2) + (17 * 43 * 4.2) + (2 * 200) + (2 * 150) + (500 * 4.2) + (450 * 4.2) + 500 + (15 * 43 * 4.2) + (12 * 43 * 4.2));
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