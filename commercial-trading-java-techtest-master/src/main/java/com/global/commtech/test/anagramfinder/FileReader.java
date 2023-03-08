package com.global.commtech.test.anagramfinder;

import java.nio.file.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class FileReader {

//    private static final Logger logger = LoggerFactory.getLogger(FileReader.class);

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide a file path as an argument.");
            return;
        }

        String filePath = args[0];
        //try-with-resources statement to automatically close the reader after we're done reading from the file.

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String content = Files.readString(Paths.get(filePath));
            System.out.println("File contents:");
            System.out.println(content);
            System.out.println("=================================:");

            // Read input words into a list
            //The rest of the code is the same as before, except that we're using reader.lines()
            // to get a stream of lines from the file, and then using flatMap() to split each line
            // into words and flatten the resulting stream of streams into a single stream of words.
            // Overall, using try-with-resources makes the code more concise and helps to prevent resource leaks by automatically closing the file after reading.
            List<String> words = reader.lines()
                    .flatMap(line -> Arrays.stream(line.split("\\s+")))
                    .collect(Collectors.toList());
            Map<String, List<String>> groups = groupAnagrams(words);

            // Print groups to standard output
            for (List<String> group : groups.values()) {
                if (group.size() > 1) {
                    System.out.println(String.join(", ", group));
                    System.out.println("=================================:");
                }
            }
        } catch (NoSuchFileException e) {
            //logger.error("File not found: {}", e.getMessage());
            System.out.println("File not found: "+e.getMessage());
        } catch (IOException e) {
            //logger.error("Error reading file: {}", e.getMessage());
            System.out.println("Error reading file: "+e.getMessage());
        }
    }

    // Group words by anagrams
    public static Map<String, List<String>> groupAnagrams(List<String> inputWords){
        if (inputWords == null) {
            return null;
        }
        // Group words by anagrams
        return  inputWords.stream()
                .collect(Collectors.groupingBy(FileReader::sortLetters));

    }
    /*
        The chars() method returns an IntStream of the characters in the string.
    The sorted() method sorts the characters in ascending order.
    The collect() method collects the sorted characters into a StringBuilder object.
    The appendCodePoint() method is used to append each character to the StringBuilder.
    Finally, the toString() method is called on the StringBuilder object to convert it back to a String.
     */
    public static String sortLetters(String word) {
        return word.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
