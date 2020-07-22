package com.cli.tool.operations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSVFile {

    private String value;
    private String fileName;
    private static final String DEFAULT_SEPARATOR = ",";

    public CSVFile(String value, String fileName) {
        this.value = value;
        this.fileName = fileName;
    }

    public CSVFile(String fileName) {
        this.fileName = fileName;
    }

    public void createCSVFile() {

        try {
            char[] chars = value.toCharArray();
            FileWriter csvWriter = null;
            csvWriter = new FileWriter(fileName);

            int stringLength = chars.length;
            for (int i = 0; i < stringLength; i++) {
                char ch = chars[i];
                csvWriter.append(ch);
                if (i != stringLength - 1)
                    csvWriter.append(DEFAULT_SEPARATOR);
            }
            csvWriter.append("\n");

            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println("There is some technical problem while creating file: "+fileName);
        }
    }

    public String readCSVFile() {
        BufferedReader br = null;
        String line = "";
        String output = "";

        try {
            br = new BufferedReader(new FileReader(fileName));
            for (;((line = br.readLine()) != null); output +="\n") {
                output += String.join("", line.split(DEFAULT_SEPARATOR));
            }

        } catch (FileNotFoundException e) {
            System.out.println(fileName + " file not found");
        } catch (IOException e) {
            System.out.println("There is some technical problem while reading file: "+fileName);
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return output;
    }
}
