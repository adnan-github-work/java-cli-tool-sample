package com.cli.tool;

import com.cli.tool.operations.CSVFile;
import com.cli.tool.operations.FormatString;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CLITest {

    private String testString = "Hello World";
    private CSVFile createCSVFile;
    private CSVFile readCSVFile;
    private FormatString formatString;



    @Before
    public void setUpTestData(){
        formatString = new FormatString(testString);
        String fileName = "store_string.csv";
        createCSVFile = new CSVFile(testString, fileName);
        readCSVFile = new CSVFile(fileName);
    }

    @Test
    public void testUpperCase(){

        String expectedUpperCaseString = "HELLO WORLD";
        assertEquals(expectedUpperCaseString, formatString.toUpperCase());

    }

    @Test
    public void testAlternateCase(){
        String expectedAlternateCaseString = "hElLo wOrLd";
        assertEquals(expectedAlternateCaseString, formatString.toAlternateCase());
    }

    @Test
    public void testCSVFileCreation(){
            createCSVFile.createCSVFile();
            assertEquals(testString, readCSVFile.readCSVFile().trim());
    }


    @Test
    public void testReadCSVFileNotExist(){
        String fileNameNotExist = "not_exist.csv";
        readCSVFile = new CSVFile(fileNameNotExist);
        String NO_DATA = "";
        assertEquals(NO_DATA, readCSVFile.readCSVFile().trim());
    }

}
