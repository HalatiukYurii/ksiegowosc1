package pl.sdacademy.views;

import pl.sdacademy.models.Accountant;

import java.util.List;

/**
 * Created by marcin on 13.12.2017.
 */
public class AccountantView {
    public static void printAccountants(List<Accountant> accountants) {
        try {
            for (Accountant accountant : accountants) {
                System.out.println("login: " + accountant.getLogin());
            }
        }catch (NullPointerException e){
            System.out.println("Empty!");
        }
    }
}
