import exceptions.FileMaxSizeException;

import java.io.IOException;

public class FileMain {
    public static void main(String[] args) throws IOException {
        FileLoggerConfiguration config = FileLoggerConfigurationLoader.load("configurationFile.txt");
        FileLogger fileLogger = new FileLogger(config);

        try {
            fileLogger.debug("Second message");
        } catch (FileMaxSizeException e) {
            throw new RuntimeException(e);
        }
    }
}
