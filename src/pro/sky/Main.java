package pro.sky;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(login("123Sf","1233fFfcc_s23FV","1233fFfcc_s23FV"));
    }

    public static Boolean login(String login, String password, String confirmPassword){
        try {
            return Checker.checkLogin(login)&&Checker.checkPassword(password,confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
        }
        return false;
    }



}
