package com.cli.tool.commands;

import com.cli.tool.operations.CSVFile;

public class ReadCSVFileCommand implements Command {

    CSVFile csvFile;

    ReadCSVFileCommand(CSVFile csvFile){
        this.csvFile = csvFile;
    }

    @Override public void execute() {
        csvFile.readCSVFile();
    }

}
