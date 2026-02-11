import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHandler{

    private File[] returnAvailableFiles(){
        File folder = new File("data");

        //use .getName() when iterating for names
        File[] textFiles = folder.listFiles((dir,name)->name.endsWith("txt"));

        return textFiles;
    }

    public String returnAvailableFileNames(){
        File[] folders = returnAvailableFiles();

        String fileNames = "";
        for(int i =0; i<folders.length; i++){
            fileNames+= folders[i].getName() + "\n";
        }
        return fileNames;
    }
}
