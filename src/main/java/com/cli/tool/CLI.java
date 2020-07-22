package com.cli.tool;
import com.cli.tool.handlers.Handler;
import org.apache.commons.cli.Options;

import static com.cli.tool.Constants.*;

public class CLI {

    public static void main(String... args) {
        Handler.handleCommands(createOptions(), args);
    }

    private static Options createOptions() {
        Options options = new Options();
        options.addOption(ALL, true,
                        "It will run all the commands convert string to upper case, to alternate case, create csv file");
        options.addOption(TO_UPPER_CASE, true, "It will convert string in argument to upper case");
        options.addOption(TO_ALTERNATE_CASE, true, "It will convert string in argument to alternate case");
        options.addOption(CREATE_CSV_FILE, true, "It will convert string in argument to create csv file");
        return options;
    }


}
