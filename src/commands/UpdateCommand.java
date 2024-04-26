package commands;


import data.HumanBeing;
import utility.*;

public class UpdateCommand extends Command {
    private final OutputManager outputManager;
    private final UserInputManager userInputManager;
    private final CollectionManager collectionManager;

    public UpdateCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("update");
        this.userInputManager = userInputManager;
        this.collectionManager = collectionManager;
        this.outputManager = outputManager;
    }

    @Override
    public CommandResult execute(String arg) {
        Long id;
        try {
            id = Long.parseLong(arg);
        } catch (NumberFormatException e) {
            return new CommandResult(false, "Your argument was incorrect. The command was not executed.");
        }
        if (!collectionManager.isHaveId(id)) {
            return new CommandResult(false, "this id doesn't exist.");
        }
        HumanBeing humanBeing;
        humanBeing = AddElem.add(false, userInputManager, outputManager, collectionManager);
        humanBeing.setId(id);
        collectionManager.removeByID(id);
        collectionManager.add(humanBeing);
        return new CommandResult(false, "success added");

    }
}