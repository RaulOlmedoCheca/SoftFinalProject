package hdss.data;

import hdss.input.data.AmountAvailableInputData;

public class AmountAvailableInternalData {
	private String name;
	private String calculationDate;

	public AmountAvailableInternalData(Object objectToInsert) {
		AmountAvailableInputData newObject = (AmountAvailableInputData)objectToInsert;

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
