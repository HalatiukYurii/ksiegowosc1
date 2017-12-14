package pl.sdacademy.views;

import pl.sdacademy.controllers.AdminController;
import pl.sdacademy.models.AdminRegistry;

/**
 * Created by marcin on 13.12.2017.
 */
public class AdminView {
    AdminController adminController = new AdminController();
    public void printAdmins(){
        System.out.println(adminController.getAllAdminLogins());
    }
}
