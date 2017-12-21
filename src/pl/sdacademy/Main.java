package pl.sdacademy;

import pl.sdacademy.controllers.AccountantController;
import pl.sdacademy.controllers.AdminController;
import pl.sdacademy.controllers.CompanyController;
import pl.sdacademy.exceptions.AccountantNotFoundException;
import pl.sdacademy.exceptions.AdminNotFoundException;
import pl.sdacademy.exceptions.DuplicateFoundException;
import pl.sdacademy.exceptions.IncorrectNipException;
import pl.sdacademy.models.*;
import pl.sdacademy.views.AdminView;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {

    public enum State {
        INIT,
        LOGGING_IN_AS_ADMIN,
        LOGGING_IN_AS_ACCT,
        LOGGED_IN,
        ADMIN_OPTIONS,
        CREATING_COMPANY,
        EXIT,
    }

    public static void main(String[] args) {
        State state = State.INIT;
        Scanner scanner = new Scanner(System.in);

        Admin currentAdmin = null;

        Accountant currentAcct = null;

        while (state != State.EXIT) {
            switch (state) {
                case INIT: {
                    System.out.println("Dzień dobry, co chcesz zrobić?");
                    System.out.println(" 1 - zalogować się jako admin");
                    System.out.println(" 2 - zalogować się jako księgowy");
                    System.out.println(" 0 - wyjść z programu");

                    String answer = scanner.nextLine();

                    switch (answer) {
                        case ("1"):
                            state = State.LOGGING_IN_AS_ADMIN;
                            break;

                        case ("2"):
                            state = State.LOGGING_IN_AS_ACCT;
                            break;

                        case ("0"):
                            state = State.EXIT;
                            break;

                        default:
                            System.out.println("Zła odpowiedź");
                            state = State.INIT;
                            break;
                    }
                    break;
                }

                case LOGGING_IN_AS_ADMIN: {
                    System.out.println("Podaj login:");
                    String login = scanner.nextLine();

                    System.out.println("Podaj hasło:");
                    String password = scanner.nextLine();

                    try {
                        currentAdmin = AdminRegistry.getInstance().findAdmin(login, password);
                        System.out.println("Dzień dobry " + currentAdmin.getLogin());
                        state = State.LOGGED_IN;

                    } catch (AdminNotFoundException e) {
                        System.out.println("Zły login lub hasło");
                        state = State.INIT;
                    }
                    break;
                }

                case LOGGING_IN_AS_ACCT: {
                    System.out.println("Podaj login:");
                    String login = scanner.nextLine();

                    System.out.println("Podaj hasło:");
                    String password = scanner.nextLine();

                    try {
                        currentAcct = AccountantRegistry.getInstance().findAccountant(login, password);
                        System.out.println("Dzień dobry " + currentAcct.getLogin());
                        state = State.LOGGED_IN;


                    } catch (AccountantNotFoundException e) {
                        System.out.println("Zły login lub hasło");
                        state = State.INIT;
                    }
                    break;
                }

                case LOGGED_IN: {
                    System.out.println("Co chcesz zrobić?");
                    System.out.println(" 1 - wypisać wszystkie firmy");
                    System.out.println(" 2 - dodać firmę");
                    System.out.println(" 3 - zarzadanie kontami administratorow");
                    System.out.println(" 0 - wyjść z programu");

                    String answer = scanner.nextLine();

                    switch (answer) {
                        case ("1"):
                            CompanyController.listCompanies();
                            state = State.LOGGED_IN;
                            break;

                        case ("2"):
                            state = State.CREATING_COMPANY;
                            break;
                        case ("3"):
                            state = State.ADMIN_OPTIONS;
                            break;

                        case ("0"):
                            state = State.EXIT;
                            break;

                        default:
                            System.out.println("Zła odpowiedź");
                            state = State.INIT;
                            break;
                    }
                    break;
                }

                case ADMIN_OPTIONS:
                    String login;
                    String password;
                    String choice;
                    System.out.println("Co chcesz zrobic?");
                    System.out.println("1 - wyświetl konta administratorów");
                    System.out.println("2 - dodaj konto administratora");
                    System.out.println("3 - usuń konto administratora");
                    System.out.println("4 - wyświetl konta księgowych");
                    System.out.println("5 - dodaj konto księgowego");
                    System.out.println("6 - usuń konto księgowego");
                    System.out.println("0 - powrót");

                    String answer = scanner.nextLine();

                    switch (answer) {

                        case ("1"):
                            AdminController.printAdmins();
                            state = State.ADMIN_OPTIONS;
                            break;

                        case ("2"):

                            System.out.println("Podaj login: ");
                            login = scanner.nextLine();
                            System.out.println("Podaj haslo: ");
                            password = scanner.nextLine();

                            AdminController.addAdmin(login, password);

                            state = State.ADMIN_OPTIONS;
                            break;

                        case ("3"):

                            System.out.println("Podaj login: ");
                            login = scanner.nextLine();

                            AdminController.removeAdmin(login);

                            state = State.ADMIN_OPTIONS;
                            break;

                        case ("4"):

                            AccountantController.listAccountants();
                            state = State.ADMIN_OPTIONS;
                            break;

                        case ("5"):

                            System.out.println("Podaj login");
                            login = scanner.nextLine();
                            System.out.println("Podaj hasło");
                            password = scanner.nextLine();
                            AccountantController.addAccountant(login, password);
                            state = State.ADMIN_OPTIONS;
                            break;

                        case ("6"):

                            System.out.println("Podaj login: ");
                            login = scanner.nextLine();
                            AccountantController.removeAccountant(login);

                            state = State.ADMIN_OPTIONS;
                            break;

                        case ("0"):

                            state = State.LOGGED_IN;
                            break;

                    }
                    break;

                case CREATING_COMPANY: {
                    System.out.println("Podaj nazwę nowej firmy:");
                    String name = scanner.nextLine();

                    System.out.println("Podaj rok założenia nowej firmy:");
                    int yearFound = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Podaj nip firmy:");
                    String nip = scanner.nextLine();


//                    CompanyController.createCompany(name, yearFound, nip);


                    try {
                        Company temp = new Company(name, yearFound, nip);
                    } catch (IncorrectNipException e) {
                        System.out.println("Podano nieprawidlowy nip, sprobuj ponownie:");
                        e.printStackTrace();
                    } catch (DuplicateFoundException e) {
                        System.out.println("Firma o podanym nipie istnieje w bazie");
                    }
                    state = State.LOGGED_IN;
                    break;
                }
            }
        }
        AccountantRegistry.getInstance().saveData();
    }
}
