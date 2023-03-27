import enums.LoggingLevel;

import java.io.File;
import java.io.IOException;

public class FileLoggerConfiguration {
    private String fileName;
    private LoggingLevel loggingLevel;
    private long fileSizeMax;
    private String fileFormat;

    public FileLoggerConfiguration(String fileName, LoggingLevel loggingLevel, long fileSizeMax, String fileFormat) {
        this.fileName = fileName;
        this.loggingLevel = loggingLevel;
        this.fileSizeMax = fileSizeMax;
        this.fileFormat = fileFormat;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    public long getFileSizeMax() {
        return fileSizeMax;
    }

    public void setFileSizeMax(long fileSizeMax) {
        this.fileSizeMax = fileSizeMax;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public static void loadTextToFile(String message) throws IOException {
        FileLoggerConfiguration config = new FileLoggerConfigurationLoader().load("D:/Courses/Hillel IT school/Java/Java_Pro/homework_10/test.txt");
        FileLogger fileLogger = new FileLogger(config);
        if (config.getLoggingLevel() == LoggingLevel.DEBUG) {
            fileLogger.debug(message);
        }
        fileLogger.info(message);
    }
}
