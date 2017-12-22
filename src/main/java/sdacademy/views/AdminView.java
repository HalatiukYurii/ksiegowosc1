package sdacademy.views;

import sdacademy.models.Admin;
import java.util.List;

public class AdminView {
    public static String printAdmins(List<Admin> admins) {
        StringBuilder sb = new StringBuilder();
        for (Admin admin : admins) {
            sb.append(admin.getLogin()).append("\n");
        }
        return sb.toString();
    }

    public static String printLoginSuccess(String login) {
        return "Dzien dobry " + login;
    }

    public static String printNotFound(String login) {
        return "Nie znaleziono uzytkownika " + login;
    }

    public static String printAddSuccess(String login){
        return "Dodano uzytkownika " + login;
    }

    public static String printDuplicateFound(String login){
        return "Uzytkownik " + login + " juz istnieje.";
    }

    public static String printRemovedSuccess(String login){
        return "Usunieto uzytkownika " + login;
    }

    public static String printMinimumAccount(){
        return "Musi byc co najmniej jeden administrator.";
    }

    public static String printWrongLogin(){
        return "Login musi miec co najmniej 4 znaki, dozwolone znaki to a-b 0-9 i .(kropka)";
    }

    public static String printWrongPassword(){
        return "Haslo musi miec co najmniej 6 znakow, nie moze zawierac spacji ' '.";
    }
}
