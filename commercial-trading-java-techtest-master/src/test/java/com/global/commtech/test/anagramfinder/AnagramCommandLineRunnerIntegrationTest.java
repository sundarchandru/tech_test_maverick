package com.global.commtech.test.anagramfinder;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(args = {"src/test/resources/example1.txt"})
@ExtendWith(OutputCaptureExtension.class)
class AnagramCommandLineRunnerIntegrationTest {

    @Autowired
    AnagramCommandLineRunner anagramCommandLineRunner;

    @Mock
    private File file;

    @Test
    void testMethod() {
        String arg = null;
        assertThrows(IllegalArgumentException.class, () -> {
            if (arg == null) {
                throw new IllegalArgumentException("Argument cannot be null");
            }
        });
    }


    @Test
    public void testSortLetters() {
        String word = "hello";
        String expected = "ehllo";
        String sorted = FileReader.sortLetters(word);
        assertEquals(expected, sorted);
    }

    @Test
    public void testSortLettersEmptyString() {
        String word = "";
        String expected = "";
        String sorted = FileReader.sortLetters(word);
        assertEquals(expected, sorted);
    }

    @Test
    public void testSortLettersSingleCharacter() {
        String word = "a";
        String expected = "a";
        String sorted = FileReader.sortLetters(word);
        assertEquals(expected, sorted);
    }


    @Test
    public void testSortLettersRepeatedCharacters() {
        String word = "abba";
        String expected = "aabb";
        String sorted = FileReader.sortLetters(word);
        assertEquals(expected, sorted);
    }

    //Other scenarios
    @Test
    void testGroupAnagrams() throws IOException {
        String input = "hello\nagain\ngoodbye\n";
        List<String> words = Arrays.asList(input.split("\\s+"));
        Map<String, List<String>> expected = Map.of("aagin", Arrays.asList("again"), "bdegooy", Arrays.asList("goodbye"), "ehllo", Arrays.asList("hello"));
        Map<String, List<String>> actual = anagramCommandLineRunner.groupAnagrams(words);
        assertEquals(expected, actual);
    }

    @Test
    public void testGroupAnagramsWithMultiplewords() {
        List<String> inputWords = Arrays.asList("ate", "eat", "tea", "cat", "act");
        Map<String, List<String>> expectedOutput = new HashMap<>();
        expectedOutput.put("aet", Arrays.asList("ate", "eat", "tea"));
        expectedOutput.put("act", Arrays.asList("cat", "act"));

        Map<String, List<String>> actualOutput = anagramCommandLineRunner.groupAnagrams(inputWords);

        assertEquals(expectedOutput, actualOutput);
    }


    @Test
    public void testGroupAnagramsEmptyList() {
        List<String> inputWords = new ArrayList<>();
        Map<String, List<String>> actualOutput = anagramCommandLineRunner.groupAnagrams(inputWords);
        assertTrue(actualOutput.isEmpty());
    }

    @Test
    public void testGroupAnagramsNoAnagrams() {
        List<String> inputWords = Arrays.asList("cat", "dog", "rat");
        Map<String, List<String>> actualOutput = anagramCommandLineRunner.groupAnagrams(inputWords);
        assertEquals(3, actualOutput.size());
    }

    @Test
    public void testGroupAnagramsNullInput() {
        List<String> inputWords = null;
        Map<String, List<String>> actualOutput = anagramCommandLineRunner.groupAnagrams(inputWords);
        assertNull(actualOutput);
    }


}