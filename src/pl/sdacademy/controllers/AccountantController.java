package pl.sdacademy.controllers;

import pl.sdacademy.exceptions.AccountantNotFoundException;
import pl.sdacademy.models.Accountant;
import pl.sdacademy.models.AccountantRegistry;
import pl.sdacademy.views.AccountantView;

/**
 * Created by marcin on 13.12.2017.
 */
public class AccountantController {

    public static void addAccountant(String login, String password) {
        try {
            Accountant temp = AccountantRegistry.getInstance().findAccountant(login, password);
            if (temp == null) {
                AccountantRegistry.getInstance().addAccountantAccount(login, password);
                System.out.println("Dodano użytkownika o nazwie: " + login);
            }
        } catch (AccountantNotFoundException e) {
            System.out.println("Accountant o podanym loginie już istnieje!");
        }
    }

    public static void removeAccountant(String login) {
        try {
            Accountant temp = AccountantRegistry.getInstance().findAccountantByLogin(login);
            if (temp.getLogin().equals(login)) {
                AccountantRegistry.getInstance().removeAccountantAccount(temp);
            }
        }
        catch (AccountantNotFoundException e) {
            System.out.println("Nie znaleziono użytkownika");
        }
        System.out.println("Usunięto użytkownika o nazwie: " + login);
    }

    public static void listAccountants() {
        AccountantView.printAccountants(AccountantRegistry.getInstance().getAccountant());
    }
}
