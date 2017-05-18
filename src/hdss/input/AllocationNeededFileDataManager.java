package hdss.input;

import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import hdss.exceptions.HydricDSSException;
import hdss.input.data.AllocationNeededInputData;

public class AllocationNeededFileDataManager implements IInputFileManager {

    @Override
    public Object Parse(String inputFilePath) throws HydricDSSException {
        try {
            JsonReader reader = new JsonReader(new FileReader(inputFilePath));
            Gson gson = new Gson();
            AllocationNeededInputData item = gson.fromJson(reader, AllocationNeededInputData.class);
            item.validate();
            return item;
        } catch (Exception ex) {
            throw (new HydricDSSException(ex.getMessage()));
        }
    }

}
