package hdss.output;

import java.util.List;

import hdss.data.RequesterProvidedInternalData;

public class RequestersProvidedListPublicData {
  private String watershedName;
  private List<RequesterProvidedPublicData> requesters;

  public RequestersProvidedListPublicData(String watershedName, RequesterProvidedInternalData[] newRequesters) {
    this.watershedName = watershedName;
    createRequestersList(newRequesters);
  }

  private void createRequestersList(RequesterProvidedInternalData[] newRequesters) {
    for (int i=0; i<newRequesters.length;i++) {
      this.requesters.add(new RequesterProvidedPublicData (newRequesters[i].getRequesterName(), newRequesters[i].getAmountProvided()));
    }
  }
  
  public String getWatershedName() {
	  return this.watershedName;
  }
  
  public List<RequesterProvidedPublicData> getRequesters() {
	  return this.requesters;
  }

}
