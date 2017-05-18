package hdss.storage;

import hdss.data.WatershedInternalData;
import hdss.exceptions.HydricDSSException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

public class WatershedJSONDataStore implements WatershedDataStore {
	private String WATERSHED_DATASTORE_PATH = System.getProperty("user.dir") + "/WatershedDataStore.json";
	private List<WatershedInternalData> WatershedsList;
	
	// Esfurzo: 23 minutos
	public void loadDataStore () throws HydricDSSException
	{
		try
		{
			JsonReader reader = new JsonReader(new FileReader(WATERSHED_DATASTORE_PATH));
			Gson gson = new Gson();

			WatershedInternalData [] myArray = gson.fromJson(reader, WatershedInternalData[].class);
			this.WatershedsList = Arrays.asList(myArray); 			
		}
		catch (Exception ex)
		{
			throw (new HydricDSSException(ex.getMessage()));
		}

	}

	// Esfurzo: 29 minutos
	public WatershedInternalData getWatershed (Object SearchCriteria)
	{
		String watershedName = (String)SearchCriteria;
		Boolean found = false; 
		int index = 0;
		WatershedInternalData result = null;
		
		while ((found==false) && (index<this.WatershedsList.size()))
		{
			if (watershedName == this.WatershedsList.get(index).getName())
			{
				found = true;
				result = this.WatershedsList.get(index);
			}
			else
			{
				index++;
			}
		}
		return result;
	}

	// Esfurzo: 25 minutos
	public Object[] InsertWatershed (Object objectToInsert) throws HydricDSSException
	{

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ArrayList<WatershedInternalData> objects = new ArrayList<WatershedInternalData>();

		WatershedInternalData newItem = new WatershedInternalData (objectToInsert);
		objects.add(newItem);

		String json = gson.toJson(objects);

		File file = new File(WATERSHED_DATASTORE_PATH);
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file, true);
			fileWriter.append(json);
			fileWriter.close();
			this.WatershedsList.add(newItem);
		} catch (IOException ex) {
			throw (new HydricDSSException("Watershed Data Store cannot insert a new item " + ex.getMessage()));
		}
		
		WatershedInternalData[] items = (WatershedInternalData[]) this.getRepositoryObjects();
		
		return items;
	}

	// Esfurzo: 19 minutos
	private Object getRepositoryObjects () throws HydricDSSException 
	{
		try
		{
			JsonReader reader = new JsonReader(new FileReader(WATERSHED_DATASTORE_PATH));
			Gson gson = new Gson();
			WatershedInternalData[] items = gson.fromJson(reader, WatershedInternalData[].class);
			return items;
		}
		catch (Exception ex)
		{
			throw (new HydricDSSException(ex.getMessage()));
		}
	}
	
	@Override
	public Object Upgrade(Object objectToUpgrade) throws HydricDSSException {
		return null;
	}

}
