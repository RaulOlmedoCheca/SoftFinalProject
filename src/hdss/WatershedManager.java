package hdss;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import hdss.data.DemandInternalData;
import hdss.data.ResourcesFlowInternalData;
import hdss.data.WatershedInternalData;
import hdss.exceptions.HydricDSSException;
import hdss.input.data.*;
import hdss.logic.CalculatorAmount;
import hdss.logic.ScenarioSimulator;
import hdss.output.*;
import hdss.storage.WatershedDataStore;
import hdss.storage.WatershedJSONDataStore;
import hdss.storage.WatershedStorageManager;
import hdss.input.*;

public class WatershedManager implements WatershedManagerInterface {

    @Override
    //Esfuerzo Actual: 41 minutos
    public WatershedsListPublicData RegisterHydricResources(String InputFile)
            throws HydricDSSException {
        IInputFileManager ioManager = new WatershedsInputFileManager();
        Object watershedData = ioManager.Parse(InputFile);
        WatershedStorageManager dataStoreManager = new WatershedStorageManager();
        WatershedInternalData[] dataStored = dataStoreManager.InsertWatershed((WatershedInputData) watershedData);
        WatershedsListPublicData myResult = new WatershedsListPublicData(dataStored);
        return myResult;
    }

    @Override
    //Esfuerzo Actual: 52 minutos
    public ScenarioPublicData IdentifyCurrentState(String InputFile,
                                                   String Scope) throws HydricDSSException {
        ScenarioSimulator myScenarioSimulator = new ScenarioSimulator(Scope);
        IInputFileManager ioManager = new ScenarioInputFileDataManager();
        Object currentStateData = ioManager.Parse(InputFile);
        WatershedStorageManager dataStoreManager = new WatershedStorageManager();
        WatershedInternalData upgradeResult = dataStoreManager.UpgradeCurrentState((ScenarioInputData) currentStateData);
        String scenarioEvaluation = myScenarioSimulator.Evaluate((WatershedInternalData) upgradeResult);
        Date CurrentDate = new Date();
        ScenarioPublicData myResult = new ScenarioPublicData(upgradeResult.getName(), CurrentDate, Scope, scenarioEvaluation);
        return myResult;
    }

    @Override
    //Esfuerzo Actual: 48 minutos
    public IrrigationDemandPublicData RegisterIrrigationDemand(String InputFile)
            throws HydricDSSException {
        IInputFileManager ioManager = new IrrigationDemandFileDataManager();
        Object demandData = ioManager.Parse(InputFile);
        WatershedStorageManager dataStoreManager = new WatershedStorageManager();
        DemandInternalData dataStored = dataStoreManager.InsertIrrigationDemand((IrrigationDemandInputData) demandData);
        IrrigationDemandPublicData myResult = new IrrigationDemandPublicData(dataStored);
        return myResult;
    }

    @Override
    public AmountAvailablePublicData CalculateWatershedAmount(String InputFile) throws HydricDSSException {
        IInputFileManager ioManager = new AmountAvailableFileDataManager();
        AmountAvailableInputData amountData = (AmountAvailableInputData) ioManager.Parse(InputFile);

        WatershedDataStore dataStoreManager = new WatershedJSONDataStore();
        dataStoreManager.loadDataStore();
        WatershedInternalData watershed = (WatershedInternalData) dataStoreManager.getWatershed(amountData.getName());

        CalculatorAmount calculator = new CalculatorAmount();
        ResourcesFlowInternalData[] resourcesData = calculator.calculate(watershed);

        Date tomorrow = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(tomorrow);
        c.add(Calendar.DATE, 1);
        tomorrow = c.getTime();

        DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
        String authorizationDate = df.format(tomorrow);

        AmountAvailablePublicData myResult = new AmountAvailablePublicData(watershed.getName(), authorizationDate, resourcesData);
        return myResult;
    }

    @Override
    public RequestersProvidedListPublicData AllocateWaterAmount (String InputFile) throws HydricDSSException {
        IInputFileManager ioManager = new AllocationNeededFileDataManager();
        AllocationNeededInputData amountData = (AllocationNeededInputData) ioManager.Parse(InputFile);
        
        RequestersProvidedListPublicData myResult = null;
        return myResult;
    }


}
