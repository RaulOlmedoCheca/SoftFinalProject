package hdss.output;

import hdss.data.WatershedInternalData;

import java.util.*;

public class WatershedsListPublicData {

	private List<WatershedPublicData> watershedList;

	// Esfuerzo : 2 minutos
	public WatershedsListPublicData (WatershedInternalData [] watershedData)
	{
		for (int i=0; i<watershedData.length; i++)
		{
			this.watershedList.add(new WatershedPublicData(watershedData[i]));
		}
		watershedList = null;
	}
	public List<WatershedPublicData> getWatershedList() {
		return watershedList;
	}
}
