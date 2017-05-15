package hdss.storage;

import hdss.exceptions.HydricDSSException;

public interface WatershedDataStore {
	public void loadDataStore () throws HydricDSSException;
	public Object getWatershed (Object watershedName);
	public Object[] InsertWatershed (Object objectToInsert) throws HydricDSSException;
	public Object Upgrade (Object objectToUpgrade) throws HydricDSSException;
}
