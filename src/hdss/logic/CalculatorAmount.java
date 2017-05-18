package hdss.logic;

import hdss.exceptions.HydricDSSException;
import hdss.data.WatershedInternalData;
import hdss.data.AquiferInternalData;
import hdss.data.PlantInternalData;
import hdss.data.ReservoirInternalData;
import hdss.data.ResourcesFlowInternalData;

public class CalculatorAmount {

    public ResourcesFlowInternalData[] calculate(WatershedInternalData watershed) throws HydricDSSException {

        ScenarioSimulator reservoirsEval = new ScenarioSimulator("reservoir");
        ScenarioSimulator plantsEval = new ScenarioSimulator("plant");
        ScenarioSimulator aquifersEval = new ScenarioSimulator("aquifer");

        String stateReservoirs = reservoirsEval.Evaluate(watershed);
        String statePlants = plantsEval.Evaluate(watershed);
        String stateAquifers = aquifersEval.Evaluate(watershed);

        ResourcesFlowInternalData[] resources = null;

        for (int i = 0; i < watershed.getReservoirs().length; i++) {
            ReservoirInternalData reservoir = watershed.getReservoirs()[i];
            double currentCapacity = reservoir.getCurrentCapacity();
            double maxToProvide = 0;
            double flowPerMinute = 0;
            int timeNeeded = 0;

            if (currentCapacity > 0) {
                switch (stateReservoirs) {
                    case "PLENTY":
                        maxToProvide = currentCapacity * 0.01;
                        flowPerMinute = 3;
                        timeNeeded = (int) Math.ceil(maxToProvide / flowPerMinute);

                        resources[i] = new ResourcesFlowInternalData(reservoir.getName(), flowPerMinute, maxToProvide, timeNeeded);
                        break;
                    case "NORMALITY":
                        maxToProvide = currentCapacity * 0.007;
                        flowPerMinute = 2;
                        timeNeeded = (int) Math.ceil(maxToProvide / flowPerMinute);

                        resources[i] = new ResourcesFlowInternalData(reservoir.getName(), flowPerMinute, maxToProvide, timeNeeded);
                        break;
                    case "SHORTAGE":
                        maxToProvide = currentCapacity * 0.005;
                        flowPerMinute = 1;
                        timeNeeded = (int) Math.ceil(maxToProvide / flowPerMinute);

                        resources[i] = new ResourcesFlowInternalData(reservoir.getName(), flowPerMinute, maxToProvide, timeNeeded);

                        break;
                    default:
                        throw (new HydricDSSException("Error evaluating reservoirs"));
                }
            }
        }

        for (int i = 0; i < watershed.getPlants().length; i++) {
            PlantInternalData plant = watershed.getPlants()[i];
            double currentCapacity = plant.getCurrentCapacity();
            double maxCapacity = plant.getMaxCapacity();
            double maxToProvide = 0;
            double flowPerMinute = 0;
            int timeNeeded = 0;

            if (currentCapacity > 0) {
                switch (statePlants) {
                    case "PLENTY":
                        maxToProvide = currentCapacity;
                        flowPerMinute = 2.3;
                        timeNeeded = (int) Math.ceil(maxToProvide / flowPerMinute);

                        resources[i] = new ResourcesFlowInternalData(plant.getName(), flowPerMinute, maxToProvide, timeNeeded);
                        break;
                    case "NORMALITY":
                        double avail = maxCapacity * 0.1;
                        maxToProvide = Math.min(avail, currentCapacity);
                        flowPerMinute = 1;
                        timeNeeded = (int) Math.ceil(maxToProvide / flowPerMinute);

                        resources[i] = new ResourcesFlowInternalData(plant.getName(), flowPerMinute, maxToProvide, timeNeeded);
                        break;
                    case "SHORTAGE":
                        double avail2 = maxCapacity * 0.15;
                        maxToProvide = Math.min(avail2, currentCapacity);
                        flowPerMinute = 0.5;
                        timeNeeded = (int) Math.ceil(maxToProvide / flowPerMinute);

                        resources[i] = new ResourcesFlowInternalData(plant.getName(), flowPerMinute, maxToProvide, timeNeeded);
                        break;
                    default:
                        throw (new HydricDSSException("Error evaluating plants"));
                }
            }
        }

        if (resources.length == 0) {
            for (int i = 0; i < watershed.getAquifers().length; i++) {
                AquiferInternalData aquifer = watershed.getAquifers()[i];
                double currentLevel = aquifer.getCurrentLevel();
                double maxToProvide = 0;
                double flowPerMinute = 0;
                int timeNeeded = 0;

                if (currentLevel > 0) {
                    switch (stateAquifers) {
                        case "PLENTY":
                            flowPerMinute = 2;
                            timeNeeded = 120;
                            maxToProvide = flowPerMinute * timeNeeded;

                            resources[i] = new ResourcesFlowInternalData(aquifer.getName(), flowPerMinute, maxToProvide, timeNeeded);
                            break;
                        case "NORMALITY":
                            flowPerMinute = 1.5;
                            timeNeeded = 90;
                            maxToProvide = flowPerMinute * timeNeeded;

                            resources[i] = new ResourcesFlowInternalData(aquifer.getName(), flowPerMinute, maxToProvide, timeNeeded);
                            break;
                        case "SHORTAGE":
                            flowPerMinute = 1;
                            timeNeeded = 60;
                            maxToProvide = flowPerMinute * timeNeeded;

                            resources[i] = new ResourcesFlowInternalData(aquifer.getName(), flowPerMinute, maxToProvide, timeNeeded);
                            break;
                        default:
                            throw (new HydricDSSException("Error evaluating aquifers"));
                    }
                }
            }
        }

        return resources;
    }
}