package pl.sdacademy.controllers;

import pl.sdacademy.exceptions.AccountantNotFoundException;
import pl.sdacademy.exceptions.DuplicateFoundException;
import pl.sdacademy.exceptions.WrongLoginException;
import pl.sdacademy.exceptions.WrongPasswordException;
import pl.sdacademy.helpers.ValidateUser;
import pl.sdacademy.models.AccountantRegistry;
import pl.sdacademy.views.AccountantView;

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
