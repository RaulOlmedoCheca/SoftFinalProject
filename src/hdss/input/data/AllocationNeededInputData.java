package hdss.input.data;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import hdss.exceptions.HydricDSSException;

public class AllocationNeededInputData {

	private String name;
	private String allocationDate;

	private Boolean validated;

	public String getName() {
		return this.name;
	}

	public String getAllocationDate() {
		return this.allocationDate;
	}

	public AllocationNeededInputData (String watershedName, String allocationDate) throws HydricDSSException {
	  this.name = watershedName;
		this.allocationDate = allocationDate;

	  validated = false;
	  validate();
	}

	public void validate() throws HydricDSSException {
	    	if (!validated) {
	    		validateName();
          validateAllocationDate();
	    		validated = true;
    		}
	}

	private void validateName() throws HydricDSSException {
		if ((this.name.length()>50)||(this.name.length()<1))
		{
			throw (new HydricDSSException ("The input file has no data or does not match the expected format"));
		}
	}

	private void validateAllocationDate() throws HydricDSSException {
		if (!isValidDateFormat("dd/mm/yyyy", this.allocationDate)) {
			throw (new HydricDSSException ("The input file has no data or does not match the expected format"));
		}

	    Date current = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
	    Date date;
		try {
			date = sdf.parse(this.allocationDate);
		} catch (ParseException e) {
			throw (new HydricDSSException("The input file has no data or does not match the expected format"));
		}
	
	    if (date.before(current)) {
	    	throw (new HydricDSSException("The input file has no data or does not match the expected format"));
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
