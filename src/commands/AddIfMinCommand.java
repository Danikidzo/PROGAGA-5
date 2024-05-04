package commands;

import utility.*;
import data.*;

public class AddIfMinCommand extends Command {
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;

    public AddIfMinCommand(CollectionManager collectionManager, UserInputManager userInputManager) {
        super("add_if_min");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        HumanBeing humanBeing;
        humanBeing = AddElem.add(true, userInputManager, collectionManager);
        if(collectionManager.addMin(humanBeing)){
            return new CommandResult(false, "Successfully added");
        }
        return new CommandResult(false, "Failed to add: not min" );
    }
}
