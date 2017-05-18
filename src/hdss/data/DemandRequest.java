package hdss.data;

import java.util.Date;

public class DemandRequest {
    private String parcel;
    private String requester;
    private Date demandDate;
    private double demandAmount;

    public String getParcel() {
        return parcel;
    }

    public String getRequester() {
        return requester;
    }

    public Date getDemandDate() {
        return demandDate;
    }

    public double getDemandAmount() {
        return demandAmount;
    }

    // Esfuerzo : 5 minutos

    public DemandRequest(String myParcel, String myRequester, Date myDate, double myAmount) {
        this.parcel = myParcel;
        this.requester = myRequester;
        this.demandDate = myDate;
        this.demandAmount = myAmount;
    }

}
