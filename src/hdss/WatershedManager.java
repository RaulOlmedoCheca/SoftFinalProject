package hdss;

import java.util.Date;

import hdss.data.DemandInternalData;
import hdss.data.WatershedInternalData;
import hdss.exceptions.HydricDSSException;
import hdss.logic.ScenarioSimulator;
import hdss.output.IrrigationDemandPublicData;
import hdss.output.ScenarioPublicData;
import hdss.output.WatershedsListPublicData;
import hdss.output.AmountAvailablePublicData;
import hdss.storage.WatershedStorageManager;
import hdss.input.*;
import hdss.input.data.IrrigationDemandInputData;
import hdss.input.data.ScenarioInputData;
import hdss.input.data.WatershedInputData;

public class WatershedManager implements WatershedManagerInterface {

	@Override
	//Esfuerzo Actual: 41 minutos
	public WatershedsListPublicData RegisterHydricResources(String InputFile)
			throws HydricDSSException {
		IInputFileManager ioManager = new WatershedsInputFileManager ();
		Object watershedData = ioManager.Parse(InputFile);
		WatershedStorageManager dataStoreManager = new WatershedStorageManager ();
		WatershedInternalData[] dataStored = dataStoreManager.InsertWatershed((WatershedInputData) watershedData) ;
		WatershedsListPublicData myResult = new WatershedsListPublicData (dataStored);
		return myResult;
	}

	@Override
	//Esfuerzo Actual: 52 minutos
	public ScenarioPublicData IdentifyCurrentState(String InputFile,
			String Scope) throws HydricDSSException {
		ScenarioSimulator myScenarioSimulator = new ScenarioSimulator (Scope);
		IInputFileManager ioManager = new ScenarioInputFileDataManager ();
		Object currentStateData = ioManager.Parse(InputFile);
		WatershedStorageManager dataStoreManager = new WatershedStorageManager ();
		WatershedInternalData upgradeResult = dataStoreManager.UpgradeCurrentState((ScenarioInputData) currentStateData);
		String scenarioEvaluation = myScenarioSimulator.Evaluate((WatershedInternalData) upgradeResult);
		Date CurrentDate = new Date();
		ScenarioPublicData myResult = new ScenarioPublicData (upgradeResult.getName(), CurrentDate, Scope, scenarioEvaluation);
		return myResult;
	}

	@Override
	//Esfuerzo Actual: 48 minutos
	public IrrigationDemandPublicData RegisterIrrigationDemand(String InputFile)
			throws HydricDSSException {
		IInputFileManager ioManager = new IrrigationDemandFileDataManager ();
		Object demandData = ioManager.Parse(InputFile);
		WatershedStorageManager dataStoreManager = new WatershedStorageManager ();
		DemandInternalData dataStored = dataStoreManager.InsertIrrigationDemand((IrrigationDemandInputData) demandData) ;
		IrrigationDemandPublicData myResult =  new IrrigationDemandPublicData (dataStored);
		return myResult;
	}

	@Override
	public AmountAvailablePublicData CalculateWatershedAmount (String InputFile) throws HydricDSSException {
		IInputFileManager ioManager = new AmountAvailableFileDataManager();
		Object amountData = ioManager.Parse(InputFile);
		WatershedStorageManager dataStoreManager = new WatershedStorageManager();

		// TODO
		AmountAvailablePublicData myResult = new AmountAvailablePublicData();
		return myResult;
	}

	@Override
	public AllocationRequestsPublicData AllocateWaterAmount (String InputFile, double totalAvailable) throws HydricDSSException {
		// TODO
		AllocationRequestsPublicData myResult = new AllocationRequestsPublicData();

		return myResult;
	}


}
