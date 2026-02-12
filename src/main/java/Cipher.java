import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Cipher {
    private Map<Character, Character> cipherMap = new HashMap<>();
    public void mapCipherKey() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("ciphers/key.txt"));

        String line1 = br.readLine(); // Original characters
        String line2 = br.readLine(); // Cipher characters
        br.close();

        for (int i = 0; i < line2.length(); i++) {
            cipherMap.put(line2.charAt(i), line1.charAt(i));
        }
    }
    public String decipher(String cipheredText) {
        String decipheredText = "";

        for (int i = 0; i < cipheredText.length(); i++) {
            char cipheredChar = cipheredText.charAt(i);

            if (cipherMap.containsKey(cipheredChar)) {
                decipheredText += cipherMap.get(cipheredChar);
            } else {
                decipheredText += cipheredChar;  // keep original if not in map
            }
        }


        return decipheredText;
    }
}
