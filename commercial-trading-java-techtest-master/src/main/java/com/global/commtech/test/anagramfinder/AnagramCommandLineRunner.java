package com.global.commtech.test.anagramfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
@RequiredArgsConstructor
public class AnagramCommandLineRunner implements CommandLineRunner {

    @Override
    public void run(final String... args) throws Exception {
        Assert.isTrue(args.length == 1, "Please ensure that the input file is provided");

       // final File file = new File(args[0]);
        if (args != null && args.length > 0 && args[0] != null) {
            final File file = new File(args[0]);
            Assert.isTrue(file.exists(), args[0] + " Does not exist");

            try (BufferedReader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()))) {
                // Read input words into a list
                // to get a stream of lines from the file, and then using flatMap() to split each line
                // into words and flatten the resulting stream of streams into a single stream of words.

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

            } catch (NoSuchFileException nse) {
                //logger.error("File not found: {}", e.getMessage());
                System.out.println("File not found: " + nse.getMessage());
            } catch (IOException e) {
                //logger.error("Error reading file: {}", e.getMessage());
                System.out.println("Error reading file: " + e.getMessage());
            }
            // rest of your code
        } else {
            System.err.println("Missing input file argument");
        }




    }

    /**
     * Groups a list of words by anagrams.
     *
     * @param inputWords the list of words to group
     * @return a map where the keys are sorted versions of each group of anagrams,
     **/
    public static Map<String, List<String>> groupAnagrams(List<String> inputWords) {
        if (inputWords == null) {
            return null;
        }
        // Group words by anagrams
        return inputWords.stream()
                .collect(Collectors.groupingBy(FileReader::sortLetters));
    }

    /**
     * Sorts the letters in a string in ascending order.
     * <p>
     * This method uses the following steps to sort the letters:
     * <p>
     * - The chars() method returns an IntStream of the characters in the string.
     * - The sorted() method sorts the characters in ascending order.
     * - The collect() method collects the sorted characters into a StringBuilder object.
     * - The appendCodePoint() method is used to append each character to the StringBuilder.
     * - Finally, the toString() method is called on the StringBuilder object to convert it back to a String.
     *
     * @param word the string to sort
     * @return the sorted string
     */
    public static String sortLetters(String word) {
        return word.chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
