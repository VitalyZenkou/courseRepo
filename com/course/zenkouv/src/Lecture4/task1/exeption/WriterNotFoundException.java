package Lecture4.task1.exeption;

public class WriterNotFoundException extends RuntimeException {
    public WriterNotFoundException(String message) {
        super(message);
    }
}
