package com.cli.tool.commands;

import com.cli.tool.operations.CSVFile;

public class CreateCSVFileCommand implements Command {

    CSVFile csvFile;

    public CreateCSVFileCommand(CSVFile csvFile){
        this.csvFile = csvFile;
    }

    @Override public void execute() {
        csvFile.createCSVFile();
        System.out.println("CSV created!");
    }
}
