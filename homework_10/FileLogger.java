import enums.LoggingLevel;
import exceptions.FileMaxSizeException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {
    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void writeInFile(String message, LoggingLevel loggingLevel) throws FileMaxSizeException, IOException {
        File file = new File(config.getFileName());

        if (file.exists() && file.length() >= config.getFileSizeMax()) {
            createNewLogFile(file.getName());
            throw new FileMaxSizeException("You reached max size of file: %d in '%s'. Size of your file: %d"
                    .formatted(config.getFileSizeMax(), config.getFileName(), file.length()));
        } else {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("[" + CurrentTime.time() + "][" + loggingLevel + "]" + " Message: " + message + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createNewLogFile(String fileName) throws IOException {
        String newFileName = fileName;
        File newLogFile = new File(newFileName);
        newLogFile.createNewFile();
    }

    public void debug(String message) throws IOException {
        writeInFile(message, LoggingLevel.DEBUG);
    }

    public void info(String message) throws IOException {
        writeInFile(message, LoggingLevel.INFO);
    }
}
