package sdacademy.models;

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

    public Admin(String login, String password) {
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
