import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.File;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ProgramControlTest {

    @Mock
    FileHandler fileHandler;

    @InjectMocks
    ProgramControl programControl;

    @Test
    void getAvailableFilesNormalOperation(){
        File[] testFileArray = {new File("test1.txt"), new File("test2.txt"), new File("test3.txt")};
        when(fileHandler.returnAvailableFiles()).thenReturn(testFileArray);
        String output = programControl.getAvailableFiles();
        assertEquals("01 test1.txt\n02 test2.txt\n03 test3.txt", output);
    }
}
