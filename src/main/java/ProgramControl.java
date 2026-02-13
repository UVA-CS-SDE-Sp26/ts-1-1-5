import java.io.File;

public class ProgramControl {
    private FileHandler fileHandler;
    private Cipher cipherHandler;

    public ProgramControl(){
        this.fileHandler = new FileHandler();
        this.cipherHandler = new Cipher();
    }

    public String getAvailableFiles(){
        return getAvailableFiles(fileHandler);
    }

    private String getAvailableFiles(FileHandler fileHandler){

        File[] files = fileHandler.returnAvailableFiles();

        if(files.length == 0){
            return "No available files";
        }

        String availableFilesString = "";

        for (int i = 0; i < files.length; i++) {
            if(i+1<10) {
                availableFilesString = availableFilesString + "0" + (i+1) + " " + files[i].getName() + "\n";
            }
            else{
                availableFilesString = availableFilesString + (i+1) + " " + files[i].getName() + "\n";
            }
        }
        return availableFilesString;
    }

    //helper method
    public String getFileContents(int fileID){
        //subtract 1 from fileID because FileHandler treats it as an array index
        return getFileContents(fileID-1, cipherHandler, fileHandler);
    }

    private String getFileContents(int fileID, Cipher cipherHandler, FileHandler fileHandler){
        return fileHandler.returnFileContents(fileID, cipherHandler);
    }

    //helper method
    public String getFileContents(int fileID, String decryptionKey){
        //subtract 1 from fileID because FileHandler treats it as an array index
        return getFileContents(fileID, cipherHandler, fileHandler, decryptionKey);
    }

    private String getFileContents(int fileID, Cipher cipherHandler, FileHandler fileHandler, String decryptionKey){
        return fileHandler.returnFileContents(fileID, cipherHandler, decryptionKey);
    }

    public Cipher getCipherHandler() {
        return cipherHandler;
    }

    public void setCipherHandler(Cipher cipherHandler) {
        this.cipherHandler = cipherHandler;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public void setFileHandler(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

}
