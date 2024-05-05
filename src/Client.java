import utility.*;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;

public final class Client {
    public static void main(String[] args) {

        try (UserInputManager userInputManager = new UserInputManager()) {
            String fileName = "HumanBeingCollection";
            if(args.length==0) {
                System.out.println("Please enter a file name: ");
                fileName = userInputManager.nextLine();
            }
            final FileManager fileManager = args.length == 0 ? new FileManager(new File(fileName).getPath()) : new FileManager(args[0]);
            try{
                if(args.length==0){
                    FileWriter writer = new FileWriter(fileName, false);
                    writer.write("[]");
                    writer.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            final HistoryManager historyManager = new HistoryManager();
            final CollectionManager collectionManager = new CollectionManager();
            final CommandManager commandManager = new CommandManager(fileManager, userInputManager, collectionManager, historyManager);
            final CommandRunManager commandRunManager = new CommandRunManager(commandManager, historyManager);
            final Console console = new Console(fileManager, userInputManager, collectionManager, commandRunManager);
            console.start();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Could not read the file. Check if it is available.");
        } catch (NumberFormatException e) {
            System.out.println("dataTypeError. Please check correctness dataType.");
        } catch (JsonSyntaxException e) {
            System.out.println("jsonSyntaxError. Please check format json are elements.");
        } catch (NoSuchElementException e) {
            System.out.println("EOF");
        } catch (Exception e) {
            System.out.println(e.getMessage() + " ");
            e.printStackTrace();
        }
    }
}