//package com.global.commtech.test.anagramfinder;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.system.CapturedOutput;
//import org.springframework.boot.test.system.OutputCaptureExtension;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.assertj.core.api.Assertions.assertThatThrownBy;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ExtendWith(MockitoExtension.class)
//@ExtendWith(OutputCaptureExtension.class)
//class AnagramCommandLineRunnerTest {
//
//    private AnagramCommandLineRunner anagramCommandLineRunner;
//
//    @Mock
//    private File file;
//
//    @BeforeEach
//    void setUp() {
//        anagramCommandLineRunner = new AnagramCommandLineRunner();
//    }
//
////
////    @Test
////    void shouldThrowExceptionWhenNoArgumentsPresent() {
////        final var exception = assertThrows(Exception.class, () -> anagramCommandLineRunner.run());
////        assertThat(exception.getMessage()).isEqualTo("Please ensure that the input file is provided");
////    }
//    @Test
//    void shouldThrowExceptionWhenNoArgumentsPresent() throws IOException {
//        File inputFile = createTemporaryFile("input.txt", "some input data");
//        final var exception = assertThrows(Exception.class, () -> anagramCommandLineRunner.run(inputFile.getAbsolutePath()));
//        assertThat(exception.getMessage()).isEqualTo("Please ensure that the input file is provided");
//    }
//
//    public static File createTemporaryFile(String fileName, String content) throws IOException {
//        File tempFile = File.createTempFile(fileName, "");
//        FileWriter writer = new FileWriter(tempFile);
//        writer.write(content);
//        writer.close();
//        return tempFile;
//    }
//
//    @Test
//    void shouldThrowExceptionWhenMoreThanOneArgumentIsPassed() {
//        final var exception = assertThrows(Exception.class, () -> anagramCommandLineRunner.run("one", "two"));
//        assertThat(exception.getMessage()).isEqualTo("Please ensure that the input file is provided");
//    }
//
////    @Test
////    void shouldThrowExceptionWhenInputFileDoesNotExist() {
////        final var exception = assertThrows(Exception.class, () -> anagramCommandLineRunner.run("notExists"));
////        assertThat(exception.getMessage()).isEqualTo("notExists Does not exist");
////    }
////    @Test
////    void shouldThrowExceptionWhenNoArgs(CapturedOutput capturedOutput) {
////        assertThatThrownBy(() -> anagramCommandLineRunner.run())
////                .isInstanceOf(IllegalArgumentException.class)
////                .hasMessageContaining("Please ensure that the input file is provided");
////        assertThat(capturedOutput.getOut()).isEmpty();
////    }
//
//
////    @Test
////    void shouldThrowExceptionWhenFileNotFound(CapturedOutput capturedOutput) {
////        when(file.exists()).thenReturn(false);
////
////        assertThatThrownBy(() -> anagramCommandLineRunner.run(file.getAbsolutePath()))
////                .isInstanceOf(IllegalArgumentException.class)
////                .hasMessageContaining("Does not exist");
////
////        assertThat(capturedOutput.getOut()).isEmpty();
////    }
////
////    @Test
////    void shouldPrintFileContentsAndAnagrams(CapturedOutput capturedOutput) throws Exception {
////        final String inputFilePath = "src/test/resources/example1.txt";
////        when(file.exists()).thenReturn(true);
////        when(file.getAbsolutePath()).thenReturn(inputFilePath);
////
////        final List<String> expectedOutput = List.of("abc, bac, cba", "fun, unf");
////
////        anagramCommandLineRunner.run(file.getAbsolutePath());
////
////        final String consoleOutput = capturedOutput.getOut().replaceAll("=================================:\n", "");
////        final List<String> actualOutput = List.of(consoleOutput.split("\n"));
////
////        final String fileContents = Files.readString(new File(inputFilePath).toPath()).trim();
////
////        assertThat(actualOutput).containsExactlyElementsOf(expectedOutput);
////        assertThat(capturedOutput.getOut()).contains(fileContents);
////    }
////
////    @Test
////    void shouldHandleEmptyInputFile(CapturedOutput capturedOutput) throws Exception {
////        final String inputFilePath = "src/test/resources/emptyFile.txt";
////        when(file.exists()).thenReturn(true);
////        when(file.getAbsolutePath()).thenReturn(inputFilePath);
////
////        anagramCommandLineRunner.run(file.getAbsolutePath());
////
////        final String consoleOutput = capturedOutput.getOut().replaceAll("=================================:\n", "");
////
////        assertThat(consoleOutput).isEmpty();
////        assertThat(capturedOutput.getOut()).contains("File contents:\n\n");
////    }
//}
