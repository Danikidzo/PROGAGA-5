package utility;

import commands.*;

import java.util.HashSet;

public class CommandManager {
    private final HashSet<Command> commands = new HashSet<>();

   public CommandManager(FileManager fileManager, UserInputManager userInputManager, CollectionManager collectionManager, HistoryManager historyManager) {
        commands.add(new HelpCommand());
        commands.add(new AddCommand(collectionManager, userInputManager));
        commands.add(new ClearCommand(collectionManager));
        commands.add(new SaveCommand(fileManager, collectionManager));
        commands.add(new ShowCommand(collectionManager));
        commands.add(new UpdateCommand(collectionManager, userInputManager));
        commands.add(new CountLessThanImpactSpeed(collectionManager));
        commands.add(new ExitCommand());
        commands.add(new InfoCommand(collectionManager));
        commands.add(new HistoryCommand(historyManager));
        commands.add(new ExecuteScriptCommand(userInputManager));
        commands.add(new RemoveByIdCommand(collectionManager));
        commands.add(new FilterByWeaponTypeCommand(collectionManager));
       commands.add(new AddIfMinCommand(collectionManager, userInputManager));
       commands.add(new AverageOfImpactSpeedCommand(collectionManager, userInputManager));
       commands.add(new AddIfMaxCommand(collectionManager, userInputManager));
    }

    public HashSet<Command> getCommands() {
        return commands;
    }
}
