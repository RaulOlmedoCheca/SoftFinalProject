package hdss.data;

import hdss.exceptions.HydricDSSException;
import hdss.input.data.AquiferCurrentData;
import hdss.input.data.AquiferInputData;
import hdss.input.data.PlantCurrentData;
import hdss.input.data.PlantInputData;
import hdss.input.data.ReservoirCurrentData;
import hdss.input.data.ReservoirInputData;
import hdss.input.data.ScenarioInputData;
import hdss.input.data.WatershedInputData;


public class WatershedInternalData {

    private String name;
    private ReservoirInternalData[] reservoirs;
    private PlantInternalData[] plants;
    private AquiferInternalData[] aquifers;

    public WatershedInternalData() {
        this.name = "";
        this.reservoirs = null;
        this.plants = null;
        this.aquifers = null;
    }

    // Esfuerzo : 5 minutos
    public WatershedInternalData(Object objectToInsert) {
        WatershedInputData newObject = (WatershedInputData) objectToInsert;

        this.name = newObject.getName();
        this.createReservoirs(newObject.getReservoirsInputData());
        this.createPlants(newObject.getPlantsInputData());
        this.createAquifers(newObject.getAquifersInputData());
    }

    // Esfuerzo : 8 minutos
    private void createReservoirs(ReservoirInputData[] newReservoirs) {
        this.reservoirs = new ReservoirInternalData[newReservoirs.length];
        for (int i = 0; i < newReservoirs.length; i++) {
            this.reservoirs[i] = new ReservoirInternalData(newReservoirs[i].getName(), newReservoirs[i].getMaxCapacity());
        }
    }

    // Esfuerzo : 6 minutos
    private void createPlants(PlantInputData[] newPlants) {
        this.plants = new PlantInternalData[newPlants.length];
        for (int i = 0; i < newPlants.length; i++) {
            this.plants[i] = new PlantInternalData(newPlants[i].getName(), newPlants[i].getMaxCapacity());
        }
    }

    // Esfuerzo : 6 minutos
    private void createAquifers(AquiferInputData[] newAquifers) {
        this.aquifers = new AquiferInternalData[newAquifers.length];
        for (int i = 0; i < newAquifers.length; i++) {
            this.aquifers[i] = new AquiferInternalData(newAquifers[i].getName());
        }
    }

    public String getName() {
        return name;
    }

    public ReservoirInternalData[] getReservoirs() {
        return reservoirs;
    }

    public PlantInternalData[] getPlants() {
        return plants;
    }

    public AquiferInternalData[] getAquifers() {
        return aquifers;
    }

    // Esfuerzo : 5 minutos
    public void UpdateResources(ScenarioInputData currentState) throws HydricDSSException {
        this.UpdateReservoirs(currentState.getReservoirsCurrentData());
        this.updatePlants(currentState.getPlantsCurrentData());
        this.updateAquifers(currentState.getAquifersCurrentData());
    }

    // Esfuerzo : 14 minutos
    private void UpdateReservoirs(ReservoirCurrentData[] reservoirsList) throws HydricDSSException {
        for (int i = 0; i < reservoirsList.length; i++) {
            this.getReservoirs()[this.searchReservoir(reservoirsList[i].getName())].setCurrentCapacity(reservoirsList[i].getCurrentCapacity());
        }
    }

    // Esfuerzo : 7 minutos
    private void updatePlants(PlantCurrentData[] plantsList) throws HydricDSSException {
        for (int i = 0; i < plantsList.length; i++) {
            this.plants[this.searchPlant(plantsList[i].getName())].setCurrentCapacity(plantsList[i].getCurrentCapacity());
        }
    }

    // Esfuerzo : 7 minutos
    private void updateAquifers(AquiferCurrentData[] aquifersList) throws HydricDSSException {
        for (int i = 0; i < aquifersList.length; i++) {
            this.aquifers[this.searchAquifer(aquifersList[i].getName())].setCurrentLevel(aquifersList[i].getCurrentLevel());
        }
    }

    // Esfuerzo : 17 minutos
    private int searchReservoir(String resourceName) throws HydricDSSException {
        Boolean found = false;
        int index = 0;

        while ((!found) && (index < this.getReservoirs().length)) {
            if (resourceName.equals(this.getReservoirs()[index].getName())) {
                found = true;
            }
            index++;
        }
        if (!found) {
            throw (new HydricDSSException(resourceName + "is not a resource of" + this.getName()));
        }
        return index;
    }

    // Esfuerzo : 6 minutos
    private int searchPlant(String resourceName) throws HydricDSSException {
        Boolean found = false;
        int index = 0;

        while ((!found) && (index < this.plants.length)) {
            if (resourceName.equals(this.plants[index].getName())) {
                found = true;
            }
            index++;
        }
        if (!found) {
            throw (new HydricDSSException(resourceName + "is not a resource of" + this.getName()));
        }
        return index;
    }

    // Esfuerzo : 6 minutos
    private int searchAquifer(String resourceName) throws HydricDSSException {
        Boolean found = false;
        int index = 0;

        while ((!found) && (index < this.aquifers.length)) {
            if (resourceName.equals(this.aquifers[index].getName())) {
                found = true;
            }
            index++;
        }
        if (!found) {
            throw (new HydricDSSException(resourceName + "is not a resource of" + this.getName()));
        }
        return index;
    }
}
