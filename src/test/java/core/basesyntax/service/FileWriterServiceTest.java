package core.basesyntax.service;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Test;

public class FileWriterServiceTest {
    @Test
    public void writeToFile_Ok() {
        new FileWriterServiceImpl().writeToFile("Hello, this is test sentence.",
                "src/test/resources/test_report.csv");
        String actual = "";
        try {
            actual = String.join("",
                    Files.readAllLines(Path.of("src/test/resources/test_report.csv")));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file.", e);
        }
        String expected = "Hello, this is test sentence.";
        assertEquals(expected, actual);
    }
}
