package hdss.data;

import hdss.input.data.AllocationNeededInputData;

public class AllocationNeededInternalData {
	private String name;
	private String allocationDate;

	public AllocationNeededInternalData(Object objectToInsert) {
		AllocationNeededInputData newObject = (AllocationNeededInputData)objectToInsert;

		this.name = newObject.getName();
		this.allocationDate = newObject.getAllocationDate();
	}

	public String getName() {
		return this.name;
	}

	public String getAllocationDate() {
		return this.allocationDate;
	}

}
