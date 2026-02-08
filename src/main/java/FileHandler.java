import java.io.File;

public class FileHandler {

    public File[] getAvailableFiles(){
        File[] folder = new File("data").listFiles();
        return folder;
    }

    public String getFileContents(int fileID){return "";}
    public String getFileContents(int fileID, String decryptionKey){return "";}

}
