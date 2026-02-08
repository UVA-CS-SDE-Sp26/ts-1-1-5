public class ProgramControl {
    private String encryptionKey;

    public ProgramControl(){
        this.encryptionKey = "";
    }

    public ProgramControl(String encryptionKey){
        this.encryptionKey = encryptionKey;
    }
    public String getAvailableFiles(){return "";}
    public String getFileContents(int fileID){return "";}
    public String getFileContents(int fileID, String decryptionKey){return "";}


    public String getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(String encryptionKey) {
        this.encryptionKey = encryptionKey;
    }
}
