package hdss.logic;


import hdss.data.WatershedInternalData;
import hdss.exceptions.HydricDSSException;

public class FullEvaluator {

	// Esfuerzo : 25 minutos
	public String Evaluate(Object obj) throws HydricDSSException {
		WatershedInternalData currentStateData = (WatershedInternalData)obj;
		HydricEvaluator myEvaluator;
		String[] results  = new String[3];
		int numberPlenty = 0;
		int numberShortage = 0;
		int numberNormality = 0;
		String result = "";
		
		
		myEvaluator = new ReservoirEvaluator ();
		results[0] = myEvaluator.Evaluate(currentStateData.getReservoirs());

		myEvaluator = new PlantEvaluator ();
		results[1] = myEvaluator.Evaluate(currentStateData.getPlants());

		myEvaluator = new PlantEvaluator ();
		results[2] = myEvaluator.Evaluate(currentStateData.getAquifers());
		
		for (int i=0; i<results.length; i++)
		{
			if (results[i].equals("PLENTY"))
			{
				numberPlenty++;
			}
			else if (results[i].equals("NORMALITY"))
			{
				numberNormality++;
			}
			else if (results[i].equals("SHORTAGE"))
			{
				numberShortage++;
			}	
		}
		
		result = determineResult(numberPlenty, numberShortage, numberNormality);

		return result;
	}

	// Esfuerzo : 3 minutos
	private String determineResult(int numberPlenty, int numberShortage,
			int numberNormality) {
		String result;
		if (numberPlenty>1)
		{
			result = "PLENTY";
		}
		else if (numberNormality>1)
		{
			result = "NORMALITY";
		}
		else if (numberShortage>1)
		{
			result = "SHORTAGE";
		}
		else
		{
			result = "NORMALITY";
		}
		return result;
	}

}
