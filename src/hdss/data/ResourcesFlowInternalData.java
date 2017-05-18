package hdss.data;

public class ResourcesFlowInternalData {
	private String resourceName;
	private double flowPerMinute;
	private double amountProvided;

	public ResourcesFlowInternalData(String resourceName, double flowPerMinute, double amountProvided) {
		this.resourceName = resourceName;
		this.flowPerMinute = flowPerMinute;
		this.amountProvided = amountProvided;
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
}
