package hdss.logic;

import hdss.data.AquiferInternalData;
import hdss.exceptions.HydricDSSException;

public class AquiferEvaluator implements HydricEvaluator {

	// Esfuerzo : 15 minutos
	@Override
	public String Evaluate(Object[] obj) throws HydricDSSException {
		AquiferInternalData[] aquifers = (AquiferInternalData[])obj;
		double overallLevel = 0.0;
		String result = "";
		
		for (int i=0; i<aquifers.length; i++)
		{
			overallLevel += aquifers[i].getCurrentLevel();
		}
		if (overallLevel>0.0f)
		{
			result = "PLENTY";
		}
		else if (overallLevel>-8.0f)
		{
			result = "NORMALITY";
		}
		else
		{
			result = "SHORTAGE";
		}
		return result;
	}
}
