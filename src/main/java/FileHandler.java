import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileHandler{

    public File[] returnAvailableFiles(){
        File folder = new File("data");

        //use .getName() when iterating for names
        return folder.listFiles((dir, name)->name.endsWith("cip"));
    }

    public String returnAvailableFileNames(){
        File[] folders = returnAvailableFiles();

        String fileNames = "";
        for (File folder : folders) {
            fileNames += folder.getName() + "\n";
        }
        return fileNames;
    }

    public String returnFileContents(int fileID, Cipher cipherHandler) {

        File[] folders = returnAvailableFiles();

        if(fileID >= folders.length || fileID<0){
            return "Invalid fileID";
        }
        File fileRequested = folders[fileID];

        // readString() requires try/catch
        try {
            //decrypt step, need method name
            String fileContent = Files.readString(fileRequested.toPath());
            cipherHandler.mapCipherKey("key.txt");

            return cipherHandler.decipher(fileContent);
        }
        catch(IOException e){
            return "Unknow error while reading file";
        }

    }

    public String returnFileContents(int fileID, Cipher cipherHandler, String cipherKey) {

        File[] folders = returnAvailableFiles();

        if(fileID >= folders.length || fileID<0){
            return "Invalid fileID";
        }
        File fileRequested = folders[fileID];

        // readString() requires try/catch
        try {
            //decrypt step, need method name
            String fileContent = Files.readString(fileRequested.toPath());
            cipherHandler.mapCipherKey(cipherKey);

            return cipherHandler.decipher(fileContent);
        }
        catch(IOException e){
            return "Unknow error while reading file";
        }

    }
}
