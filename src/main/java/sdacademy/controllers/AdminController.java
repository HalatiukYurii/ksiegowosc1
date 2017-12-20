package sdacademy.controllers;

import sdacademy.exceptions.AdminNotFoundException;
import sdacademy.exceptions.DuplicateFoundException;
import sdacademy.models.Admin;
import sdacademy.models.AdminRegistry;
import sdacademy.views.AdminView;

/**
 * Created by marcin on 13.12.2017.
 */
public class AdminController {
    public static void addAdmin(String login, String password) {
        try {
            Admin temp = AdminRegistry.getInstance().lookForDuplicate(login);
            if (temp == null) {
                AdminRegistry.getInstance().addAdminAccount(login, password);
                System.out.println("Dodano użytkownika o nazwie: " + login);
            }
        } catch (DuplicateFoundException e) {
            System.out.println("Admin o podanym loginie już istnieje!");
        }
    }


    public static void removeAdmin(String login) {
        try {
            Admin temp = AdminRegistry.getInstance().findAdminByLogin(login);
            if (temp != null) {
                AdminRegistry.getInstance().removeAdminAccount(temp);
                System.out.println("Usunięto użytkownika o nazwie: " + login);
                temp = null;
            }
        } catch (AdminNotFoundException e) {
            System.out.println("Nie znaleziono użytkownika");
        }

    }

    public static void printAdmins() {
        AdminView.printAdmins(AdminRegistry.getInstance().getAdmins());
    }
}

