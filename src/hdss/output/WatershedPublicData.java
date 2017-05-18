package hdss.output;

import java.util.*;

import hdss.data.AquiferInternalData;
import hdss.data.PlantInternalData;
import hdss.data.ReservoirInternalData;
import hdss.data.WatershedInternalData;

public class WatershedPublicData {
    private String name;
    private List<ReservoirPublicData> reservoirList;
    private List<AquiferPublicData> aquiferList;
    private List<DesalinationPlantPublicData> desalinationPlantList;
    private double maxCapacity;

    // Esfuerzo : 4 minutos
    public WatershedPublicData(WatershedInternalData newWatershed) {
        this.name = newWatershed.getName();

        maxCapacity += this.createReservoirs(newWatershed.getReservoirs());
        maxCapacity += this.createPlants(newWatershed.getPlants());
        this.createAquifers(newWatershed.getAquifers());
    }

    // Esfuerzo : 9 minutos
    private double createReservoirs(ReservoirInternalData[] newReservoirs) {
        double reservoirsMaxCapacity = 0.0f;
        for (int i = 0; i < newReservoirs.length; i++) {
            this.reservoirList.add(new ReservoirPublicData(newReservoirs[i].getName(), newReservoirs[i].getMaxCapacity()));
            reservoirsMaxCapacity += newReservoirs[i].getMaxCapacity();
        }
        return reservoirsMaxCapacity;
    }

    // Esfuerzo : 7 minutos
    private double createPlants(PlantInternalData[] newPlants) {
        double plantsMaxCapacity = 0.0f;
        for (int i = 0; i < newPlants.length; i++) {
            this.desalinationPlantList.add(new DesalinationPlantPublicData(newPlants[i].getName(), newPlants[i].getMaxCapacity()));
            plantsMaxCapacity += newPlants[i].getMaxCapacity();
        }
        return plantsMaxCapacity;
    }

    // Esfuerzo : 3 minutos
    private void createAquifers(AquiferInternalData[] newAquifers) {
        for (int i = 0; i < newAquifers.length; i++) {
            this.aquiferList.add(new AquiferPublicData(newAquifers[i].getName()));
        }
    }

    // Esfuerzo : 1 minuto
    public WatershedPublicData() {
        name = "";
        reservoirList = null;
        aquiferList = null;
        desalinationPlantList = null;
        maxCapacity = 0.0f;
    }

    public String getName() {
        return name;
    }

    public List<ReservoirPublicData> getReservoirList() {
        return reservoirList;
    }

    public List<AquiferPublicData> getAquiferList() {
        return aquiferList;
    }

    public List<DesalinationPlantPublicData> getDesalinationPlantList() {
        return desalinationPlantList;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }


}
