package pl.sdacademy.models;

import java.io.Serializable;

/**
 * Created by marcin on 13.12.2017.
 */
public class Accountant implements Serializable{
    private String login;
    private String password;

    public Accountant (String login, String password) {
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
