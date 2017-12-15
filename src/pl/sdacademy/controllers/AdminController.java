package pl.sdacademy.controllers;

import pl.sdacademy.exceptions.AdminNotFoundException;
import pl.sdacademy.models.Admin;
import pl.sdacademy.models.AdminRegistry;
import pl.sdacademy.views.AdminView;

import java.util.ArrayList;
/**
 * Created by marcin on 13.12.2017.
 */
public class AdminController {
    public static void addAdmin(String login, String password) {
        try {
            Admin temp = AdminRegistry.getInstance().findAdmin(login, password);
            if (temp == null) {
                AdminRegistry.getInstance().addAdminAccount(login, password);
            }
        } catch (AdminNotFoundException e) {
            System.out.println("Admin o podanym loginie już istnieje!");
        }
        System.out.println("Dodano użytkownika o nazwie: " + login);
    }


    public static void removeAdmin(String login) {
        try {
            Admin temp = AdminRegistry.getInstance().findAdminByLogin(login);
            if (temp != null) {
                AdminRegistry.getInstance().removeAdminAccount(temp);
            }
        } catch (AdminNotFoundException e) {
            System.out.println("Nie znaleziono użytkownika");
        }
        System.out.println("Usunięto użytkownika o nazwie: " + login);
    }

    public static void printAdmins() {
        AdminView.printAdmins(AdminRegistry.getInstance().getAdmins());
    }
}

