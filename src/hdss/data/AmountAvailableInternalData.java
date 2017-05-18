package hdss.data;

import hdss.input.data.AmountAvailableInputData;

public class AmountAvailableInternalData {
	private String name;
	private String calculationDate;

	public AmountAvailableInternalData(AmountAvailableInputData objectToInsert) {
		AmountAvailableInputData newObject = objectToInsert;

		this.name = newObject.getName();
		this.calculationDate = newObject.getCalculationDate();
	}

	public String getName() {
		return this.name;
	}

	public String getCalculationDate() {
		return this.calculationDate;
	}

}
