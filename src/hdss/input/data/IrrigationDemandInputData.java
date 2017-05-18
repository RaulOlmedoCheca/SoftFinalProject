package hdss.input.data;

import java.util.Date;

import hdss.exceptions.HydricDSSException;

public class IrrigationDemandInputData {
    private String watershedName;
    private String requesterName;
    private String parcelName;
    private double amount;
    private Date date;

    private Boolean validated;

    public String getWatershedName() {
        return watershedName;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public String getParcelName() {
        return parcelName;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    //Esfuerzo Actual: 2 minutos
    public IrrigationDemandInputData(String watershed, String requester, String parcel, double mAmount, Date mDate) throws HydricDSSException {
        this.watershedName = watershed;
        this.requesterName = requester;
        this.parcelName = parcel;
        this.amount = mAmount;
        this.date = mDate;
        validated = false;
        Validate();
    }

    //Esfuerzo Actual: 3 minutos
    public void Validate() throws HydricDSSException {
        if (!validated) {
            this.validateName(this.getWatershedName());
            this.validateName(this.requesterName);
            this.validateName(this.parcelName);
            validateAmount();
            validateDate();
            validated = true;
        }
    }

    //Esfuerzo Actual: 3 minutos
    private void validateAmount() throws HydricDSSException {
        if (this.amount <= 0.0f) {
            throw (new HydricDSSException("La cantidad de agua solicitada no es v�lida"));
        }
    }

    //Esfuerzo Actual: 28 minutos
    private void validateDate() throws HydricDSSException {
        Date currentDate = new Date(System.currentTimeMillis());
        if (currentDate.before(this.date)) {
            throw (new HydricDSSException("La fecha de la petici�n no es correcta"));
        }
    }

    //Esfuerzo Actual: 3 minutos
    private void validateName(String name) throws HydricDSSException {
        if ((name.length() > 50) || (name.length() < 1)) {
            throw (new HydricDSSException("Nombre con un n�mero de caracteres mayor que 50 o menor que 1"));
        }
    }

}
