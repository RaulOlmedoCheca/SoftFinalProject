package hdss.input.data;

import java.text.DateFormat;
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
		this.calculationDate = evaluationDate;

	  validated = false;
	  validate();
	}

	public void validate() throws HydricDSSException {
	    	if (!validated) {
	    		validateName();
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
		if (!this.evaluationDate.equals(getCurrentDateString())) {
			throw (new HydricDSSException ("The input file has no data or does not match the expected format"));
		}
	}

	public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

}
