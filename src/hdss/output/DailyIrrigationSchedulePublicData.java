package hdss.output;

import java.util.List;

public class DailyIrrigationSchedulePublicData {

	private String myDay;
	private List<HourlyIrrigationSchedulePublicData> schedule;

	// Esfuerzo : 2 minutos
	public DailyIrrigationSchedulePublicData (String day)
	{
		myDay = day;
		schedule = null;
	}

	public String getMyDay() {
		return myDay;
	}

	public List<HourlyIrrigationSchedulePublicData> getSchedule() {
		return schedule;
	}
	
}
