package arora.gurdeep.weightwatchers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Parse dictionary with word and its meanings from a file.
public class Question1 {
    public static void main(String[] args) {

        // Check that relative path is given as program input.
        if (args.length != 1) {
            System.out.println("This program requires relative path to the dictionary as the input parameter." + System.lineSeparator() + "Please run it as \"java arora.gurdeep.weightwatchers.Question1 <path_to_dictionary>\"");
        } else {
            String filePath = args[0];

            // Check that file path exists and is of file type (not directory etc).
            if (!doesFileExist(filePath)) {
                System.out.println("The file path \"" + filePath + "\" does not exist."
                        + System.lineSeparator() + "Please make sure that the file exists relative to the direction where this Java program is run");
            } else if (isFileEmpty(filePath)) {
                System.out.println("The file at path: " + filePath + " is empty. Please ensure it has some content.");
            } else {
                try {
                    // Keep the parsed lines in a map. Preserve insertion order.
                    // If same key is seen more than once, ignore it and print error message.
                    Map<String, Set<String>> map = new LinkedHashMap<>();

                    BufferedReader br = new BufferedReader(new FileReader(filePath));
                    String line;
                    List<String> invalidLines = new ArrayList<String>();
                    while ((line = br.readLine()) != null) {
                        // Check that line is of the format <word> - <meanings>
                        if (!isValidLine(line)) {
                            invalidLines.add(line);
                        } else {
                            // Parse the line
                            // Split around dash. Note that it expects only 1 dash in each dictionary entry
                            String[] sp = line.split("-", 2);
                            String word = sp[0].trim();
                            String meanings = sp[1].trim();

                            // If word doesn't exist in the map, add it
                            if (map.get(word) != null) {
                                System.out.println("Duplicate key: " + word + "found. Ignoring it");
                            } else {
                                map.put(word, new LinkedHashSet<>());
                            }
                            // Meanings itself needs to be split around commas
                            for (String meaning : meanings.split(",")) {
                                // Add the meaning. Since we use set, it automatically eliminates duplicates
                                map.get(word).add(meaning.trim());
                            }
                        }
                    }

                    // All done. Now print the map
                    printMap(map);

                    // Print error message if invalid lines were found
                    printInvalidLinesMessage(invalidLines);

                } catch (IOException fileNotFoundException) {
                    // Should not reach here since existence of file already checked in "if" condition
                }
            }
        }
    }


    private static boolean doesFileExist(String filePath) {
        File f = new File(filePath);
        return f.exists() && f.isFile();
    }

    private static boolean isFileEmpty(String filePath) {
        File f = new File(filePath);
        return f.length() == 0;
    }

    private static boolean isValidLine(String line) {
        // Check line validity via regex expression.
        return line.matches("[A-Z][a-z]* - [a-z]+( [a-z]+)*(, [a-z]+( [a-z]+)*)*");
    }

    private static void printInvalidLinesMessage(List<String> invalidLines) {
        System.out.println(System.lineSeparator() +
                "===================================" +
                System.lineSeparator() +
                "Invalid input format found in the following lines: " +
                System.lineSeparator());
        for (String invalidLine : invalidLines) {
            System.out.println(invalidLine);
        }

        System.out.println(System.lineSeparator() +
                "Lines above should be of the format <word> - <meaning 1>, <meaning 2>,..., <meaning n>" +
                System.lineSeparator() +
                "Where <word> must start with Uppercase letter followed by lowercase letters." +
                System.lineSeparator() +
                "And there must be at least 1 occurrence of <meaning> where each <meaning> must be lowercase letters with optional space and must end with lowercase letter." +
                System.lineSeparator() +
                "==================================="
        );
    }

    private static void printMap(Map<String, Set<String>> map) {
        map.forEach((key, value) -> {
            // Print the key (word) first
            System.out.println(key);

            // Print each meaning as well
            for (String meaning : value) {
                System.out.println(meaning);
            }
        });
    }
}
