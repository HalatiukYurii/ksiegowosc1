package main.java.sdacademy.views;


import main.java.sdacademy.models.Accountant;

import java.util.List;

/**
 * Created by marcin on 13.12.2017.
 */
public class AccountantView {
    public static String printAccountants(List<Accountant> accountants) {
        StringBuilder sb = new StringBuilder();
        for (Accountant accountant : accountants) {
            sb.append(accountant.getLogin()).append("\n");
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

    public static String printWrongLogin(){
        return "Login musi miec co najmniej 4 znaki, dozwolone znaki to a-b 0-9 i .(kropka)";
    }

    public static String printWrongPassword(){
        return "Haslo musi miec co najmniej 6 znakow, nie moze zawierac spacji ' '";
    }
}
