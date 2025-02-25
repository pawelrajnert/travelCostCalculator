package prApp;

public enum Under250km {
    busshort50(2000.0),
    busshort40(1700.0),
    busshort30(1400.0);

    private final double shortTripRate;

    Under250km(double shortTripRate) {
        this.shortTripRate = shortTripRate;
    }

    public double getShortTripRate() {
        return shortTripRate;
    }
}
