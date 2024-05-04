package commands;

import utility.*;

public class AverageOfImpactSpeedCommand extends Command {
    private final CollectionManager collectionManager;

    public AverageOfImpactSpeedCommand(CollectionManager collectionManager, UserInputManager userInputManager) {
        super("average_of_impact_speed");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
            float y = collectionManager.averageImpactSpeed();
            return new CommandResult(false, "Average Of Impact Speed: " + y);

    }
}