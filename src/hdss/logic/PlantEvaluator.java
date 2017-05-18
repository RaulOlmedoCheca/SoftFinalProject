package hdss.logic;

import hdss.data.PlantInternalData;
import hdss.exceptions.HydricDSSException;

public class PlantEvaluator implements HydricEvaluator {

    @Override
    // Esfuerzo : 16 minutos
    public String Evaluate(Object[] obj) throws HydricDSSException {
        PlantInternalData[] plants = (PlantInternalData[]) obj;
        double additionCurrentCapacity = 0.0f;
        double additionMaxCapacity = 0.0f;
        double capacityPercentage = 0.0f;
        String result = "";

        for (int i = 0; i < plants.length; i++) {
            additionCurrentCapacity += plants[i].getCurrentCapacity();
            additionMaxCapacity += plants[i].getMaxCapacity();
        }
        if (additionMaxCapacity > 0.0f) {
            capacityPercentage = (additionCurrentCapacity / additionMaxCapacity);
        }
        if (capacityPercentage > 0.9f) {
            result = "PLENTY";
        } else if (capacityPercentage > 0.4f) {
            result = "NORMALITY";
        } else {
            result = "SHORTAGE";
        }
        return result;
    }

}
