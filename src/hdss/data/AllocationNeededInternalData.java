package hdss.data;

import hdss.exceptions.HydricDSSException;

import hdss.input.data.AllocationNeededInputData;

public class AllocationNeededInternalData {
  private String name;
	private String allocationDate;

	public AmountAvailableInternalData(Object objectToInsert) {
		AllocationNeededInputData newObject = (AllocationNeededInputData)objectToInsert;

		this.name = newObject.getName();
		this.calculationDate = newObject.getAllocationDate();
	}

	public String getName() {
		return this.name;
	}

	public String getAllocationDate() {
		return this.allocationDate;
	}

}
