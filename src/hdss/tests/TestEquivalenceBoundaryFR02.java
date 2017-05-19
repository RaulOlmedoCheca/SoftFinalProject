package hdss.tests;

import hdss.WatershedManagerInterface;
import hdss.WatershedManager;
import hdss.exceptions.HydricDSSException;

import org.junit.Test;

import static org.junit.Assert.*;

public class TestEquivalenceBoundaryFR02 {

    private WatershedManagerInterface manager = new WatershedManager();

//PLANTILLA
  /* Test Case:
  * Equivalence Class, Boundary Limit or Node in the Derivation Tree:
  * Testing Technique:
  * Expected Result:
  *
  @Test
  public void testName() throws HydricDSSException {
    try {
      manager.AllocateWaterAmount("file.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "MENSAJE DE ERROR")
    }
  }
  */

    /* Test Case: HDSS-FR02-TC-1
  * Equivalence Class: HDSS-FN2-EQ-2, HDSS-FN2-EQ-5, HDSS-FN2-EQ-6, HDSS-FN2-EQ-7,
  * HDSS-FN2-EQ-12, HDSS-FN2-EQ-13, HDSS-FN2-EQ-14
  * Testing Technique: Equivalence class
  * Expected Result:
  */
    @Test
    public void basicValidTest() {
        //TODO
    }

    /* Test Case: HDSS-FR02-TC-2
  * Equivalence Class: HDSS-FN2-EQ-1
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "No input file"
  */
    @Test
    public void noInputFileTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test Case: HDSS-FR02-TC-3
  * Equivalence Class: HDSS-FN2-EQ-3
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void emptyFileTest () throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputEmptyFile.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test Case: HDSS-FR02-TC-4
  * Equivalence Class: HDSS-FN2-EQ-4
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void nonExistingWatershedNameTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputNonExistingWatershedName.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test Case: HDSS-FR02-TC-5
  * Equivalence Class: HDSS-FN2-EQ-8
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void wrongDataTypeAllocationDateTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputAllocationDateDataType.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test Case: HDSS-FR02-TC-6
  * Equivalence Class: HDSS-FN2-EQ-9
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void allocationDateNotFoundTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputAllocationDateNotFound.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test Case: HDSS-FR02-TC-7
  * Equivalence Class: HDSS-FN2-EQ-10
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void watershedNameNotFoundTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputWatershedNameNotFound.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test Case: HDSS-FR02-TC-8
  * Equivalence Class: HDSS-FN2-EQ-11
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void wrongJSONFormatTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputJSONFormat.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }


    /* Test Case: HDSS-FR02-TC-9
  * Equivalence Class: HDSS-FN2-EQ-15
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void twoAllocationDatesTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputTwoAllocationDatesFound.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test Case: HDSS-FR02-TC-10
  * Equivalence Class: HDSS-FN2-EQ-16
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void twoWatershedNamesTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputTwoWatershedNamesFound.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test Case: HDSS-FR02-TC-11
  * Equivalence Class: HDSS-FN2-EQ-17
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void invalidWatershedNameLengthTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputWatershedNameLength.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test Case: HDSS-FR01-TC-12
  * Boundary Limit: HDSS-FN1-BL-1
  * Testing Technique: Boundary limit
  * Expected Result:
  */
    @Test
    public void watershedNameLengthLowerLimitTest() {
        //TODO
    }


    /* Test Case: HDSS-FR01-TC-13
  * Boundary Limit: HDSS-FN1-BL-2
  * Testing Technique: Boundary limit
  * Expected Result:
  */
    @Test
    public void watershedNameLengthRightValueTest() {
        //TODO
    }

    /* Test Case: HDSS-FR01-TC-14
  * Boundary Limit: HDSS-FN1-BL-3
  * Testing Technique: Boundary limit
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
    @Test
    public void watershedNameLengthUpperLimitTest() throws HydricDSSException {
        try {
            manager.AllocateWaterAmount("src/hdss/data/FR02/hdss-fr02-invalidInputWatershedName51Chars.json");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }


}
