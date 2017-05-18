package hdss.output;

import java.util.List;

import hdss.output.ResourcesFlowPublicData;
import hdss.data.ResourcesFlowInternalData;

public class AmountAvailablePublicData {
    private String name;
    private String authorizationDate;
    private List<ResourcesFlowPublicData> resources;

    public AmountAvailablePublicData(String name, String authorization_date, ResourcesFlowInternalData[] newResources) {
        this.name = name;
        this.authorizationDate = authorization_date;
        this.resources = createResourcesList(newResources);
    }

    private List<ResourcesFlowPublicData> createResourcesList(ResourcesFlowInternalData[] newResources) {
        List<ResourcesFlowPublicData> aux = null;

        for (int i = 0; i < newResources.length; i++) {
            aux.add(new ResourcesFlowPublicData(newResources[i].getResourceName(), newResources[i].getFlowPerMinute(), newResources[i].getAmountProvided(), newResources[i].getTimeNeeded()));
        }
        return aux;
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
