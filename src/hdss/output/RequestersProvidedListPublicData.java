package hdss.output;

import java.util.List;

public class RequestersProvidedListPublicData {
  private String watershedName;
  private List<RequesterProvidedPublicData> requesters;

  public RequestersProvidedListPublicData(String watershedName, RequestersProvidedInternalData[] newRequesters) {
    this.watershedName = watershedName;
    this.requesters = createRequestersList(newRequesters);
  }

  private List<RequesterProvidedPublicData> createRequestersList(RequestersProvidedInternalData[] newRequesters) {
    List<RequesterProvidedPublicData> aux;

    for (int i=0; i<newRequesters.length;i++) {
      aux.add(new RequesterProvidedPublicData (newRequesters[i].getRequesterName(), newResources[i].getAmountProvided()));
    }
  }

}
