package prApp;

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

}
