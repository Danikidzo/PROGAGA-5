package commands;

import data.HumanBeing;
import utility.*;


public class AddCommand extends Command {
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;
    private final OutputManager outputManager;

    public AddCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("add");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        HumanBeing humanBeing;
        humanBeing = AddElem.add(true, userInputManager, outputManager, collectionManager);
        collectionManager.add(humanBeing);
        return new CommandResult(false, "succes added");
    }
}

