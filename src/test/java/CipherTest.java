import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


/*
Test for one character:
    given "g" expected output is "f"
Test for multiple characters:
    given "bcd" as input, expected output is "abc"
Test for numbers:
    given "a123" as input, expected output is "0Z12"
Test with space and full stop:
    given "Uif eph.", expected output is "The dog."
 */
class CipherTest {

    @Test
    void decipher() throws IOException {
        Cipher cipher = new Cipher();
        cipher.mapCipherKey();
        assertEquals("f",cipher.decipher("g"));
        assertEquals("abc",cipher.decipher("bcd"));
        assertEquals("0Z12",cipher.decipher("a123"));
        assertEquals("The dog.",cipher.decipher("Uif eph."));
    }

}