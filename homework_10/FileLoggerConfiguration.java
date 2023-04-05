import enums.LoggingLevel;

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
        if (fileName == null || fileFormat == null) {
            throw new NullPointerException("Value of file's name or format are 'null', please check parameters");
        }
        if (fileSizeMax < 0) {
            throw new IllegalArgumentException("Invalid value of file's size! It can't be negative");
        }
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
}
