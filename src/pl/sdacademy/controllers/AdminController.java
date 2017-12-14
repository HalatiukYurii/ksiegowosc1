package pl.sdacademy.controllers;

import pl.sdacademy.exceptions.AdminNotFoundException;
import pl.sdacademy.models.Admin;
import pl.sdacademy.models.AdminRegistry;

import java.util.ArrayList;

/**
 * Created by marcin on 13.12.2017.
 */
public class AdminController {
    AdminRegistry adminRegistry = new AdminRegistry();

    public String addAdmin(String login, String password) {
        try {
            Admin temp = adminRegistry.getInstance().findAdmin(login, password);
            if (temp == null) {
                adminRegistry.addAdminAccount(login, password);
                return "Dodano użytkownika o nazwie: " + login;
            }
        } catch (AdminNotFoundException e) {
        }
        return "Admin o podanym loginie już istnieje!";
    }


    public String removeAdmin(String login, String password) throws AdminNotFoundException {
        Admin temp = adminRegistry.getInstance().findAdmin(login, password);
        if (temp.getLogin().equals(login)) {
            adminRegistry.removeAdminAccount(temp);
            return "Usunięto użytkownika o nazwie: " + login;
        }
        return "Nie znaleziono użytkownika";
    }

    public String getAllAdminLogins(){
        ArrayList<Admin> array = adminRegistry.getAdmins();
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for(Admin admin : array){
            sb.append(counter).append(". ").append(admin.getLogin()).append("\n");
            counter++;
        }
        return sb.toString();
    }
}

