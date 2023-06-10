import org.homework_28.FileLogger.FileLoggerConfiguration;
import org.homework_28.FileLogger.FileLoggerConfigurationLoader;
import org.homework_28.FileLogger.enums.LoggingLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FileLoggerConfigurationLoaderTest {
    private FileLoggerConfigurationLoader fileLoader;

    @BeforeEach
    public void setup() {
        this.fileLoader = new FileLoggerConfigurationLoader();
    }

    @AfterEach
    public void tearDown() {
        this.fileLoader = null;
    }

    @Test
    public void whenPerformLoaderConfigurationThenReturnValidFileLoggerConfiguration() {
        FileLoggerConfiguration configuration = FileLoggerConfigurationLoader.load("src/test/resources/configurationFile.txt");

        assertNotNull(configuration);
        assertEquals("test", configuration.getFileName());
        assertEquals(LoggingLevel.DEBUG, configuration.getLoggingLevel());
        assertEquals(500, configuration.getFileSizeMax());
        assertEquals("txt", configuration.getFileFormat());
    }
}
