import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManagerIO {
    private static final Logger LOGGER = Logger.getLogger(FileManagerIO.class.getName());
    private String currDirectory;

    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            currDirectory = System.getProperty("user.dir");

            while (true) {
                LOGGER.log(Level.INFO, currDirectory);
                String commandLine = bufferedReader.readLine();
                String[] command = commandLine.split("\\s+");

                switch (command[0]) {
                    case "cd": {
                        changeDirectory(command);
                        break;
                    }
                    case "cp": {
                        copy(command);
                        break;
                    }
                    case "ls": {
                        localStorage();
                        break;
                    }
                    case "pwd": {
                        printWorkingDirectory();
                        break;
                    }
                    default:
                        LOGGER.log(Level.WARNING, "Unknown command: {0}", command);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void changeDirectory(String[] command) {
        if (command.length <= 1) {
            LOGGER.log(Level.WARNING, "Use: cd <directory>");
            return;
        }

        String path = command[1];
        File file;
        if (path.equals("..")) {
            file = new File(currDirectory);
            currDirectory = file.getParent();
        } else if (path.startsWith("/")) {
            currDirectory = path;
        } else {
            currDirectory += "/" + path;
        }

        file = new File(currDirectory);
        if (!file.isDirectory() || !file.exists()) {
            LOGGER.log(Level.WARNING, "Directory " + currDirectory + " doesn't exist");
            currDirectory = System.getProperty("user.dir");
        }
    }

    private void copy(String[] command) {
        if (command.length <= 2) {
            LOGGER.log(Level.WARNING, "Use: cp <source> <destination>");
            return;
        }

        File sourceFile = new File(command[1]);
        File destinationFile = new File(command[2]);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            LOGGER.log(Level.WARNING, "Invalid source to file");
            return;
        }
        if (destinationFile.exists()) {
            LOGGER.log(Level.WARNING, "Destination file already exist");
            return;
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationFile))) {
            String resultLine;
            while ((resultLine = bufferedReader.readLine()) != null) {
                bufferedWriter.write(resultLine);
            }
            LOGGER.log(Level.INFO, "Copy successful");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void localStorage() {
        File storage = new File(currDirectory);
        File[] files = storage.listFiles();

        if (files != null) {
            for (File file : files) {
                LOGGER.log(Level.INFO, file.getName());
            }
        }
    }

    private void printWorkingDirectory() {
        LOGGER.log(Level.INFO, "Absolute path: " + currDirectory);
    }
}
