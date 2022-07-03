package pro.sky;

public class WrongLoginException extends Exception{
    public WrongLoginException(String message) {
        super(message);
    }
}
