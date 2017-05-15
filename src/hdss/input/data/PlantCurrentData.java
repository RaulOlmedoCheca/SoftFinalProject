package hdss.input.data;

import hdss.exceptions.HydricDSSException;

public class PlantCurrentData {
	private String name;
	private double currentCapacity;
	private Boolean validated;

	public String getName()
	{
		return name;
	}
	
	public double getCurrentCapacity() {
		return currentCapacity;
	}
	
	//Esfuerzo Actual: 5 minutos
	public void Validate () throws HydricDSSException
	{
    	if (!validated)
    	{
    		validateName();
    		vallidateCurrentCapacity();
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

	//Esfuerzo Actual: 3 minutos
	private void vallidateCurrentCapacity() throws HydricDSSException {
		if (currentCapacity<0.0f)
		{
			throw (new HydricDSSException ("La capacidad actual de la planta es un valor incorrecto"));
		}
	}

}
