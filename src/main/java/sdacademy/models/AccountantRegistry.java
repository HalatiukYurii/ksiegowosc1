package sdacademy.models;

import sdacademy.exceptions.AccountantNotFoundException;
import sdacademy.exceptions.DuplicateFoundException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AccountantRegistry implements Serializable {
    public static AccountantRegistry instance = null;
    final private String filename = "data/accountants.dat";

    public static AccountantRegistry getInstance() {
        if (instance == null) {
            instance = new AccountantRegistry();
        }
        return instance;
    }

    private ArrayList<Accountant> accountants;

    private AccountantRegistry() {
        try {
            this.accountants = (ArrayList<Accountant>) FileHandler.deserialize(filename);
        } catch (IOException e) {
            this.accountants = new ArrayList<>();
        } catch (ClassNotFoundException e) {
            System.err.println("Serialization error!");
        }
    }

    public Accountant findAccountant(String login, String password) throws AccountantNotFoundException {
        for (Accountant accountant : this.accountants) {
            if (accountant.getLogin().equals(login) &&
                    accountant.getPassword().equals(password)) {
                return accountant;
            }
        }
        throw new AccountantNotFoundException();
    }

    public Accountant findAccountantByLogin(String login) throws AccountantNotFoundException {
        for (Accountant accountant : this.accountants) {
            if (accountant.getLogin().equals(login)) {
                return accountant;
            }
        }
        throw new AccountantNotFoundException();
    }

    public void addAccountantAccount(String login, String password) {
        this.accountants.add(new Accountant(login, password));
    }


    public Accountant lookForDuplicate(String login) throws DuplicateFoundException {
        for(Accountant accountant: this.accountants) {
            if(!accountant.getLogin().equals(login)){
                return null;
            }
        }
        throw new DuplicateFoundException();
    }

    public void removeAccountantAccount(Accountant accountant){
        accountants.remove(accountant);
    }

    public void saveData() {
        try {
            FileHandler.serialize(this.accountants, filename);

        } catch (IOException e) {
            System.err.println("Write error or file not found.");
        }
    }

    public List<Accountant> getAccountant() {
        return this.accountants;
    }
}


