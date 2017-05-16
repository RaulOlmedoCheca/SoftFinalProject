package hdss.tests;

import static org.junit.Assert.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import hdss.WatershedManagerInterface;
import hdss.WatershedManager;
import hdss.exceptions.HydricDSSException;

public class TestEquivalenceBoundaryFR01 {

  private WatershedManagerInterface manager = new WatershedManager();


  // PLANTILLA TEST BASICO
  
  /* Test Case:
  * Equivalence Class, Boundary Limit or Node in the Derivation Tree:
  * Testing Technique:
  * Expected Result:
  */
  @Test
  public void testName() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("file.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "MENSAJE DE ERROR")
    }
  }
}
