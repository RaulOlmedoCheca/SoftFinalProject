package hdss.logic;

import hdss.data.ReservoirInternalData;
import hdss.exceptions.HydricDSSException;

public class ReservoirEvaluator implements HydricEvaluator {

    @Override
    // Esfuerzo : 15 minutos
    public String Evaluate(Object[] obj) throws HydricDSSException {
        ReservoirInternalData[] reservoirs = (ReservoirInternalData[]) obj;
        double additionCurrentCapacity = 0.0f;
        double additionMaxCapacity = 0.0f;
        double capacityPercentage = 0.0f;
        String result = "";

        for (int i = 0; i < reservoirs.length; i++) {
            additionCurrentCapacity += reservoirs[i].getCurrentCapacity();
            additionMaxCapacity += reservoirs[i].getMaxCapacity();
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
