package hdss.data;

public class ReservoirInternalData {

    private String name;
    private double maxCapacity;
    private double currentCapacity;

    public String getName() {
        return this.name;
    }

    public double getMaxCapacity() {
        return this.maxCapacity;
    }

    public double getCurrentCapacity() {
        return this.currentCapacity;
    }

    public void setCurrentCapacity(double value) {
        this.currentCapacity = value;
    }

    // Esfuerzo : 5 minutos

    public ReservoirInternalData(String newName, double newMaxCapacity) {
        this.name = newName;
        this.maxCapacity = newMaxCapacity;
        this.currentCapacity = 0.0f;
    }
}
