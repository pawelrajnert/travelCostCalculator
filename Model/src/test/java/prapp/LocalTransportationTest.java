package prapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalTransportationTest {

    @Test
    @DisplayName("Local transport (bus 30)")
    void bus30trip() {
        LocalTransportation transport = new LocalTransportation(1000, 25, 2, 1, 1);

        double manualCost = 0;
        manualCost = (1000 * 6.5);

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + transport.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, transport.calculateTotalCost());
    }

    @Test
    @DisplayName("Local transport (bus 40)")
    void bus40trip() {
        LocalTransportation transport = new LocalTransportation(1000, 30, 2, 1, 1);

        double manualCost = 0;
        manualCost = (1000 * 8);

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + transport.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, transport.calculateTotalCost());
    }

    @Test
    @DisplayName("Local transport (bus 50)")
    void bus50trip() {
        LocalTransportation transport = new LocalTransportation(1000, 42, 2, 1, 1);

        double manualCost = 0;
        manualCost = (1000 * 9);

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + transport.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, transport.calculateTotalCost());
    }
}