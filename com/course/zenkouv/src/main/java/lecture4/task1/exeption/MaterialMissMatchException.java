package lecture4.task1.exeption;

public class MaterialMissMatchException extends RuntimeException {
    public MaterialMissMatchException(String message) {
        super(message);
    }
}
