package hdss.input.data;

import hdss.exceptions.HydricDSSException;

public class WatershedInputData {

	private String name;
	private ReservoirInputData [] reservoirs;
	private PlantInputData [] plants;
	private AquiferInputData [] aquifers;
	
	private Boolean validated;
	
	public String getName() {
		return name;
	}

	public ReservoirInputData [] getReservoirsInputData ()
	{
		return reservoirs;
	}
	
	public PlantInputData[] getPlantsInputData ()
	{
		return plants;
	}

	public AquiferInputData [] getAquifersInputData ()
	{
		return aquifers;
	}
	
	//Esfuerzo Actual: 2 minutos
    public WatershedInputData (String watershedName) throws HydricDSSException
	{
    	name = watershedName;
    	validated = false;
    	Validate();
	}

	//Esfuerzo Actual: 5 minutos
	public void Validate () throws HydricDSSException
	{
    	if (!validated)
    	{
    		validateName();
    		validateReservoirs();
    		validatePlants();
    		validateAquifers();
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

	//Esfuerzo Actual: 4 minutos
	private void validateReservoirs() throws HydricDSSException
	{
		for (int i=0; i<this.reservoirs.length; i++)
		{
			this.reservoirs[i].Validate();
			if (validateRepeatedName(this.reservoirs[i].getName()))
			{
				throw (new HydricDSSException ("Nombre de recurso duplicado"));
			}
		}	
	}

	//Esfuerzo Actual: 4 minutos
	private void validatePlants() throws HydricDSSException
	{
		for (int i=0; i<this.plants.length; i++)
		{
			this.plants[i].Validate();
			if (validateRepeatedName(this.plants[i].getName()))
			{
				throw (new HydricDSSException ("Nombre de recurso duplicado"));
			}			
		}		
	}
	
	//Esfuerzo Actual: 4 minutos
	private void validateAquifers() throws HydricDSSException
	{
		for (int i=0; i<this.aquifers.length; i++)
		{
			this.aquifers[i].Validate();
			if (validateRepeatedName(this.aquifers[i].getName()))
			{
				throw (new HydricDSSException ("Nombre de recurso duplicado"));
			}			
		}			
	}
	
	//Esfuerzo Actual: 16 minutos
	private boolean validateRepeatedName(String name)
	{
		boolean repeated = false;
		int nameCount = 0;
		
		int i = 0;
		while ((nameCount < 2) && (i<this.aquifers.length))
		{
			if (name==this.aquifers[i].getName())
			{
				nameCount++;
			}
			i++;
		}
		
		if (nameCount > 1)
		{
			repeated = true;
		}
		else
		{
			i = 0;
			while ((nameCount < 2) && (i<this.reservoirs.length))
			{
				if (name==this.reservoirs[i].getName())
				{
					nameCount++;
				}
				i++;
			}	
			if (nameCount > 1)
			{
				repeated = true;
			}
			else
			{
				while ((nameCount < 2) && (i<this.reservoirs.length))
				{
					if (name==this.reservoirs[i].getName())
					{
						nameCount++;
					}
					i++;
				}
				if (nameCount > 1)
				{
					repeated = true;
				}
			}
		}
		
		return repeated;
	}
	
}
