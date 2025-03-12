package prApp;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

public class LocalTransportation extends Transportation implements Serializable {
    public LocalTransportation(int kmAmount, int participantsAmount, int tutorsAmount, int pilotsAmount, int driversAmount) {
        super(kmAmount, participantsAmount, tutorsAmount, pilotsAmount, driversAmount);
    }

    @Override
    public double calculateTotalCost() {
        double totalCost = 0;

        LocalTransportCost transportCost = enumChooser();
        totalCost += getKmAmount() * transportCost.getKmRateLocal();

        return totalCost;
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
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.NO_CLASS_NAME_STYLE);
    }

}
