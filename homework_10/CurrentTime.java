import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentTime {
    public static String time() {
        LocalDateTime localTime = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = localTime.format(timeFormatter);
        return formattedTime;
    }
}
