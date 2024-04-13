package commands;

import exceptions.*;
import utility.*;
import data.*;

public class AddIfMaxCommand extends Command {
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;

    public AddIfMaxCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("add_if_max");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        HumanBeing humanBeing;
        try {
            humanBeing = AddElem.add(true, userInputManager, outputManager, collectionManager);
            collectionManager.addMax(humanBeing);
            return new CommandResult(false, "succes added");
        } catch (NotMaxException e) {
            return new CommandResult(false, "not success:" + e.getMessage());
        }
    }
}
