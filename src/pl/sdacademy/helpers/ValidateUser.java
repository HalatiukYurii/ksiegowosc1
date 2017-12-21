package pl.sdacademy.helpers;

import pl.sdacademy.exceptions.WrongLoginException;
import pl.sdacademy.exceptions.WrongPasswordException;


public class ValidateUser {

    public static void validatePassword (String password) throws WrongPasswordException{
        if(password.length() < 6 || password.matches("//s")){
            throw new WrongPasswordException("Nieprawidłowe hasło! Hasło powinno zawierać conajmniej 4 znaki i nie zawierać spacji.");
        }
    }

    public static void validateLogin (String login) throws WrongLoginException{
        if (login.length() < 4 || login.contains(" ")){
            throw new WrongLoginException("Nieprawidłowy login! Login powinnien zawierać conajmniej 6 znaków i nie zawierać spacji.");
        }
    }
}
