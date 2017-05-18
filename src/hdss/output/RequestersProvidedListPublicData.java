package hdss.output;

import java.util.List;

import hdss.data.RequesterProvidedInternalData;

public class RequestersProvidedListPublicData {
    private String watershedName;
    private List<RequesterProvidedPublicData> requesters;

    public RequestersProvidedListPublicData(String watershedName, RequesterProvidedInternalData[] newRequesters) {
        this.watershedName = watershedName;
        this.requesters = createRequestersList(newRequesters);
    }

    private List<RequesterProvidedPublicData> createRequestersList(RequesterProvidedInternalData[] newRequesters) {
        List<RequesterProvidedPublicData> aux = null;

        for (int i = 0; i < newRequesters.length; i++) {
            aux.add(new RequesterProvidedPublicData(newRequesters[i].getRequesterName(), newRequesters[i].getAmountProvided()));
        }

        return aux;
    }

    public String getWatershedName() {
        return this.watershedName;
    }

    public List<RequesterProvidedPublicData> getRequesters() {
        return this.requesters;
    }

}
