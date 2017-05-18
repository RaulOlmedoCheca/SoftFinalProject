package hdss.input;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import hdss.exceptions.HydricDSSException;
import hdss.input.data.ScenarioInputData;

public class ScenarioInputFileDataManager implements IInputFileManager {

    @Override
    //Esfuerzo Actual: 34 minutos
    public Object Parse(String inputFilePath) throws HydricDSSException {
        try {
            JsonReader reader = new JsonReader(new FileReader(inputFilePath));
            Gson gson = new Gson();
            ScenarioInputData item = gson.fromJson(reader, ScenarioInputData.class);
            item.Validate();
            return item;
        } catch (Exception ex) {
            throw (new HydricDSSException(ex.getMessage()));
        }
    }

}
