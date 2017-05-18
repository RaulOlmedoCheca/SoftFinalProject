package hdss.input.data;

import hdss.exceptions.HydricDSSException;

public class ScenarioInputData {

    private String name;
    private ReservoirCurrentData[] reservoirs;
    private PlantCurrentData[] plants;
    private AquiferCurrentData[] aquifers;
    private Boolean validated;

    public String getName() {
        return name;
    }

    public ReservoirCurrentData[] getReservoirsCurrentData() {
        return reservoirs;
    }

    public PlantCurrentData[] getPlantsCurrentData() {
        return plants;
    }

    public AquiferCurrentData[] getAquifersCurrentData() {
        return aquifers;
    }

    //Esfuerzo Actual: 2 minutos
    public ScenarioInputData(String watershedName) throws HydricDSSException {
        name = watershedName;
        validated = false;
        Validate();
    }

    //Esfuerzo Actual: 5 minutos
    public void Validate() throws HydricDSSException {
        if (!validated) {
            validateName();
            validateReservoirs();
            validatePlants();
            validateAquifers();
            validated = true;
        }
    }

    //Esfuerzo Actual: 3 minutos
    private void validateName() throws HydricDSSException {
        if ((name.length() > 50) || (name.length() < 1)) {
            throw (new HydricDSSException("Nombre con un n�mero de caracteres mayor que 50 o menor que 1"));
        }
    }

    //Esfuerzo Actual: 4 minutos
    private void validateReservoirs() throws HydricDSSException {
        for (int i = 0; i < this.reservoirs.length; i++) {
            this.reservoirs[i].Validate();
        }

    }

    //Esfuerzo Actual: 4 minutos
    private void validatePlants() throws HydricDSSException {
        for (int i = 0; i < this.plants.length; i++) {
            this.plants[i].Validate();
        }
    }

    //Esfuerzo Actual: 4 minutos
    private void validateAquifers() throws HydricDSSException {
        for (int i = 0; i < this.aquifers.length; i++) {
            this.aquifers[i].Validate();
        }
    }

}
