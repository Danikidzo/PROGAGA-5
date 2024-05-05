package commands;

import utility.*;
import data.*;

public class AddIfMaxCommand extends Command {
    private final CollectionManager collectionManager;
    private final UserInputManager userInputManager;

    public AddIfMaxCommand(CollectionManager collectionManager, UserInputManager userInputManager) {
        super("add_if_max");
        this.collectionManager = collectionManager;
        this.userInputManager = userInputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        HumanBeing humanBeing;
            humanBeing = AddElem.add(true, userInputManager, collectionManager);
            if(collectionManager.addMax(humanBeing)){
                return new CommandResult(false, "Successfully added");
            }
            return new CommandResult(false, "Failed to add: not max" );
        }
    }

