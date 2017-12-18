package pl.sdacademy.models;

import pl.sdacademy.exceptions.AccountantNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccountantRegistry implements Serializable{
    public static AccountantRegistry instance = null;
    final private String filename = "data/accountants.dat";
    public static AccountantRegistry getInstance() {
        if (instance == null) {
            instance = new AccountantRegistry();
        }
        return instance;
    }

    // TODO login i password z pliku

    private ArrayList<Accountant> accountants = new ArrayList<>();

    private AccountantRegistry() {
        this.accountants.add(new Accountant("jan", "123"));
        this.accountants.add(new Accountant("majka", "123"));
    }

    public Accountant findAccountant(String login, String password) throws AccountantNotFoundException {
        for (Accountant accountant : accountants) {
            if (accountant.getLogin().equals(login) &&
                    accountant.getPassword().equals(password)) {
                return accountant;
            }
        }
        throw new AccountantNotFoundException();
    }

    public Accountant findAccountantByLogin(String login) throws AccountantNotFoundException{
        for(Accountant accountant: this.accountants){
            if(accountant.getLogin().equals(login)){
                return accountant;
            }
        }
        throw new AccountantNotFoundException();
    }

    public void addAccountantAccount(String login, String password){
        this.accountants.add(new Accountant(login, password));
    }

    public void removeAccountantAccount(Accountant accountant){
        accountants.remove(accountant);
    }
    public List<Accountant> getAccountant() {
        return this.accountants;
    }

}


