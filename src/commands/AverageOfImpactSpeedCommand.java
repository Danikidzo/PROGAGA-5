package commands;

import exceptions.*;
import utility.*;
import data.*;

public class AverageOfImpactSpeedCommand extends Command {
    private final CollectionManager collectionManager;

    public AverageOfImpactSpeedCommand(CollectionManager collectionManager, UserInputManager userInputManager, OutputManager outputManager) {
        super("average_of_impact_speed");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
            collectionManager.averageImpactSpeed();
            return new CommandResult(false, "");

    }
}