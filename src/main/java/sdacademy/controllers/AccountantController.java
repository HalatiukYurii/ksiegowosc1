package sdacademy.controllers;

import sdacademy.exceptions.AccountantNotFoundException;
import sdacademy.exceptions.DuplicateFoundException;
import sdacademy.models.Accountant;
import sdacademy.models.AccountantRegistry;
import sdacademy.views.AccountantView;

/**
 * Created by marcin on 13.12.2017.
 */
public class AccountantController {

    public static void addAccountant(String login, String password) {
        try {
            Accountant temp = AccountantRegistry.getInstance().lookForDuplicate(login);
            if (temp == null) {
                AccountantRegistry.getInstance().addAccountantAccount(login, password);
            }
        } catch (DuplicateFoundException e) {
            System.out.println("Accountant o podanym loginie już istnieje!");
        }
        System.out.println("Dodano użytkownika o nazwie: " + login);
    }

    public static void removeAccountant(String login) {
        try {
            Accountant temp = AccountantRegistry.getInstance().findAccountantByLogin(login);
            if (temp.getLogin().equals(login)) {
                AccountantRegistry.getInstance().removeAccountantAccount(temp);
                System.out.println("Usunięto użytkownika o nazwie: " + login);
            }
        }
        catch (AccountantNotFoundException e) {
            System.out.println("Nie znaleziono użytkownika");
        }

    }

    public static void listAccountants() {
        AccountantView.printAccountants(AccountantRegistry.getInstance().getAccountant());
    }
}