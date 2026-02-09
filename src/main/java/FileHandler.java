import java.io.File;

public class FileHandler {

    public File[] getAvailableFiles(){
        File folder = new File("data");

        //use .getName() when iterating for names
        File[] textFiles = folder.listFiles((dir,name)->name.endsWith("txt"));

        return textFiles;
    }

    public String getFileContents(int fileID){return "";}
    public String getFileContents(int fileID, String decryptionKey){return "";}

}
