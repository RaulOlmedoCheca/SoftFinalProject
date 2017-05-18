package hdss.output;

public class RequesterProvidedPublicData {
  private String requesterName;
	private double amountProvided;

	public RequesterProvidedPublicData(String requesterName, double amountProvided) {
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
