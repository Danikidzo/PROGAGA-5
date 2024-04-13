package commands;

import utility.CollectionManager;
import utility.CommandResult;
import data.*;

public class FilterByWeaponTypeCommand extends Command {
    private final CollectionManager collectionManager;

    public FilterByWeaponTypeCommand(CollectionManager collectionManager) {
        super("filter_by_weapon_type");
        this.collectionManager = collectionManager;
    }

    @Override
    public CommandResult execute(String arg) {
        WeaponType inpEnum;
        try {
            inpEnum = WeaponType.valueOf(arg);
        } catch (IllegalArgumentException e) {
            return new CommandResult(false, "Your argument was incorrect");
        }
        String output = String.valueOf(collectionManager.filterByWeaponType(inpEnum));
        return new CommandResult(false, output);
    }
}
