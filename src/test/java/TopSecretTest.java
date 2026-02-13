import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.io.File;

import org.junit.jupiter.api.Test;

public class TopSecretTest {

    @Test
    void testNoArgumentsGiven() {
        ProgramControl pc = mock(ProgramControl.class);
        when(pc.getAvailableFiles()).thenReturn("01 filea.txt\n02 fileb.txt\n");

        TopSecret testInterface = new TopSecret(pc);

        String output = testInterface.run(new String[]{});

        assertTrue(output.contains("filea.txt"), "Should list available files");
        verify(pc).getAvailableFiles();
    }

    @Test
    void oneArgumentTest() {
        ProgramControl pc = mock(ProgramControl.class);
        FileHandler fh = mock(FileHandler.class);
        when(pc.getFileHandler()).thenReturn(fh);
        when(fh.returnAvailableFiles()).thenReturn(new File[]{ new File("filea.txt") });

        when(pc.getFileContents(1)).thenReturn("default key");

        TopSecret testInterface = new TopSecret(pc);

        String output = testInterface.run(new String[]{"01"});

        assertTrue(output.contains("default key"), "Should display file contents using default key");
        verify(pc).getFileContents(1);
    }

    @Test
    void twoArgumentTest() {
        ProgramControl pc = mock(ProgramControl.class);
        FileHandler fh = mock(FileHandler.class);
        when(pc.getFileHandler()).thenReturn(fh);
        when(fh.returnAvailableFiles()).thenReturn(new File[]{ new File("filea.txt") });
        when(pc.getFileContents(1, "newkey.txt")).thenReturn("new key");

        TopSecret testInterface = new TopSecret(pc);

        String output = testInterface.run(new String[]{"01", "newkey.txt"});

        assertTrue(output.contains("new key"), "Should display file contents using alternate key");
        verify(pc).getFileContents(1, "newkey.txt");
    }
}
