package pro.sky;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static final String USERNAME_PATTERN = "^[a-zA-Z0-9]([_]|[a-zA-Z0-9])+$";
    public static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

    public static void main(String[] args) {
	// write your code here
        System.out.println(login("AssWsss_223Ad__zx12","1233fFfcc_s23FV","1233fFfcc_s23FV"));
    }

    public static Boolean login(String login, String password, String confirmPassword){
        try {
            return checkLogin(login)&&checkPassword(password,confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkLogin(String login) throws WrongLoginException {
        if(login.length()==0){
            throw new NullPointerException("Логин не может быть пустой!");
        } else if(login.length()>20){
            throw new WrongLoginException("Логин не может быть более 20 символов!");
        } else if(!isValid(login)){
            throw new WrongLoginException("Логин может содержать только латинские буквы и цифры и нижнее подчеркивание");
        }
        return true;
    }

    public static boolean checkPassword(String password, String confirmPassword) throws WrongPasswordException {
        if(password.length()==0){
            throw new NullPointerException("Логин не может быть пустой!");
        } else if(password.length()>=20){
            throw new WrongPasswordException("");
        } else if(!isValid(password)){
            throw new WrongPasswordException("Пароль может содержать только латинские буквы и цифры и нижнее подчеркивание");
        } else if(!confirmPassword.equals(password)){
            throw new WrongPasswordException("Введенные пароли не совпадают");
        }
        return true;
    }

    public static boolean isValid(final String data) {
        Matcher matcher = pattern.matcher(data);
        return matcher.matches();
    }

}
