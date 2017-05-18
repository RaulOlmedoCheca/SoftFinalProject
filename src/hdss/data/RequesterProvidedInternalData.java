package hdss.data;

public class RequesterProvidedInternalData {
	private String requesterName;
	private double amountProvided;

	public RequesterProvidedInternalData(String requesterName, double amountProvided) {
		this.requesterName = requesterName;
		this.amountProvided = amountProvided;
	}

	public String getRequesterName() {
		return this.requesterName;
	}

	public double getAmountProvided() {
		return this.amountProvided;
	}
}