package commands;

import utility.*;

public class CountLessThanImpactSpeed extends Command {

    public final CollectionManager collectionManager;

    public CountLessThanImpactSpeed(CollectionManager collectionManager) {
        super("count_less_than_impact_speed");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        float impactSpeed;
        try {
            impactSpeed = Float.parseFloat(arg);
        } catch (IllegalArgumentException e) {
            return new CommandResult(false, "Your argument was incorrect");
        }
        String output = String.valueOf(collectionManager.countLessThanImpactSpeed(impactSpeed));
        return new CommandResult(false, output);
    }
}