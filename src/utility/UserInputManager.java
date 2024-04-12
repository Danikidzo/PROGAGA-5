package utility;

import data.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.Predicate;

/**
 * This class is used for all the user input: keyboard and script execution
 */
public class UserInputManager implements AutoCloseable {
    private final Scanner scanner = new Scanner(System.in);
    private final Stack<BufferedReader> currentFilesReaders = new Stack<>();
    private final Stack<File> currentFiles = new Stack<>();


    public String nextLine() {
        if (!currentFilesReaders.isEmpty()) {
            try {
                String input = currentFilesReaders.peek().readLine();
                if (input == null) {
                    currentFiles.pop();
                    currentFilesReaders.pop().close();
                    return nextLine();
                } else {
                    return input;
                }


            } catch (IOException e) {
                // never throws exception
                e.printStackTrace();
            }

        } else {
            return scanner.nextLine();
        }

        // never returns ""
        return "";
    }

    public Float readFloatValue(String message, OutputManager outputManager, String messString) {
        boolean shouldContinue = true;
        Float floatResult = null;
        while (shouldContinue) {
            outputManager.println(messString + "\n" + "enter" + message + ":");
            try {
                String line = nextLine();
                if (!("".equals(line))) {
                    floatResult = Float.parseFloat(line);
                    shouldContinue=false;
                } else {
                    System.out.println(messString);
                    shouldContinue=true;
                }
            } catch (NumberFormatException | NullPointerException e) {
                shouldContinue = true;
            }

        }
        return floatResult;
    }



    public WeaponType readWeaponType(String message, OutputManager outputManager, String messString) {
        boolean shouldContinue = true;
        WeaponType weaponResult = null;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            try {
                String line = nextLine().toUpperCase(Locale.ROOT).trim();
                weaponResult = "".equals(line) ? null : WeaponType.valueOf(line);
                shouldContinue = false;
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(messString);
                shouldContinue = true;
            }
        }
        return weaponResult;
    }

    public Boolean readBooleanValue(String message, OutputManager outputManager, String messString) {
        boolean shouldContinue = true;
        Boolean booleanResult = null;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            try {
                String line = nextLine().toUpperCase(Locale.ROOT).trim();
                booleanResult = "".equals(line) ? null : Boolean.valueOf(line);
                shouldContinue = false;
            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(messString);
                shouldContinue = true;
            }
        }
        return booleanResult;
    }

    public Long readLongValue(String message, OutputManager outputManager, String messString) {
        boolean shouldContinue = true;
        Long longResult = null;
        while (shouldContinue) {
            outputManager.println(messString + "\n" + "enter" + message + ":");
            try {
                String line = nextLine();
                longResult = "".equals(line) ? null : Long.parseLong(line);
                shouldContinue=false;
            } catch (NumberFormatException | NullPointerException e) {
                shouldContinue = true; // codestyle`
            }

        }
        return longResult;
    }

    public Mood readMood(String message, OutputManager outputManager, String messString) {
        boolean shouldContinue = true;
        Mood moodResult = null;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            try {
                String line = nextLine().toUpperCase(Locale.ROOT).trim();
                moodResult = "".equals(line) ? null : Mood.valueOf(line);
                shouldContinue = false;

            } catch (IllegalArgumentException | NullPointerException e) {
                System.out.println(messString);
                shouldContinue = true;
            }
        }
        return moodResult;
    }

    public String readStringNameValue(String message, OutputManager outputManager, String messString) {
        boolean shouldContinue = true;
        String name = null;
        while (shouldContinue) {
            outputManager.println("enter" + message + ":");
            name = nextLine().trim();
            if (name.length() == 0) {
                if ("".equals(name)) {
                    System.out.println(messString);
                    shouldContinue = true;
                }
            } else {
                shouldContinue = false;
            }
        }
        return name;
    }

    public void connectToFile(File file) throws IOException, UnsupportedOperationException {
        if (currentFiles.contains(file)) {
            throw new UnsupportedOperationException("The file was not executed due to recursion");
        } else {
            BufferedReader newReader = new BufferedReader(new FileReader(file));
            currentFiles.push(file);
            currentFilesReaders.push(newReader);
        }
    }

    @Override
    public void close() throws Exception {
        for (BufferedReader bufferedReader:currentFilesReaders) {
            bufferedReader.close();
        }
        scanner.close();
    }
}