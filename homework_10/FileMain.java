import enums.LoggingLevel;

public class FileMain {
    public static void main(String[] args) {
        FileLoggerConfiguration config = new FileLoggerConfiguration("test.txt", LoggingLevel.INFO, 1024, ".txt");
        FileLogger fileLogger = new FileLogger(config);
        fileLogger.debug("Debug message");
        fileLogger.info("Info message");

        FileLoggerConfiguration loadConfig = FileLoggerConfigurationLoader.load("configurationFile.txt");
        fileLogger = new FileLogger(loadConfig);
        fileLogger.debug("Load DEBUG message");
        fileLogger.info("Load INFO message");
    }
}
