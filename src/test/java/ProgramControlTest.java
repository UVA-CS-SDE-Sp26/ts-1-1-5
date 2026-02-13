import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import static org.mockito.Mockito.*;


public class ProgramControlTest {

    ProgramControl programControl = new ProgramControl();

    @Test
    void getAvailableFilesNormalOperation(){
        FileHandler fileHandler = mock(FileHandler.class);

        File[] testFileArray = {new File("test1.txt"), new File("test2.txt"), new File("test3.txt")};

        when(fileHandler.returnAvailableFiles()).thenReturn(testFileArray);
        programControl.setFileHandler(fileHandler); //normally not necessary as FileHandler object is a private attribute of ProgramCongrol object, but needed for Mockito
        String output = programControl.getAvailableFiles();
        assertEquals("01 test1.txt\n02 test2.txt\n03 test3.txt\n", output);
    }

    @Test
    void getAvailableFilesEmptyFileArray(){
        FileHandler fileHandler = mock(FileHandler.class);
        File[] testFileArray = {};
        when(fileHandler.returnAvailableFiles()).thenReturn(testFileArray);
        programControl.setFileHandler(fileHandler);
        String output = programControl.getAvailableFiles();
        assertEquals("No available files", output);
    }

    @Test
    void getFileContentsNormalOperation(){
        FileHandler fileHandler = mock(FileHandler.class);
        programControl.setFileHandler(fileHandler);

        when(fileHandler.returnFileContents(1, programControl.getCipherHandler())).thenReturn("Contents of file 1");

        String result = programControl.getFileContents(1);

        assertEquals("Contents of file 1", result);
    }

    @Test
    void getFileContentsInvalidID(){
        FileHandler fileHandler = mock(FileHandler.class);
        programControl.setFileHandler(fileHandler);
        when(fileHandler.returnFileContents(-1, programControl.getCipherHandler())).thenReturn("Invalid fileID");

        String result = programControl.getFileContents(-1);
        assertEquals("Invalid fileID", result);
    }

    @Test
    void getFileContentsWithDecrpytionKey(){
        String cipherKey = "cdefghijklmnopqrstuvwxyzabCDEFGHIJKLMNOPQRSTUVWXYZAB2345678901";
        FileHandler fileHandler = mock(FileHandler.class);
        Cipher cipherHandler = mock(Cipher.class);

        programControl.setFileHandler(fileHandler);
        programControl.setCipherHandler(cipherHandler);

        when(fileHandler.returnFileContents(1, programControl.getCipherHandler(), cipherKey)).thenReturn("Decrypted contents of file 1");

        String result = programControl.getFileContents(1, cipherKey);

        assertEquals("Decrypted contents of file 1", result);
    }
}
