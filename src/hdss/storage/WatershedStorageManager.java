package hdss.storage;

import hdss.data.DemandInternalData;
import hdss.data.WatershedInternalData;
import hdss.exceptions.HydricDSSException;
import hdss.input.data.IrrigationDemandInputData;
import hdss.input.data.ScenarioInputData;
import hdss.input.data.WatershedInputData;

public class WatershedStorageManager {

    // Esfurzo: 96 minutos
    public WatershedInternalData[] InsertWatershed(WatershedInputData watershedInputData) throws HydricDSSException {
        WatershedInternalData[] myResult;

        WatershedDataStore myStore = new WatershedJSONDataStore();

        myStore.loadDataStore();

        if (myStore.getWatershed(watershedInputData.getName()) == null) {
            myResult = (WatershedInternalData[]) myStore.InsertWatershed(watershedInputData);
        } else {
            throw (new HydricDSSException("Watershed Name already exists in the watershed data store"));
        }
        return myResult;
    }

    public DemandInternalData InsertIrrigationDemand(IrrigationDemandInputData demandInputData) throws HydricDSSException {
        //TO DO
        return null;

    }

    // Esfurzo: 111 minutos
    public WatershedInternalData UpgradeCurrentState(ScenarioInputData currentStateData) throws HydricDSSException {
        WatershedInternalData myResult = new WatershedInternalData();

        WatershedDataStore myStore = new WatershedJSONDataStore();

        myStore.loadDataStore();

        myResult = (WatershedInternalData) myStore.getWatershed(currentStateData.getName());

        if (myResult != null) {
            myResult.UpdateResources(currentStateData);
        } else {
            throw (new HydricDSSException("Watershed Name does not exist in the watershed data store"));
        }
        return myResult;
    }
}
