package hdss.logic;

import hdss.exceptions.HydricDSSException;
import hdss.data.WatershedInternalData;

public class CalculatorAmount {

  public String Calculate (WatershedInternalData watershed) throws HydricDSSException {
	  ScenarioSimulator reservoirs = new ScenarioSimulator("reservoir");
	  ScenarioSimulator plants = new ScenarioSimulator("plant");
	  ScenarioSimulator aquifers = new ScenarioSimulator("aquifer");
		
	  String stateReservoirs = reservoirs.Evaluate(watershed);
	  String statePlants = plants.Evaluate(watershed);
	  String stateAquifers = aquifers.Evaluate(watershed);
	  
	  
	  
	  String y = "ey";
	  return y;
  }
}