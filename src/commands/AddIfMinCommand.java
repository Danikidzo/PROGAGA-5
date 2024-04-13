package commands;

import exceptions.*;
import utility.*;
import data.*;

public class AddIfMinCommand extends Command {
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;

    public AddIfMinCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("add_if_min");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        HumanBeing humanBeing;
        try {
            humanBeing = AddElem.add(true, userInputManager, outputManager, collectionManager);
            collectionManager.addMin(humanBeing);
            return new CommandResult(false, "succes added");
        } catch (NotMinException e) {
            return new CommandResult(false, "not success:" + e.getMessage());
        }
    }
}
