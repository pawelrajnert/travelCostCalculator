package prapp;

import java.util.ArrayList;

public class CheckFunctions {
    public static boolean wrongValueInArray(ArrayList<Double> data, double minValue, double maxValue) {
        if (data.isEmpty()) {
            return false;
        }
        for (double d : data) {
            if (d < minValue || d > maxValue) {
                return true;
            }
        }
        return false;
    }

}
