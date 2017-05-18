package hdss.input.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import hdss.exceptions.HydricDSSException;

public class AmountAvailableInputData {

	private String name;
	private String calculationDate;

	private Boolean validated;

	public String getName() {
		return this.name;
	}

	public String getCalculationDate() {
		return this.calculationDate;
	}

	public AmountAvailableInputData (String watershedName, String calculationDate) throws HydricDSSException {
	  this.name = watershedName;
	  this.calculationDate = calculationDate;

	  validated = false;
	  validate();
	}

	public void validate() throws HydricDSSException {
	    	if (!validated) {
	    		validateName();
					validateCalculationDate();
	    		validated = true;
    		}
	}

	private void validateName() throws HydricDSSException {
		if ((this.name.length()>50)||(this.name.length()<1))
		{
			throw (new HydricDSSException ("The input file has no data or does not match the expected format"));
		}
	}

	private void validateCalculationDate() throws HydricDSSException {
		if (!isValidDateFormat("dd/mm/yyyy", this.calculationDate)) {
			throw (new HydricDSSException ("The input file has no data or does not match the expected format"));
		}
	}

	private static boolean isValidDateFormat(String format, String value) throws HydricDSSException {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            throw (new HydricDSSException("The input file has no data or does not match the expected format"));
        }
        return date != null;
    }

}
