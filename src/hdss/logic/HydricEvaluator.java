package hdss.logic;

import hdss.exceptions.HydricDSSException;

public interface HydricEvaluator {
    public String Evaluate(Object[] obj) throws HydricDSSException;
}