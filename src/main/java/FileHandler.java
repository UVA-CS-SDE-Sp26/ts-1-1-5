import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler{

    public File[] returnAvailableFiles(){
        File folder = new File("data");

        //use .getName() when iterating for names
        File[] textFiles = folder.listFiles((dir,name)->name.endsWith("txt"));

        return textFiles;
    }
    public String getFileContents(int fileID) throws IOException {
        //File[] folder = getAvailableFiles();
        String file = getFileContents(fileID, Files.readString(Path.of("cipher/key.txt")));

        if(file != null){
            return file;
        }
        return "Invalid File ID!";

       }
    public String getFileContents(int fileID, String decryptionKey){return "";}
}
