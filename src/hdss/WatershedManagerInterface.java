package hdss;

import hdss.exceptions.*;
import hdss.output.*;

public interface WatershedManagerInterface {
    public WatershedsListPublicData RegisterHydricResources(String InputFile) throws HydricDSSException;
    // WatershedsListPublicData represents HDSS-RF-01-S1
    // String InputFile represents HDSS-RF-01-E1
    // HydricDSSException represents HDSS-RF-01-S2

    public ScenarioPublicData IdentifyCurrentState(String InputFile, String Scope) throws HydricDSSException;
    // ScenarioPublicData represents HDSS-RF-02-S1
    // String InputFile represents HDSS-RF-02-E1
    // String Scope represents HDSS-RF-02-E2
    // HydricDSSException represents HDSS-RF-02-S2

    public IrrigationDemandPublicData RegisterIrrigationDemand(String InputFile) throws HydricDSSException;
    // IrrigationDemandPublicData represents HDSS-RF-03-S1
    // String InputFile represents HDSS-RF-03-E1
    // HydricDSSException represents HDSS-RF-03-S2

    public AmountAvailablePublicData CalculateWatershedAmount(String InputFile) throws HydricDSSException;
    // AmountAvailablePublicData represents HDSS-FR-01-O1
    // String InputFile represents HDSS-FR-01-I1
    // HydricDSSException represents HDSS-FR-01-O2

    //public RequestersProvidedListPublicData AllocateWaterAmount (String InputFile) throws HydricDSSException;
    // AllocationRequestsPublicDate represents HDSS-FR-02-O1
    // String InputFile represents HDSS-FR-02-I1
    // HydricDSSException represents HDSS-FR-02-O2
}
