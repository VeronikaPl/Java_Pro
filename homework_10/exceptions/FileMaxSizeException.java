package exceptions;

public class FileMaxSizeException extends RuntimeException {
    public FileMaxSizeException(String message) {
        super(message);
    }
}
