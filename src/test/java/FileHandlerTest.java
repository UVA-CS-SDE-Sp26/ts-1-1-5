import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {


    @Test
    public void returnAvailableFilesReturnsTextFiles() {
        FileHandler handler = new FileHandler();
        String files = handler.returnAvailableFileNames();

        ArrayList<String> fileNames = new ArrayList<>(Arrays.stream(files.split("\n")).toList());

        assertEquals(2, fileNames.size());
        assertTrue(fileNames.contains("carnivore.txt"));
        assertTrue(fileNames.contains("cointelpro.txt"));
    }
}
