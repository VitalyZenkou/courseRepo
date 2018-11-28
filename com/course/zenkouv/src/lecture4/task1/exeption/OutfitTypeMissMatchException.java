package lecture4.task1.exeption;

public class OutfitTypeMissMatchException extends RuntimeException {
    public OutfitTypeMissMatchException(String message){
        super(message);
    }
}
