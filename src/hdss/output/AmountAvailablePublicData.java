package hdss.output;

import java.util.List;

import hdss.data.PlantInternalData;
import hdss.output.ResourcesFlowPublicData;

public class AmountAvailablePublicData {
	private String name;
	private String authorization_date;
	private String time_needed;
	private List<ResourcesFlowPublicData> resources;
	
	public AmountAvailablePublicData(String name, String authorization_date, String time_needed, ResourcesFlow> ) {
		
	}
	
	private double createResourcesList (ResourcesFlowPublicData[] newResources)
	{
		for (int i=0; i<newResources.length;i++)
		{
			this.resources.add(new ResourcesFlowPublicData (newResources[i].getResourceName(), newResources[i].getFlowPerMinute()));
		}
		return plantsMaxCapacity;
	}
}
