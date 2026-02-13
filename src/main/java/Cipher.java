import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Cipher {
    private Map<Character, Character> cipherMap = new HashMap<>();

    public void mapCipherKey(String keyFile) throws IOException {
        cipherMap.clear();
        File file = new File("ciphers/" + keyFile);
        if (!file.exists()) {
            throw new FileNotFoundException("Cipher key file not found: " + "ciphers/"+ keyFile +". Make sure you have a valid cipher key file in ciphers folder. ");
        }

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line1 = br.readLine(); // Original
            String line2 = br.readLine(); // Cipher

            if (line1 == null || line2 == null) {
                throw new MissingLinesException("Expect 2 lines in key file.");

            } else if (line1.length() != line2.length()) {
                throw new DifferentLengthException("Expect length of line 2 to be same as length of line 1 (" + line1.length() + " characters).");
            }

            for (int i = 0; i < line2.length(); i++) {
                char originalChar = line1.charAt(i);
                char cipherChar = line2.charAt(i);

                if (cipherMap.containsKey(cipherChar)) {
                    throw new DuplicateCharacterException("Duplicate character '" + cipherChar + "' found in second line.");
                }
                if (cipherMap.containsValue(originalChar)) {
                    throw new DuplicateCharacterException("Duplicate character '" + originalChar + "' found in first line.");
                }
                cipherMap.put(cipherChar, originalChar);

            }
        }
    }

    public String decipher(String cipheredText) {
        String decipheredText = "";
        for (int i = 0; i < cipheredText.length(); i++) {
            char cipheredChar = cipheredText.charAt(i);
            decipheredText += cipherMap.getOrDefault(cipheredChar,cipheredChar);
        }
        return decipheredText;
    }
}
