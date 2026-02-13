import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class IntegrationTests {

    /*
    Same tests as in ProgramControlTest, but without Mockito to simulate other objects behaviors
     */

    @Test
    void getAvailableFilesNormalOperation(){
        ProgramControl pc = new ProgramControl();

        String output = pc.getAvailableFiles();

        assertEquals("01 carnivore.cip\n02 cointelpro.cip\n", output);
    }

    @Test
    void getFileContentsNormalOperation(){
        ProgramControl programControl = new ProgramControl();

        String result = programControl.getFileContents(1);

        assertEquals("Carnivore, later renamed DCS1000, was a system implemented by the Federal Bureau of Investigation (FBI) that was\ndesigned to monitor email and electronic communications. It used a customizable packet sniffer that could monitor all\nof a target user's Internet traffic. Carnivore was implemented in October 1997. By 2005 it had been replaced with\nimproved commercial software.", result);
    }

    @Test
    void getFileContentsInvalidID(){
        ProgramControl programControl = new ProgramControl();

        String result = programControl.getFileContents(-1);
        assertEquals("Invalid fileID", result);
    }

    @Test
    void getFileContentsWithDecrpytionKey(){
        ProgramControl programControl = new ProgramControl();

        String cipherKeyFilePath = "ciphers/key.txt"; //using regular key for testing purposes


        String result = programControl.getFileContents(1, cipherKeyFilePath);

        assertEquals("Carnivore, later renamed DCS1000, was a system implemented by the Federal Bureau of Investigation (FBI) that was\ndesigned to monitor email and electronic communications. It used a customizable packet sniffer that could monitor all\nof a target user's Internet traffic. Carnivore was implemented in October 1997. By 2005 it had been replaced with\nimproved commercial software.", result);
    }


}
