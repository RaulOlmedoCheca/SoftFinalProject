package hdss.data;

import hdss.input.data.AmountAvailableInputData;

public class AmountAvailableInternalData {
	private String name;
	private String evaluation;
	private String evaluation_date;
	private double total_requested;
	
	public AmountAvailableInternalData(Object objectToInsert) {
		AmountAvailableInputData newObject = (AmountAvailableInputData)objectToInsert;
		
		this.name = newObject.getName();
		this.evaluation = newObject.getEvaluation();
		this.evaluation_date = newObject.getEvaluationDate();
		this.total_requested = newObject.getTotalRequested();
	}
	
	public String getName() {
		return this.name;
	}

	public String getEvaluation() {
		return this.evaluation;
	}

	public String getEvaluationDate() {
		return this.evaluation_date;
	}

	public double getTotalRequested() {
		return this.total_requested;
	}
	
}
