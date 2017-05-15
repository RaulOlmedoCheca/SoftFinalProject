package hdss.data;

import hdss.input.data.IrrigationDemandInputData;

public class DemandInternalData {

	private String name;
	public String getName ()
	{
		return name;
	}
	
	private DemandRequest[] demands;
	public  DemandRequest[] getDemands ()
	{
		return demands;
	}
	
	// Esfuerzo : 5 minutos
	public DemandInternalData (IrrigationDemandInputData newDemand)
	{
		demands = new DemandRequest [10];
		this.name = newDemand.getWatershedName();
		DemandRequest myDemand = new DemandRequest (newDemand.getParcelName(),newDemand.getRequesterName(), newDemand.getDate(),newDemand.getAmount());
	}
}
