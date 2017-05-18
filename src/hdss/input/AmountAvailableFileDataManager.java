package hdss.input;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import hdss.exceptions.HydricDSSException;
import hdss.input.data.AmountAvailableInputData;

public class AmountAvailableFileDataManager implements IInputFileManager {

	@Override
	public AmountAvailableInputData Parse(String inputFilePath) throws HydricDSSException 
	{
		try
		{
			JsonReader reader = new JsonReader(new FileReader(inputFilePath));
			Gson gson = new Gson();
			AmountAvailableInputData item = gson.fromJson(reader, AmountAvailableInputData.class);
			item.validate();			
			return item;
		}
		catch (Exception ex)
		{
			throw (new HydricDSSException("No input files"));
		}
	}

}
