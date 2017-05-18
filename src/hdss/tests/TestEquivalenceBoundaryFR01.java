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
  *
  @Test
  public void testName() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("file.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "MENSAJE DE ERROR")
    }
  }
  */

  /* Test Case: HDSS-FR01-TC-1
  * Equivalence Class: HDSS-FN1-EQ-2, HDSS-FN1-EQ-3, HDSS-FN1-EQ-6, HDSS-FN1-EQ-8, HDSS-FN1-EQ-12,
  * HDSS-FN1-EQ-15, HDSS-FN1-EQ-17
  * Testing Technique: Equivalence class
  * Expected Result:
  */
  @Test
  public void basicValidTest() throws HydricDSSException {
    //TODO
  }

  /* Test Case: HDSS-FR01-TC-2
  * Equivalence Class: HDSS-FN1-EQ-1
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void noInputFileTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "No input files");
    }
  }

  /* Test Case: HDSS-FR01-TC-3
  * Equivalence Class: HDSS-FN1-EQ-4
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void invalidJSONFormatTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputJSONFormat.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
    }
  }

  /* Test Case: HDSS-FR01-TC-4
  * Equivalence Class: HDSS-FN1-EQ-5
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void emptyInputFileTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputEmptyFile.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
    }
  }

  /* Test Case: HDSS-FR01-TC-5
  * Equivalence Class: HDSS-FN1-EQ-7
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void nonExistingWatershedNameTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputNonExistingWatershedName.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
    }
  }

  /* Test Case: HDSS-FR01-TC-6
  * Equivalence Class: HDSS-FN1-EQ-9
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void invalidWatershedNameLengthTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputWatershedNameLength.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
    }
  }

  /* Test Case: HDSS-FR01-TC-7
  * Equivalence Class: HDSS-FN1-EQ-10
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void noWatershedNameFieldTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputWatershedNameNotFound.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
    }
  }

  /* Test Case: HDSS-FR01-TC-8
  * Equivalence Class: HDSS-FN1-EQ-11
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void twoWatershedNamesTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputTwoWatershedNamesFound.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
    }
  }

  /* Test Case: HDSS-FR01-TC-9
  * Equivalence Class: HDSS-FN1-EQ-13
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void twoCalculationDatesTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputTwoCalculationDatesFound.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
    }
  }

  /* Test Case: HDSS-FR01-TC-10
  * Equivalence Class: HDSS-FN1-EQ-14
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void noCalculationDateFieldTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputCalculationDateNotFound.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
    }
  }

  /* Test Case: HDSS-FR01-TC-11
  * Equivalence Class: HDSS-FN1-EQ-16
  * Testing Technique: Equivalence class
  * Expected Result: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  */
  @Test
  public void invalidCalculationDateFormatTest() throws HydricDSSException {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputCalculationDateFormat.json");
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
  public void watershedNameLengthUpperLimitTest() {
    try {
      manager.CalculateWatershedAmount("src/hdss/data/FR01/hdss-fr01-invalidInputWatershedName51Chars.json");
    } catch (HydricDSSException e) {
      assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
    }
  }
}
