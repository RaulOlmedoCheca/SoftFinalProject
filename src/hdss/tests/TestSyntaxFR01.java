package hdss.tests;

import hdss.WatershedManager;
import hdss.WatershedManagerInterface;
import hdss.exceptions.HydricDSSException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

@RunWith(Parameterized.class)
public class TestSyntaxFR01 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"src/hdss/data/FR01_Syntax/hdss-rf01-correctFile.json", "Valid file", "HDSS-RF-01 Syntactically Valid File"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError01.json", "Empty file", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError02.json", "Missing {", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError03.json", "Missing }", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError04.json", "Missing body", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError05.json", "Missing name", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError06.json", "Missing calculation_date", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError07.json", "Missing name field", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError08.json", "Missing name tag", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError09.json", "Missing ", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError10.json", "Missing :", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError11.json", "Missing \"", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError12.json", "Missing /", "HDSS-RF-01 Syntax Error: Omission of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError13.json", "Repetition of /", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError14.json", "Repetition of body", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError15.json", "Repetition of {", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError16.json", "Repetition of }", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError17.json", "Repetition of :", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError18.json", "Repetition of ,", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError19.json", "Repetition of \"", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError20.json", "Repetition of name", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError21.json", "Repetition of name tag", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError22.json", "Repetition of name field", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError23.json", "Modification of name tag", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError24.json", "Modification of name field", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError25.json", "Modification of {", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError26.json", "Modification of }", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError27.json", "Modification of \"", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError28.json", "Modification of calculation_date field", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError29.json", "Modification of /", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError30.json", "Modification of calculation_date tag", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError31.json", "Modification of ,", "HDSS-RF-01 Syntax Error: Node modification"},
                {"src/hdss/data/FR01_Syntax/hdss-rf01-syntaxError32.json", "Modification of :", "HDSS-RF-01 Syntax Error: Node modification"}
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

    /* Test case: PARAMETERIZED TEST SUITE (HDSS-FR01-S-TC-1 to HDSS-FN1-S-TC-33)
    * Testing technique: Syntax analysis
    * Expected value: Throws an exception.
    */
    @Test
    public void fallingTest() {
        try {
            manager.RegisterHydricResources(filepath);
            fail(helpingFailMessage);
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), expectedErrorMessage);
        }
    }
}

