package pl.sdacademy.controllers;

import pl.sdacademy.exceptions.AccountantNotFoundException;
import pl.sdacademy.models.Accountant;
import pl.sdacademy.models.AccountantRegistry;
import pl.sdacademy.views.AccountantView;

/**
 * Created by marcin on 13.12.2017.
 */
public class AccountantController {
    static AccountantRegistry accountantRegistry = new AccountantRegistry();

    public static String addAccountant(String login, String password) {
        try {
            Accountant temp = accountantRegistry.getInstance().findAccountant(login, password);
            if (temp == null) {
                accountantRegistry.addAccountantAccount(login, password);
                return "Dodano użytkownika o nazwie: " + login;
            }
        } catch (AccountantNotFoundException e) {
                return "Accountant o podanym loginie już istnieje!";
        }
        return "Accountant o podanym loginie już istnieje!";
    }


    public static String removeAccountant(String login) throws AccountantNotFoundException {
        Accountant temp = accountantRegistry.getInstance().findAccountant(login);
        if (temp.getLogin().equals(login)) {
            accountantRegistry.removeAccountantAccount(temp);
            return "Usunięto użytkownika o nazwie: " + login;
        }
        return "Nie znaleziono użytkownika";
    }

    public static void listAccountants() {
        AccountantView.printAccountants(AccountantRegistry.getInstance().getAccountant());
    }
}
