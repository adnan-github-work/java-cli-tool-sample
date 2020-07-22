package com.cli.tool.commands;

import com.cli.tool.operations.FormatString;

public class ConvertStringAlternateCaseCommand implements Command {

    FormatString string;

    public ConvertStringAlternateCaseCommand(FormatString string){
        this.string = string;
    }

    @Override public void execute() {
        System.out.println(string.toAlternateCase());
    }
}
