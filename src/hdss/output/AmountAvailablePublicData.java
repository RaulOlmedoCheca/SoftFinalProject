package hdss.output;

import java.util.List;

import hdss.data.PlantInternalData;
import hdss.output.ResourcesFlowPublicData;

public class AmountAvailablePublicData {
	private String name;
	private String authorization_date;
	private String time_needed;
	private List<ResourcesFlowPublicData> resources;

	public AmountAvailablePublicData(String name, String authorization_date, String time_needed, ResourcesFlowInternalData [] newResources) {
		this.name = name;
		this.authorization_date = authorization_date;
		this.time_needed = time_needed;
		this.resources = createResourcesList(newResources);
	}

	private List<ResourcesFlowPublicData> createResourcesList (ResourcesFlowPublicData[] newResources) {
		List<ResourcesFlowPublicData> aux;
		for (int i=0; i<newResources.length;i++) {
			this.aux.add(new ResourcesFlowPublicData (newResources[i].getResourceName(), newResources[i].getFlowPerMinute()));
		}
		return aux;
	}
}
