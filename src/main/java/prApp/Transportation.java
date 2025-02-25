package prApp;

public abstract class Transportation {
    private int kmAmount;
    private int participantsAmount;
    private int tutorsAmount;
    private int pilotsAmount;
    private int driversAmount;

    public Transportation(int kmAmount, int participantsAmount, int tutorsAmount, int pilotsAmount, int driversAmount) {
        this.kmAmount = kmAmount;
        this.participantsAmount = participantsAmount;
        this.tutorsAmount = tutorsAmount;
        this.pilotsAmount = pilotsAmount;
        this.driversAmount = driversAmount;
    }

    public abstract double calculateTotalCost();

    public int getKmAmount() {
        return kmAmount;
    }

    public void setKmAmount(int kmAmount) {
        this.kmAmount = kmAmount;
    }

    public int getParticipantsAmount() {
        return participantsAmount;
    }

    public void setParticipantsAmount(int participantsAmount) {
        this.participantsAmount = participantsAmount;
    }

    public int getTutorsAmount() {
        return tutorsAmount;
    }

    public void setTutorsAmount(int tutorsAmount) {
        this.tutorsAmount = tutorsAmount;
    }

    public int getPilotsAmount() {
        return pilotsAmount;
    }

    public void setPilotsAmount(int pilotsAmount) {
        this.pilotsAmount = pilotsAmount;
    }

    public int getDriversAmount() {
        return driversAmount;
    }

    public void setDriversAmount(int driversAmount) {
        this.driversAmount = driversAmount;
    }

    public int getPersons() {
        int persons = 0;
        persons = getParticipantsAmount() + getDriversAmount() + getTutorsAmount() + getPilotsAmount();
        return persons;
    }
}
