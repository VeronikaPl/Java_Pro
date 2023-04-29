import java.io.*;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManagerNIO {
    private static final Logger LOGGER = Logger.getLogger(FileManagerNIO.class.getName());
    private Path currDirectory = Paths.get("").toAbsolutePath();

    public void run() {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            currDirectory = Path.of(System.getProperty("user.dir"));

            while (true) {
                LOGGER.log(Level.INFO, currDirectory.toString());
                String commandLine = bufferedReader.readLine();
                String[] command = commandLine.split("\\s+");

                switch (command[0]) {
                    case "cd" -> changeDirectory(command);
                    case "cp" -> copy(command);
                    case "ls" -> localStorage();
                    case "pwd" -> printWorkingDirectory();
                    default -> LOGGER.log(Level.WARNING, "Unknown command: {0}", command);
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
        if (path.equals("..")) {
            currDirectory = currDirectory.getParent();
        } else {
            currDirectory = currDirectory.resolve(path).normalize();
        }

        if (!Files.exists(currDirectory)) {
            LOGGER.log(Level.WARNING, "Directory " + currDirectory + " doesn't exist");
            currDirectory = Path.of(System.getProperty("user.dir"));
        }
    }

    private void copy(String[] command) {
        if (command.length <= 2) {
            LOGGER.log(Level.WARNING, "Use: cp <source> <destination>");
            return;
        }

        Path sourceFile = Paths.get(command[1]);
        Path destinationFile = Paths.get(command[2]);

        if (!Files.exists(sourceFile)) {
            LOGGER.log(Level.WARNING, "Invalid source to file");
            return;
        }
        if (Files.exists(destinationFile)) {
            LOGGER.log(Level.WARNING, "Destination file already exist");
            return;
        }

        try {
            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            LOGGER.log(Level.INFO, "Copy successful");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void localStorage() {
        try (DirectoryStream<Path> files = Files.newDirectoryStream(currDirectory)) {
            for (Path file : files) {
                LOGGER.log(Level.INFO, file.getFileName().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void printWorkingDirectory() {
        LOGGER.log(Level.INFO, "Absolute path: " + currDirectory.toAbsolutePath());
    }
}