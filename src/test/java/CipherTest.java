import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.io.IOException;


import static org.junit.jupiter.api.Assertions.*;


class CipherTest {
    @Test
    void mapCipherKey() {
        Cipher cipher = new Cipher();
        assertThrows(FileNotFoundException.class, () -> cipher.mapCipherKey("abc.txt"));
        assertThrows(MissingLinesException.class, () -> cipher.mapCipherKey("empty_key.txt"));
        assertThrows(DifferentLengthException.class, () -> cipher.mapCipherKey("unequal_lines.txt"));
        assertThrows(DuplicateCharacterException.class, () -> cipher.mapCipherKey("duplicate.txt"));
    }
    @Test
    void decipher() throws IOException {
        Cipher cipher = new Cipher();
        cipher.mapCipherKey("key.txt");
        assertEquals("f",cipher.decipher("g"));
        assertEquals("abc",cipher.decipher("bcd"));
        assertEquals("0Z12",cipher.decipher("a123"));
        assertEquals("The dog.",cipher.decipher("Uif eph."));

        //Test with different key file
        cipher.mapCipherKey("new_key.txt");
        assertEquals("Cat",cipher.decipher("Ecv"));



    }



}