package prapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ForeignTransportationTest {

    @Test
    @DisplayName("Foreign transport test (const cost, because of 50 person bus)")
    void foreignBusTrip() {
        ForeignTransportation transport = new ForeignTransportation(1000, 25, 2, 1, 1);

        double manualCost = 0;
        manualCost = (1000 * 12);

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + transport.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, transport.calculateTotalCost());
    }

}