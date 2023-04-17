import enums.LoggingLevel;

import java.io.*;

public class FileLoggerConfigurationLoader {
    public static FileLoggerConfiguration load(String filePath) {
        String pathToFile = null;
        LoggingLevel loggingLevel = null;
        long maxSize = 0;
        String format = null;

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                String[] configParts = line.split(": ");
                String value = configParts[1];
                switch (configParts[0]) {
                    case "FILE": {
                        pathToFile = value;
                        break;
                    }
                    case "LEVEL": {
                        loggingLevel = LoggingLevel.valueOf(value);
                        break;
                    }
                    case "MAX-SIZE": {
                        maxSize = Long.parseLong(value);
                        break;
                    }
                    case "FORMAT": {
                        format = value;
                        break;
                    }
                    default: {
                        throw new IllegalArgumentException("Parameter " + configParts[0] + " are invalid");
                    }
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new FileLoggerConfiguration(pathToFile, loggingLevel, maxSize, format);
    }
}
