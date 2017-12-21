package pl.sdacademy.controllers;

import pl.sdacademy.exceptions.AdminNotFoundException;
import pl.sdacademy.exceptions.DuplicateFoundException;
import pl.sdacademy.exceptions.MinimumAccountException;
import pl.sdacademy.models.AdminRegistry;
import pl.sdacademy.views.AdminView;

/**
 * Created by marcin on 13.12.2017.
 */
public class AdminController {
    public static void addAdmin(String login, String password) {
        try {
            AdminRegistry.getInstance().addAdminAccount(login, password);
            System.out.println(AdminView.printAddSuccess(login));
        } catch (DuplicateFoundException e) {
            System.out.println(AdminView.printDuplicateFound(login));
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

