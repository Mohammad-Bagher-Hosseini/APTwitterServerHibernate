package entities.user;

import entities.exception.email.EmailFormatException;
import entities.exception.password.PasswordFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Verification
{
    public static void verifyEmail(String email) throws EmailFormatException
    {
        String regex1 = "^(.+)@(.+)$";
        String regex2 = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        Pattern pattern = Pattern.compile(regex2);
        Matcher matcher = pattern.matcher(email);

        if(!matcher.matches())
            throw new EmailFormatException("The given email format is incorrect");
    }

    public static void verifyPassword(String password) throws PasswordFormatException
    {
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!^&*+=;:?<>]).{8,20}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);

        if(!matcher.matches())
            throw new PasswordFormatException("The given password format is incorrect");
    }
}
