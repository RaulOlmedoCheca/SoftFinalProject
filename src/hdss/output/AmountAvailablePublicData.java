package hdss.output;

import java.util.List;

import hdss.data.ResourcesFlowInternalData;

public class AmountAvailablePublicData {
	private String name;
	private String authorizationDate;
	private List<ResourcesFlowPublicData> resources;

	public AmountAvailablePublicData(String name, String authorization_date, ResourcesFlowInternalData [] newResources) {
		this.name = name;
		this.authorizationDate = authorization_date;
		createResourcesList(newResources);
	}

	private void createResourcesList (ResourcesFlowInternalData[] newResources) {
		for (int i=0; i<newResources.length;i++) {
			this.resources.add(new ResourcesFlowPublicData (newResources[i].getResourceName(), newResources[i].getFlowPerMinute(), newResources[i].getAmountProvided(), newResources[i].getTimeNeeded()));
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getAuthorizationDate() {
		return this.authorizationDate;
	}
	
	public List<ResourcesFlowPublicData> getResources() {
		return this.resources;
	}
}
