package prapp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalTransportationTest {

    @Test
    @DisplayName("Local transport (bus 30)")
    void bus30transport() {
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
    void bus40transport() {
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
    void bus50transport() {
        LocalTransportation transport = new LocalTransportation(1000, 42, 2, 1, 1);

        double manualCost = 0;
        manualCost = (1000 * 9);

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + transport.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, transport.calculateTotalCost());
    }

    @Test
    @DisplayName("Local short transport (bus 30)")
    void bus30shorttransport() {
        LocalTransportation transport = new LocalTransportation(100, 25, 2, 1, 1);

        double manualCost = 1400;

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + transport.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, transport.calculateTotalCost());
    }

    @Test
    @DisplayName("Local short transport (bus 40)")
    void bus40shorttransport() {
        LocalTransportation transport = new LocalTransportation(100, 30, 2, 1, 1);

        double manualCost = 1700;

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + transport.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, transport.calculateTotalCost());
    }

    @Test
    @DisplayName("Local short transport (bus 50)")
    void bus50shorttransport() {
        LocalTransportation transport = new LocalTransportation(100, 42, 2, 1, 1);

        double manualCost = 2000;

        System.out.println("Total cost calculation: ");
        System.out.println("Calculator: " + transport.calculateTotalCost());
        System.out.println("Manual calculation: " + manualCost);
        System.out.println();
        assertEquals(manualCost, transport.calculateTotalCost());
    }


}