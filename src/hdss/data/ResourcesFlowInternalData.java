package hdss.data;

public class ResourcesFlowInternalData {
	private String resourceName;
	private double flowPerMinute;

	public ResourcesFlowInternalData(String resourceName, double flowPerMinute) {
		this.resourceName = resourceName;
		this.flowPerMinute = flowPerMinute;
	}

	public String getResourceName() {
		return this.resourceName;
	}

	public double getFlowPerMinute() {
		return this.flowPerMinute;
	}
}
