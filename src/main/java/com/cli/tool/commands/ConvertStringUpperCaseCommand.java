package com.cli.tool.commands;

import com.cli.tool.operations.FormatString;

public class ConvertStringUpperCaseCommand implements Command {


    private FormatString formatString;

    public ConvertStringUpperCaseCommand(FormatString formatString){
        this.formatString = formatString;
    }

    @Override public void execute() {
        System.out.println(formatString.toUpperCase());
    }
}
