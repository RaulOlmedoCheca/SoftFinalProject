package hdss.input;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import hdss.exceptions.HydricDSSException;
import hdss.input.data.IrrigationDemandInputData;

public class IrrigationDemandFileDataManager implements IInputFileManager {

	@Override
	//Esfuerzo Actual: 27 minutos
	public Object Parse(String inputFilePath) throws HydricDSSException 
	{
		try
		{
			JsonReader reader = new JsonReader(new FileReader(inputFilePath));
			Gson gson = new Gson();
			IrrigationDemandInputData item = gson.fromJson(reader, IrrigationDemandInputData.class);
			item.Validate();			
			return item;
		}
		catch (Exception ex)
		{
			throw (new HydricDSSException(ex.getMessage()));
		}
	}

}
