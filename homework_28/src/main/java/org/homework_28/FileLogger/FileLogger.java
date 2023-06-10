package org.homework_28.FileLogger;

import org.homework_28.FileLogger.enums.LoggingLevel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger {
    private final FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    public void debug(String message) {
        if (isDebugEnabled()) {
            log(message, LoggingLevel.DEBUG);
        }
    }

    public void info(String message) {
        if (isInfoEnabled()) {
            log(message, LoggingLevel.INFO);
        }
    }

    private void log(String message, LoggingLevel loggingLevel) {
        File file = new File(config.getFileName());
        if (isMaxFileSizeExceeded(file)) {
            createNewLogFile(file.getName());
        } else {
            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write("[" + DateTimeUtils.getCurrentTimeAsString() + "][" + loggingLevel + "]" + " Message: " + message + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createNewLogFile(String fileName) {
        File newLogFile = new File(fileName);
        try {
            newLogFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean isDebugEnabled() {
        return config.getLoggingLevel() == LoggingLevel.DEBUG;
    }

    private boolean isInfoEnabled() {
        return config.getLoggingLevel() == LoggingLevel.INFO || config.getLoggingLevel() == LoggingLevel.DEBUG;
    }

    private boolean isMaxFileSizeExceeded(File file) {
        return file.exists() && file.length() >= config.getFileSizeMax();
    }
}
