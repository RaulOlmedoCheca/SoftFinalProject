package hdss.output;

public class DesalinationPlantPublicData implements WaterResourceTypePublicData {

    private String myName;
    private double maxCapacity;

    // Esfuerzo : 2 minutos
    public DesalinationPlantPublicData(String name, double max) {
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
