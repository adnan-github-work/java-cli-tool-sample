package com.cli.tool.triggers;

import com.cli.tool.commands.Command;

public class TriggerCLICommand {

    Command cliCommand;

    public void setCommand(Command cliCommand)
    {
        // set the cli command to
        // execute
        this.cliCommand = cliCommand;
    }

    public void executeCommand()
    {
        cliCommand.execute();
    }

}
