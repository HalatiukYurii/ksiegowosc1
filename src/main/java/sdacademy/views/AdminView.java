package sdacademy.views;

import sdacademy.models.Admin;

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
