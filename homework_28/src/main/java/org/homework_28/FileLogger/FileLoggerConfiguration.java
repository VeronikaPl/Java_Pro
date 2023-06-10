package org.homework_28.FileLogger;

import org.homework_28.FileLogger.enums.LoggingLevel;

public class FileLoggerConfiguration {
    private String fileName;
    private LoggingLevel loggingLevel;
    private long fileSizeMax;
    private String fileFormat;

    public FileLoggerConfiguration(String fileName, LoggingLevel loggingLevel, long fileSizeMax, String fileFormat) {
        if (fileName == null || fileFormat == null) {
            throw new NullPointerException("Value of file's name or format are 'null', please check parameters");
        }
        if (fileSizeMax <= 0) {
            throw new IllegalArgumentException("Invalid value of file's size! It can't be negative");
        }
        this.fileName = fileName;
        this.loggingLevel = loggingLevel;
        this.fileSizeMax = fileSizeMax;
        this.fileFormat = fileFormat;
    }

    public String getFileName() {
        return fileName;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getFileSizeMax() {
        return fileSizeMax;
    }

    public String getFileFormat() {
        return fileFormat;
    }
}
