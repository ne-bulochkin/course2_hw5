package pro.sky;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Checker {

    public static boolean checkLogin(String login) throws WrongLoginException {
        if(login.length()==0){
            throw new IllegalArgumentException("Логин не может быть пустой!");
        } else if(login.length()>20){
            throw new WrongLoginException("Логин не может быть более 20 символов!");
        } else if(!isValid(login)){
            throw new WrongLoginException("Логин может содержать только латинские буквы и цифры и нижнее подчеркивание");
        }
        return true;
    }

    public static boolean checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if(password.length()==0){
            throw new IllegalArgumentException("Пароль не может быть пустой!");
        } else if(password.length()>=20){
            throw new WrongPasswordException("Пароль не может быть более 20 символов");
        } else if(!isValid(password)){
            throw new WrongPasswordException("Пароль может содержать только латинские буквы и цифры и нижнее подчеркивание");
        } else if(!confirmPassword.equals(password)){
            throw new WrongPasswordException("Введенные пароли не совпадают");
        }
        return true;
    }

    private static boolean isValid(final String data) {
        return data.matches("^[a-zA-Z0-9]([_]|[a-zA-Z0-9])+$");
    }
}
