package prapp;

public enum ForeignTransportCost {
    bus50(12.0);

    private final double kmRateForeign;

    ForeignTransportCost(double kmRate) {
        this.kmRateForeign = kmRate;
    }

    public double getKmRateForeign() {
        return kmRateForeign;
    }
}
