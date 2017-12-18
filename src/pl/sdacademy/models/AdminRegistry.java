package pl.sdacademy.models;

import pl.sdacademy.exceptions.AdminNotFoundException;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by marcin on 13.12.2017.
 */
public class AdminRegistry implements Serializable{
    private static AdminRegistry instance = null;
    final private String filename = "data/admin.dat";
    public static AdminRegistry getInstance() {
        if(instance == null) {
            instance = new AdminRegistry();
        }
        return instance;
    }


    private ArrayList<Admin> admins = new ArrayList<>();

    private AdminRegistry() {
        //TODO get list form file

        this.admins.add(new Admin("adam", "123"));
        this.admins.add(new Admin("ziutek", "456"));

    }


    public Admin findAdmin(String login, String password) throws AdminNotFoundException {
        for(Admin admin : this.admins) {
            if(admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        throw new AdminNotFoundException();
    }

    public Admin findAdminByLogin(String login) throws AdminNotFoundException{
        for(Admin admin: this.admins){
            if(admin.getLogin().equals(login)){
                return admin;
            }
        }
        throw new AdminNotFoundException();
    }

    public void addAdminAccount(String login, String password){
        this.admins.add(new Admin(login, password));
    }

    public void removeAdminAccount(Admin admin){
        admins.remove(admin);
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }

}
