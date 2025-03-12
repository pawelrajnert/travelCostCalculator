package prApp;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ForeignTransportation extends Transportation {
    public ForeignTransportation(int kmAmount, int participantsAmount, int tutorsAmount, int pilotsAmount, int driversAmount) {
        super(kmAmount, participantsAmount, tutorsAmount, pilotsAmount, driversAmount);
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = 0;
        ForeignTransportCost transportCost = enumChooser();
        totalCost += getKmAmount() * transportCost.getKmRateForeign();
        return totalCost;
    }

    private ForeignTransportCost enumChooser() {
        return ForeignTransportCost.bus50;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }
}
