package hdss.data;

public class ResourcesFlowInternalData {
    private String resourceName;
    private double flowPerMinute;
    private double amountProvided;
    private int timeNeeded;

    public ResourcesFlowInternalData(String resourceName, double flowPerMinute, double amountProvided, int timeNeeded) {
        this.resourceName = resourceName;
        this.flowPerMinute = flowPerMinute;
        this.amountProvided = amountProvided;
        this.timeNeeded = timeNeeded;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public double getFlowPerMinute() {
        return this.flowPerMinute;
    }

    public double getAmountProvided() {
        return this.amountProvided;
    }

    public int getTimeNeeded() {
        return this.timeNeeded;
    }
}
