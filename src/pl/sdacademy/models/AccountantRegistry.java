package pl.sdacademy.models;

import java.util.ArrayList;

public class AccountantRegistry {
    public static AccountantRegistry instance = null;

    public static AdminRegistry getInstance() {
        if (instance == null) {
            instance = new AccountantRegistry();
        }
        return instance;
    }

    private ArrayList<Accountant>

}


