package hdss.output;

public class ReservoirPublicData implements WaterResourceTypePublicData {

    private String myName;
    private double maxCapacity;


    public ReservoirPublicData(String name, double max) {
        myName = name;
        maxCapacity = max;
    }

    public String getMyName() {
        return myName;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }
}
