package hdss.storage;

import hdss.exceptions.HydricDSSException;

public interface DemandDataStore {
	public void InsertDemand (Object objectToInsert) throws HydricDSSException;
}
