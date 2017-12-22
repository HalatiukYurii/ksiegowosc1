package sdacademy.controllers;

import sdacademy.exceptions.AccountantNotFoundException;
import sdacademy.exceptions.DuplicateFoundException;
import sdacademy.exceptions.WrongLoginException;
import sdacademy.exceptions.WrongPasswordException;
import sdacademy.helpers.ValidateUser;
import sdacademy.models.AccountantRegistry;
import sdacademy.views.AccountantView;

/**
 * Created by marcin on 13.12.2017.
 */
public class AccountantController {

    public static void addAccountant(String login, String password) {
        try{
            ValidateUser.validateLogin(login);
            ValidateUser.validatePassword(password);
            AccountantRegistry.getInstance().addAccountant(login, password);
            System.out.println(AccountantView.printAddSuccess(login));
        }catch (DuplicateFoundException e){
            System.out.println(AccountantView.printDuplicateFound(login));
        }catch (WrongLoginException e){
            System.out.println(AccountantView.printWrongLogin());
        }catch (WrongPasswordException e){
            System.out.println(AccountantView.printWrongPassword());
        }
    }

    public static void removeAccountant(String login) {
        try{
            AccountantRegistry.getInstance().removeAccountant(login);
            System.out.println(AccountantView.printRemovedSuccess(login));
        }catch (AccountantNotFoundException e){
            System.out.println(AccountantView.printNotFound(login));
        }
    }

    public static boolean loginAccountant(String login, String password) {
        try {
            AccountantRegistry.getInstance().findAccountant(login, password);
            System.out.println(AccountantView.printLoginSuccess(login));
        } catch (AccountantNotFoundException e) {
            System.out.println(AccountantView.printNotFound(login));
            return false;
        }
        return true;
    }

    public static void listAccountants() {
        System.out.println(AccountantView.printAccountants(AccountantRegistry.getInstance().getAccountant()));
    }
}
