package pro.sky;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String message) {
        super(message);
    }
}
