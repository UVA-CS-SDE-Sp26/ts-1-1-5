import java.io.File;
import java.util.ArrayList;

public class ProgramControl {
    private String encryptionKey;

    public ProgramControl(){
        this.encryptionKey = "";
    }
    public ProgramControl(String encryptionKey){
        this.encryptionKey = encryptionKey;
    }

    public String getAvailableFiles(){
        FileHandler fileHandler = new FileHandler();
        return "";
    }

    public String getFileContents(int fileID){
        return "";
    }

    public String getFileContents(int fileID, String decryptionKey){
        return "";
    }


    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }
}
