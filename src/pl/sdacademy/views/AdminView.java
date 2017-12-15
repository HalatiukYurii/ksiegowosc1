package pl.sdacademy.views;

import pl.sdacademy.controllers.AdminController;
import pl.sdacademy.models.Admin;
import pl.sdacademy.models.AdminRegistry;

import java.util.List;

/**
 * Created by marcin on 13.12.2017.
 */
public class AdminView {
    public static void printAdmins(List<Admin> admins){
        for(Admin admin: admins){
            System.out.println("Login: " + admin.getLogin());
        }
    }
}
