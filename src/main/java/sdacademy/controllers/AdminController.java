package main.java.sdacademy.controllers;


import main.java.sdacademy.exceptions.*;
import main.java.sdacademy.helpers.ValidateUser;
import main.java.sdacademy.models.AdminRegistry;
import main.java.sdacademy.views.AdminView;

/**
 * Created by marcin on 13.12.2017.
 */
public class AdminController {
    public static void addAdmin(String login, String password) {
        try {
            ValidateUser.validateLogin(login);
            ValidateUser.validatePassword(password);
            AdminRegistry.getInstance().addAdminAccount(login, password);
            System.out.println(AdminView.printAddSuccess(login));
        } catch (DuplicateFoundException e) {
            System.out.println(AdminView.printDuplicateFound(login));
        }catch (WrongLoginException e){
            System.out.println(AdminView.printWrongLogin());
        }catch (WrongPasswordException e){
            System.out.println(AdminView.printWrongPassword());
        }
    }

    public static boolean loginAdmin(String login, String password) {
        try {
            AdminRegistry.getInstance().findAdmin(login, password);
            System.out.println(AdminView.printLoginSuccess(login));
        } catch (AdminNotFoundException e) {
            System.out.println(AdminView.printNotFound(login));
            return false;
        }
        return true;
    }

    public static void removeAdmin(String login) {
        try {
            AdminRegistry.getInstance().removeAdminAccount(login);
            System.out.println(AdminView.printRemovedSuccess(login));
        } catch (AdminNotFoundException e) {
            System.out.println(AdminView.printNotFound(login));
        } catch (MinimumAccountException e){
            System.out.println(AdminView.printMinimumAccount());
        }
    }

    public static void printAdmins() {
        System.out.println(AdminView.printAdmins(AdminRegistry.getInstance().getAdmins()));
    }
}

