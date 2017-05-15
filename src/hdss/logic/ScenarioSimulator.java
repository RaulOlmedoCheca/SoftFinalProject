package hdss.logic;

import hdss.data.WatershedInternalData;
import hdss.exceptions.HydricDSSException;

public class ScenarioSimulator {
	private String scope;
	
	// Esfuerzo : 6 minutos
	public ScenarioSimulator (String inputScope) throws HydricDSSException
	{
		if (Validate(inputScope.toLowerCase()))
		{
			this.scope = inputScope.toLowerCase();
		}
		else
		{
			throw (new HydricDSSException ("El alcance de la evaluaci—n del escenario es incorrecto"));
		}
	}
	
	// Esfuerzo : 7 minutos
	private boolean Validate (String inputScope)
	{
		boolean valid = false;
		if ((inputScope.equals("reservoir")) || (inputScope.equals("plant")) || (inputScope.equals("aquifer")) || (inputScope.equals("all")))
		{
			valid = true;
		}
		return valid;
	}
	
	// Esfuerzo : 13 minutos
	public String Evaluate(WatershedInternalData currentStateData) throws HydricDSSException
	{
		HydricEvaluator myEvaluator;
		String result;
				
		if (this.scope.equals("reservoir"))
		{
			myEvaluator = new ReservoirEvaluator ();
			result = myEvaluator.Evaluate(currentStateData.getReservoirs());			
		}
		else if (this.scope.equals("plant"))
		{
			myEvaluator = new PlantEvaluator ();
			result = myEvaluator.Evaluate(currentStateData.getPlants());		}
		else if (this.scope.equals("aquifer"))
		{
			myEvaluator = new AquiferEvaluator ();
			result = myEvaluator.Evaluate(currentStateData.getAquifers());
		}	
		else
		{
			FullEvaluator myFullEvaluator = new FullEvaluator ();
			result = myFullEvaluator.Evaluate(currentStateData);			
		}		
		return result;
	}
}
