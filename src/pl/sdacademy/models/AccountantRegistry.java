package pl.sdacademy.models;

import pl.sdacademy.exceptions.AccountantNotFoundException;

import java.util.ArrayList;

public class AccountantRegistry {
    public static AccountantRegistry instance = null;

    public static AccountantRegistry getInstance() {
        if (instance == null) {
            instance = new AccountantRegistry();
        }
        return instance;
    }

    // TODO login i password z pliku

    private ArrayList<Accountant> accountants;

    public AccountantRegistry() {
        this.accountants = new ArrayList<>();

        this.accountants.add(new Accountant("jan", "123"));
        this.accountants.add(new Accountant("majka", "123"));
    }


    public Accountant findAccountant(String login, String password) throws AccountantNotFoundException {
        for (Accountant accountant : accountants) {
            if (accountant.getLogin().equals(login) && accountant.getPassword().equals(password)) {
                return accountant;
            }

        }
        throw new AccountantNotFoundException();
    }
}


