import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtils {
    public DateTimeUtils() {
    }

    public static String getCurrentTimeAsString() {
        String pattern = "HH:mm:ss-dd.MM.yyyy";
        LocalDateTime localTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern(pattern);
        return localTime.format(timeFormatter);
    }
}
