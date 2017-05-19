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
public class TestSyntaxFR02 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError01.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError02.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError03.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError04.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError05.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError06.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError07.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError08.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError09.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError10.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError11.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError12.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError13.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError14.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError15.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError16.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError17.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError18.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError19.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError20.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError21.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError22.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError23.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError24.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError25.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError26.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError27.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError28.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError29.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError30.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError31.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"},
                {"src/hdss/data/FR02_Syntax/hdss-rf02-syntaxError32.json", "The input file has no data or does not match the expected format", "HDSS-RF-02 Syntax Error: Node modification"}
        });
    }

    private WatershedManagerInterface manager = new WatershedManager();

    private String filepath;
    private String expectedErrorMessage;
    private String helpingFailMessage;

    public TestSyntaxFR02(String filepath, String expectedErrorMessage, String helpingFailMessage) {
        this.filepath = filepath;
        this.expectedErrorMessage = expectedErrorMessage;
        this.helpingFailMessage = helpingFailMessage;
    }

    /* Test case: PARAMETERIZED TEST SUITE (HDSS-FR02-S-TC-1 to HDSS-FR02-S-TC-32)
    * Testing technique: Syntax analysis
    * Expected value: Throws an exception.
    */
    @Test
    public void fallingTest() {
        try {
            manager.RegisterHydricResources(filepath);
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), expectedErrorMessage);
        }
    }
}
//{"src/hdss/data/FR02_Syntax/hdss-rf02-correctFile.json", "Valid file", "HDSS-RF-02 Syntactically Valid File"},
//TODO