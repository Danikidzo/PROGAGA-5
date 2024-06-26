package utility;

import com.google.gson.JsonSyntaxException;
import data.HumanBeing;
import java.io.IOException;
import java.util.Objects;
import java.util.TreeSet;

public class Console {
    private final CommandRunManager commandRunManager;
    private final CollectionManager collectionManager;
    private final FileManager fileManager;
    private final UserInputManager userInputManager;

    public Console(FileManager fileManager, UserInputManager userInputManager, CollectionManager collectionManager, CommandRunManager commandRunManager) {
        this.fileManager = fileManager;
        this.userInputManager = userInputManager;
        this.collectionManager = collectionManager;
        this.commandRunManager = commandRunManager;
    }

    public void start() throws IllegalArgumentException, JsonSyntaxException, IOException {
        String stringData = fileManager.read();

        TreeSet<HumanBeing> humanBeings = JsonParser.toData(stringData);

        collectionManager.initialiseData(humanBeings == null ? new TreeSet<>() : humanBeings);

        startCommandCycle();
    }

    private String[] parseToNameAndArg(String input) {
        String[] arrayInput = input.split(" ");
        String inputCommand = arrayInput[0];
        String inputArg = "";

        if (arrayInput.length >= 2) {
            inputArg = arrayInput[1];
        }

        return new String[]{inputCommand, inputArg};
    }

    private String readNextCommand() {
        System.out.print(">>>");
        return userInputManager.nextLine();
    }

    private void startCommandCycle() {
        CommandResult commandResult;
        do {
            String name = "";
            String arg = "";
            String input = readNextCommand();
            String[] commandNameAndArg = parseToNameAndArg(input);
            if (commandNameAndArg.length >= 1) {
                name = commandNameAndArg[0];
            }
            if (commandNameAndArg.length >= 2) {
                arg = commandNameAndArg[1];
            }
            commandResult = commandRunManager.runCommand(name, arg);
            System.out.println(commandResult.getOutput());
        } while (!Objects.requireNonNull(commandResult).isExit());
    }
}

