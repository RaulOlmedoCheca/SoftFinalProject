package hdss.input.data;

import hdss.exceptions.HydricDSSException;

public class AquiferInputData {
	private String name;
	private Boolean validated;
	
	public String getName()
	{
		return this.name;
	}
	
	//Esfuerzo Actual: 5 minutos
	public void Validate () throws HydricDSSException
	{
    	if (!validated)
    	{
    		validateName();
    		validated = true;
    	}		
	}
	
	//Esfuerzo Actual: 3 minutos
	private void validateName() throws HydricDSSException {
		if ((name.length()>50)||(name.length()<1))
		{
			throw (new HydricDSSException ("Nombre con un nœmero de caracteres mayor que 50 o menor que 1"));
		}
	}
}
