import org.junit.jupiter.api.Test;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class FileHandlerTest {


    @Test
    public void returnAvailableFileNamesReturnsCipFiles() {
        FileHandler handler = new FileHandler();
        String files = handler.returnAvailableFileNames();

        ArrayList<String> fileNames = new ArrayList<>(Arrays.stream(files.split("\n")).toList());

        assertEquals(2, fileNames.size());
        assertTrue(fileNames.contains("carnivore.cip"));
        assertTrue(fileNames.contains("cointelpro.cip"));
    }

    @Test
    public void returnFileContentsInvalidIDReturnsErrorMessage(){
        Cipher cipherHandler =  mock(Cipher.class);
        FileHandler handler = new FileHandler();

        //id too large
        String text1 = handler.returnFileContents(handler.returnAvailableFiles().length,cipherHandler);

        //id too low
        String text2 = handler.returnFileContents(-1,cipherHandler);

        assertEquals("Invalid fileID", text2);
        assertEquals("Invalid fileID", text1);
    }
    @Test
    public void returnFileContentsReturnsCorrectForCarnivore() throws Exception {
        //Arrange

        FileHandler fileHandler = new FileHandler();
        File[] fileList  = fileHandler.returnAvailableFiles();
        Cipher cipherHandler =  mock(Cipher.class);
        cipherHandler.mapCipherKey("key.txt");

        Path cip = Path.of("data/carnivore.cip");
        Path txt = Path.of("data/carnivore.txt");

        String encrypted = Files.readString(cip);
        String decrypted = Files.readString(txt);

        when(cipherHandler.decipher(encrypted)).thenReturn(decrypted);

        int fileID = FileIndex(fileList,"carnivore.cip");
        String expected  = fileHandler.returnFileContents(fileID, cipherHandler);

        assertTrue(fileID>=0);
        assertEquals(decrypted, expected);


    }

    @Test
    public void returnFileContentsReturnsCorrectForCointelpro() throws Exception {

        FileHandler fileHandler = new FileHandler();
        File[] fileList  = fileHandler.returnAvailableFiles();
        Cipher cipherHandler =  mock(Cipher.class);
        cipherHandler.mapCipherKey("key.txt");

        Path cip = Path.of("data/cointelpro.cip");
        Path txt = Path.of("data/cointelpro.txt");

        String encrypted = Files.readString(cip);
        String decrypted = Files.readString(txt);

        when(cipherHandler.decipher(encrypted)).thenReturn(decrypted);

        int fileID = FileIndex(fileList,"cointelpro.cip");
        String expected  = fileHandler.returnFileContents(fileID, cipherHandler);

        assertTrue(fileID>=0);
        assertEquals(decrypted, expected);
    }

    @Test
    public void returnErrorWhenInvalidFileID() throws Exception {

        FileHandler fileHandler = new FileHandler();
        File[] fileList  = fileHandler.returnAvailableFiles();
        Cipher cipherHandler =  mock(Cipher.class);
        cipherHandler.mapCipherKey("key.txt");

        int fileID_1 = -1;
        int fileID_2 = fileList.length;

        String expected1  = fileHandler.returnFileContents(fileID_1, cipherHandler);
        String expected2  = fileHandler.returnFileContents(fileID_2, cipherHandler);

        assertEquals("Invalid fileID", expected1);
        assertEquals("Invalid fileID", expected2);
    }

    //Helper method to find FileIndex
    private int FileIndex(File[] file, String name){

        for(int i =0; i<file.length;i++){
            if(file[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}
