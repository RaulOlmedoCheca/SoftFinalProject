package hdss.input;

import hdss.exceptions.*;

public interface IInputFileManager {

    public Object Parse(String inputFilePath) throws HydricDSSException;

}