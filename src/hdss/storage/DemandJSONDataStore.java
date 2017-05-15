package hdss.storage;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import hdss.data.DemandInternalData;
import hdss.data.WatershedInternalData;
import hdss.exceptions.HydricDSSException;
import hdss.input.data.IrrigationDemandInputData;

public class DemandJSONDataStore implements DemandDataStore {

	private String DEMAND_DATASTORE_PATH = System.getProperty("user.dir") + "/Demand.json";
	private List<DemandInternalData> WatershedsDemandList;
	
	@Override
	public void InsertDemand (Object objectToInsert) throws HydricDSSException
	{
		IrrigationDemandInputData newRequest = (IrrigationDemandInputData)objectToInsert;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ArrayList<DemandInternalData> objects = new ArrayList<DemandInternalData>();

		DemandInternalData newItem = new DemandInternalData (newRequest);
		objects.add(newItem);

		String json = gson.toJson(objects);

		File file = new File(DEMAND_DATASTORE_PATH);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.append(json);
			fileWriter.close();
			this.WatershedsDemandList.add(newItem);
		} catch (IOException ex) {
			throw (new HydricDSSException("Demand Data Store cannot insert a new item " + ex.getMessage()));
		}
	}
	
	private DemandInternalData[] loadDataStore () throws HydricDSSException
	{
		try
		{
			JsonReader reader = new JsonReader(new FileReader(DEMAND_DATASTORE_PATH));
			Gson gson = new Gson();

			DemandInternalData [] myArray = gson.fromJson(reader, WatershedInternalData[].class);
			return myArray;
		}
		catch (Exception ex)
		{
			throw (new HydricDSSException(ex.getMessage()));
		}

	}
	
}
