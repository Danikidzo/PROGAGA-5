package utility;

import data.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

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
                e.printStackTrace();
            }

        } else {
            return scanner.nextLine();
        }
        return "";
    }

    public Float readFloatValue(String message, String messString) {
        boolean shouldContinue = true;
        Float floatResult = null;
        while (shouldContinue) {
            System.out.println("enter" + message + ":");
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
                System.out.println(messString);
                shouldContinue = true;
            }

        }
        return floatResult;
    }

    public Long readLongValue(String message, String messString) {
        boolean shouldContinue = true;
        Long longResult = null;
        while (shouldContinue) {
            System.out.println("enter" + message + ":");
            try {
                String line = nextLine();
                if (!("".equals(line))) {
                    longResult = Long.parseLong(line);
                    shouldContinue=false;
                } else {
                    System.out.println(messString);
                    shouldContinue=true;
                }
            } catch (NumberFormatException | NullPointerException e) {
                System.out.println(messString);
                shouldContinue = true;
            }

        }
        return longResult;
    }

    public WeaponType readWeaponType(String message, String messString) {
        boolean shouldContinue = true;
        WeaponType weaponResult = null;
        while (shouldContinue) {
            System.out.println("enter" + message + ":");
                String line = nextLine().toUpperCase(Locale.ROOT).trim();
            switch (line) {
                case "RIFLE" -> {
                    weaponResult = WeaponType.RIFLE;
                    shouldContinue = false;
                }
                case "HAMMER" -> {
                    weaponResult = WeaponType.HAMMER;
                    shouldContinue = false;
                }
                case "PISTOL" -> {
                    weaponResult = WeaponType.PISTOL;
                    shouldContinue = false;
                }
                default -> {
                    System.out.println(messString);
                    shouldContinue = true;
                }
            }
        }
        return weaponResult;
    }

    public Boolean readBooleanValue(String message, String messString) {
        boolean shouldContinue = true;
        Boolean booleanResult = null;
        while (shouldContinue) {
            System.out.println("enter" + message + ":");
                String line = nextLine().toUpperCase(Locale.ROOT).trim();
               if(line.equals("FALSE")) {
                   booleanResult = false;
                   shouldContinue=false;
               }
               else if(line.equals("TRUE")){
                   booleanResult = true;
                   shouldContinue=false;
               }
               else {System.out.println(messString);
                   shouldContinue = true;}
        }
        return booleanResult;
    }

    public Mood readMood(String message, String messString) {
        boolean shouldContinue = true;
        Mood moodResult = null;
        while (shouldContinue) {
            System.out.println("enter" + message + ":");
                String line = nextLine().toUpperCase(Locale.ROOT).trim();
            switch (line) {
                case "APATHY" -> {
                    moodResult = Mood.APATHY;
                    shouldContinue = false;
                }
                case "GLOOM" -> {
                    moodResult = Mood.GLOOM;
                    shouldContinue = false;
                }
                case "FRENZY" -> {
                    moodResult = Mood.FRENZY;
                    shouldContinue = false;
                }
                default -> {
                    System.out.println(messString);
                    shouldContinue = true;
                }
            }
        }
        return moodResult;
    }

    public String readStringNameValue(String message, String messString) {
        boolean shouldContinue = true;
        String name = null;
        while (shouldContinue) {
            System.out.println("enter" + message + ":");
            name = nextLine().trim();
            if (name.isEmpty()) {
                    System.out.println(messString);
                    shouldContinue = true;
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