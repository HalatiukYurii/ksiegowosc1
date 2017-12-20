package pl.sdacademy.models;

import pl.sdacademy.exceptions.DuplicateFoundException;
import pl.sdacademy.exceptions.WrongLoginException;
import pl.sdacademy.exceptions.WrongPasswordException;
import pl.sdacademy.helpers.ValidateUser;

import java.io.Serializable;

/**
 * Created by marcin on 13.12.2017.
 */
public class Admin implements Serializable {
    private String login;
    private String password;
    ValidateUser validateUser;
    public Admin(String login, String password) {
        try{
            validateUser.validateLogin(login);
        } catch (WrongLoginException e){
            //System.out.println("Nieprawidłowy login! Login powinien zawierać conajmniej 6 znaków i nie zawierać spacji.");
        }

        try{
            validateUser.validatePassword(password);
        } catch (WrongPasswordException e){
            e.getMessage();
           // System.out.println("Nieprawidłowe hasło! Hasło powinno zawierać conajmniej 4 znaki i nie zawierać spacji.");
        }

        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
