package prapp;

public enum LocalTransportCost {
    bus50(9.0),
    bus40(8.0),
    bus30(6.5);

    private final double kmRateLocal;

    LocalTransportCost(double kmRateLocal) {
        this.kmRateLocal = kmRateLocal;
    }

    public double getKmRateLocal() {
        return kmRateLocal;
    }

}
