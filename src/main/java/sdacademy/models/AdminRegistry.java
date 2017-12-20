package sdacademy.models;

import sdacademy.exceptions.AdminNotFoundException;
import sdacademy.exceptions.DuplicateFoundException;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by marcin on 13.12.2017.
 */
public class AdminRegistry implements Serializable {
    private static AdminRegistry instance = null;
    final private String filename = "data/admin.dat";

    public static AdminRegistry getInstance() {
        if (instance == null) {
            instance = new AdminRegistry();
        }
        return instance;
    }


    private ArrayList<Admin> admins;

    private AdminRegistry() {
        try {
            admins = (ArrayList<Admin>) FileHandler.deserialize(filename);
        } catch (IOException e) {
            admins = new ArrayList<>();
            admins.add(new Admin("admin", "admin"));
        } catch (ClassNotFoundException e) {
            System.err.println("Serialization error!");
        }
    }


    public Admin findAdmin(String login, String password) throws AdminNotFoundException {
        for (Admin admin : this.admins) {
            if (admin.getLogin().equals(login) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        throw new AdminNotFoundException();
    }

    public Admin findAdminByLogin(String login) throws AdminNotFoundException {
        for (Admin admin : this.admins) {
            if (admin.getLogin().equals(login)) {
                return admin;
            }
        }
        throw new AdminNotFoundException();
    }


    public Admin lookForDuplicate(String login) throws DuplicateFoundException{
        for(Admin admin: this.admins) {
            if(!admin.getLogin().equals(login)){
                return null;
            }
        }
        throw new DuplicateFoundException();
    }

    public void addAdminAccount(String login, String password){
        this.admins.add(new Admin(login, password));
    }

    public void removeAdminAccount(Admin admin) {
        admins.remove(admin);
    }

    public void saveData() {
        try {
            FileHandler.serialize(this.admins, filename);

        } catch (IOException e) {
            System.err.println("Write error or file not found.");
        }
    }

    public ArrayList<Admin> getAdmins() {
        return admins;
    }
}
