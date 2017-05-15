package hdss.input;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import hdss.exceptions.HydricDSSException;
import hdss.input.data.WatershedInputData;

public class WatershedsInputFileManager implements IInputFileManager {

	@Override
	//Esfuerzo Actual: 38 minutos
	public Object Parse(String inputFilePath) throws HydricDSSException 
	{
		try
		{
			JsonReader reader = new JsonReader(new FileReader(inputFilePath));
			Gson gson = new Gson();
			WatershedInputData item = gson.fromJson(reader, WatershedInputData.class);
			item.Validate();			
			return item;
		}
		catch (Exception ex)
		{
			throw (new HydricDSSException(ex.getMessage()));
		}
	}

}
