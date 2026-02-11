import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {


    @Test
    public void returnAvailableFilesReturnsTextFiles() {
        FileHandler handler = new FileHandler();
        File[] files = handler.returnAvailableFiles();

        ArrayList<String> fileNames = new ArrayList<>(Arrays.stream(files).map(File::getName).toList());

        assertEquals(2, fileNames.size());
        assertTrue(fileNames.contains("carnivore.txt"));
        assertTrue(fileNames.contains("cointelpro.txt"));
    }
}
