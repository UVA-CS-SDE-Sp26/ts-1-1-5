import java.io.File;

/**
 * Command Line Utility
 */
import java.io.File;

public class TopSecret {
    private final ProgramControl pc;

    // Normal use
    public TopSecret() {
        this(new ProgramControl());
    }

    // Tests use this
    public TopSecret(ProgramControl pc) {
        this.pc = pc;
    }

    public static void main(String[] args) {
        System.out.print(new TopSecret().run(args));
    }

    public String run(String[] args) {

        if (args.length == 0) {
            return pc.getAvailableFiles();
        }

        if (args.length == 1) {
            try {
                int fileID = verifyFileID(args[0], pc);
                return pc.getFileContents(fileID);
            } catch (IllegalArgumentException e) {
                return e.getMessage();
            } catch (Exception e) {
                return "That file does not exist. Keep in mind all files must be two digits. Examples: 01, 04, 23";
            }
        }

        if (args.length == 2) {
            try {
                int fileID = verifyFileID(args[0], pc);

                if (args[1] == null || args[1].trim().isEmpty()) {
                    return "Invalid input. A key filename is required as the second argument.";
                }

                String keyFile = args[1];
                return pc.getFileContents(fileID, keyFile);

            } catch (IllegalArgumentException e) {
                return e.getMessage();
            } catch (Exception e) {
                return "That file could not be deciphered with the provided key.";
            }
        }

        return "Invalid input: incorrect number of inputs.";
    }

    private static int verifyFileID(String rawArg, ProgramControl pc) {
        int fileID;

        try {
            fileID = Integer.parseInt(rawArg);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid input. All file IDs must be a positive integer.");
        }

        if (fileID <= 0) {
            throw new IllegalArgumentException("Invalid input. All file IDs must be a positive integer.");
        }

        File[] files = pc.getFileHandler().returnAvailableFiles();
        if (files == null || fileID > files.length) {
            throw new IllegalArgumentException(
                    "That file does not exist. Keep in mind all files must be two digits. Examples: 01, 04, 23"
            );
        }

        return fileID; // 1-based
    }
}

