package hdss.data;

import hdss.input.data.AllocationNeededInputData;

public class AllocationNeededInternalData {
	private String name;
	private String allocationDate;

	public AllocationNeededInternalData(AllocationNeededInputData objectToInsert) {
		this.name = objectToInsert.getName();
		this.allocationDate = objectToInsert.getAllocationDate();
	}

	public String getName() {
		return this.name;
	}

	public String getAllocationDate() {
		return this.allocationDate;
	}

}
