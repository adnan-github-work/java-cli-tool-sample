package com.cli.tool.handlers;

import com.cli.tool.commands.ConvertStringAlternateCaseCommand;
import com.cli.tool.commands.ConvertStringUpperCaseCommand;
import com.cli.tool.commands.CreateCSVFileCommand;
import com.cli.tool.operations.CSVFile;
import com.cli.tool.operations.FormatString;
import com.cli.tool.triggers.TriggerCLICommand;
import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import static com.cli.tool.Constants.*;

public class Handler {

    private static TriggerCLICommand triggerCLICommand;

    public static void handleCommands(Options options, String[] args) {
        try {
            if (args.length <= 0){
                System.out.println("There was no argument found, Please pass valid argument");
                return;
            }
            CommandLine line = new BasicParser().parse(options, args);
            triggerCLICommand = new TriggerCLICommand();

            if (line.hasOption(ALL)) {
                String str = line.getOptionValue(ALL);
                triggerAllCommands(str);

            }else if (line.hasOption(TO_UPPER_CASE)) {
                String str = line.getOptionValue(TO_UPPER_CASE);
                triggerUpperCaseCommand(str);

            }else if (line.hasOption(TO_ALTERNATE_CASE)) {
                String str = line.getOptionValue(TO_ALTERNATE_CASE);
                triggerAlternateCaseCommand(str);
            }else if (line.hasOption(CREATE_CSV_FILE)) {
                String str = line.getOptionValue(CREATE_CSV_FILE);
                triggerCreateCSVFileCommand(str);
            }else {
                triggerAllCommands(args[0]);
            }

        } catch (ParseException exp) {
            System.out.println("Unexpected exception:" + exp.getMessage());
        }catch (Exception e){
            System.out.println("There is some technical problem while handling arguments");
        }
    }

    private static void triggerAllCommands(String str) {
        if (str != null && !str.isEmpty()) {
            triggerUpperCaseCommand(str);
            triggerAlternateCaseCommand(str);
            triggerCreateCSVFileCommand(str);
        }else {
            System.out.println("Please pass valid argument");
        }
    }

    private static void triggerCreateCSVFileCommand(String str) {
        checkNullOrEmpty(str);
            triggerCLICommand.setCommand(new CreateCSVFileCommand(new CSVFile(str, fileName)));
            triggerCLICommand.executeCommand();

    }

    private static void triggerAlternateCaseCommand(String str) {
        checkNullOrEmpty(str);
        triggerCLICommand.setCommand(new ConvertStringAlternateCaseCommand(new FormatString(str)));
        triggerCLICommand.executeCommand();
    }

    private static void triggerUpperCaseCommand(String str) {
        checkNullOrEmpty(str);
        triggerCLICommand.setCommand(new ConvertStringUpperCaseCommand(new FormatString(str)));
        triggerCLICommand.executeCommand();
    }

    public static void checkNullOrEmpty(String str) {
        if (str != null && !str.isEmpty()){
        }else {
            System.out.println("Please pass valid argument");
            return;
        }
    }

}
