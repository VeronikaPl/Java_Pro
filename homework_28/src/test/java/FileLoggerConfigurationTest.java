import org.homework_28.FileLogger.FileLoggerConfiguration;
import org.homework_28.FileLogger.enums.LoggingLevel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileLoggerConfigurationTest {
    private FileLoggerConfiguration loggerConfiguration;

    @BeforeEach
    public void setup() {
    }

    @AfterEach
    public void tearDown() {
        this.loggerConfiguration = null;
    }

    @Test
    public void whenConstructorCalledAndFileNameIsNullOrEmptyThrowExceptionWithASpecificMessage() {
        Throwable exception = assertThrows(NullPointerException.class,
                () -> new FileLoggerConfiguration(null, LoggingLevel.DEBUG, 500, "txt"));

        assertEquals("Value of file's name or format are 'null', please check parameters", exception.getMessage());
    }

    @Test
    public void whenConstructorCalledAndFileSizeEqualsZeroOrLessThenThrowException() {
        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new FileLoggerConfiguration("configurationFile.txt", LoggingLevel.DEBUG, 0, "txt"));

        assertEquals("Invalid value of file's size! It can't be negative", exception.getMessage());
    }
}
