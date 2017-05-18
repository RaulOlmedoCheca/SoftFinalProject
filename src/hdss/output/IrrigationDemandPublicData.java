package hdss.output;

import hdss.data.DemandInternalData;

import java.util.List;

public class IrrigationDemandPublicData {

    private String watershedName;
    private List<DailyIrrigationSchedulePublicData> schedule;

    // Esfuerzo : 2 minutos
    public IrrigationDemandPublicData(DemandInternalData dataStored) {
        watershedName = dataStored.getName();
        schedule = null;
    }

    public String getWatershedName() {
        return watershedName;
    }

    public List<DailyIrrigationSchedulePublicData> getSchedule() {
        return schedule;
    }
}
