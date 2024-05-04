package commands;

import data.HumanBeing;
import utility.*;


public class AddCommand extends Command {
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;

    public AddCommand(CollectionManager collectionManager, UserInputManager userInputManager) {
        super("add");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        HumanBeing humanBeing;
        humanBeing = AddElem.add(true, userInputManager, collectionManager);
        collectionManager.add(humanBeing);
        return new CommandResult(false, "Successfully added");
    }
}

