package hdss.tests;

import hdss.WatershedManager;
import hdss.WatershedManagerInterface;
import hdss.exceptions.HydricDSSException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class TestSyntaxFR01 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError01.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError02.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError03.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError04.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError05.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError06.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError07.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError08.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError09.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError10.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError11.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError12.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError13.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError14.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError15.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError16.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError17.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError18.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError19.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError20.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError21.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError22.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError23.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError24.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError25.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError26.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError27.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError28.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError29.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError30.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError31.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError32.json", "The input file has no data or does not match the expected format", "HDSS-RF-01 Syntax Error: Node modification"}
        });
    }

    private WatershedManagerInterface manager = new WatershedManager();

    private String filepath;
    private String expectedErrorMessage;
    private String helpingFailMessage;

    public TestSyntaxFR01(String filepath, String expectedErrorMessage, String helpingFailMessage) {
        this.filepath = filepath;
        this.expectedErrorMessage = expectedErrorMessage;
        this.helpingFailMessage = helpingFailMessage;
    }

    /* Test case: PARAMETERIZED TEST SUITE (HDSS-FR01-S-TC-1 to HDSS-FR01-S-TC-32)
    * Testing technique: Syntax analysis
    * Expected value: Throws an exception.
    */
    @Test
    public void fallingTest() {
        try {
            manager.CalculateWatershedAmount(filepath);
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), expectedErrorMessage);
        }
    }
}
//{"src/hdss/data/FR01_Syntax/hdss-rf01-correctFile.json", "Valid file", "HDSS-RF-01 Syntactically Valid File"},
