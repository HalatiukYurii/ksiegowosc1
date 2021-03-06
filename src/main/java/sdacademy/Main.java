package sdacademy;

import sdacademy.controllers.AccountantController;
import sdacademy.controllers.AdminController;
import sdacademy.models.AccountantRegistry;
import sdacademy.models.AdminRegistry;
import java.util.Scanner;

public class Main {

    private static boolean loggedAsAdmin = false;
    private static boolean loggedAsAcct = false;

    public enum State {
        INIT,
        LOGGING_IN_AS_ADMIN,
        LOGGING_IN_AS_ACCT,

        LOGGED_AS_ADMIN,
        /////opcje admina/////

        ADMIN_ACCOUNTS_OPTIONS,
        ACCT_ACCOUNTS_OPTIONS,
        COMPANY_OPTIONS,
        CREATING_COMPANY,

        LOGGED_AS_ACCT,
        //////opcje ksiegowego/////
        ACCT_OPTIONS,

        SAVE_DATA,
        EXIT,
    }

    public static void main(String[] args) {
        State state = State.INIT;
        Scanner scanner = new Scanner(System.in);

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

                    boolean loginSuccess = AdminController.loginAdmin(login, password);
                    if (loginSuccess) {
                        state = State.LOGGED_AS_ADMIN;
                    } else {
                        state = State.INIT;
                    }
                    break;
                }

                case LOGGED_AS_ADMIN: {
                    System.out.println("Co chcesz zrobić?");
                    System.out.println(" 1 - zarzadanie kontami administratorow");
                    System.out.println(" 2 - zarzadanie kontami ksiegowych");
                    System.out.println(" 3 - zarzadzanie firmami");
                    System.out.println(" 0 - wyjść z programu");

                    String answer = scanner.nextLine();

                    switch (answer) {
                        case ("1"):
                            state = State.ADMIN_ACCOUNTS_OPTIONS;
                            break;
                        case ("2"):
                            state = State.ACCT_ACCOUNTS_OPTIONS;
                            break;
                        case ("3"):
                            state = State.COMPANY_OPTIONS;
                            break;

                        case ("0"):
                            state = State.EXIT;
                            break;

                        default:
                            System.out.println("Zła odpowiedź");
                            state = State.LOGGED_AS_ADMIN;
                            break;
                    }
                    break;
                }

                case ADMIN_ACCOUNTS_OPTIONS: {
                    String login, password;

                    System.out.println("Konta administratorow");
                    System.out.println("1 - wyświetl konta administratorów");
                    System.out.println("2 - dodaj konto administratora");
                    System.out.println("3 - usuń konto administratora");
                    System.out.println("0 - powrót");

                    String answer = scanner.nextLine();

                    switch (answer) {
                        case ("1"):
                            AdminController.printAdmins();
                            break;

                        case ("2"):
                            System.out.println("Podaj login: ");
                            login = scanner.nextLine();
                            System.out.println("Podaj haslo: ");
                            password = scanner.nextLine();
                            AdminController.addAdmin(login, password);
                            break;

                        case ("3"):
                            System.out.println("Podaj login: ");
                            login = scanner.nextLine();
                            AdminController.removeAdmin(login);
                            break;

                        case ("0"):
                            state = State.LOGGED_AS_ADMIN;
                            break;

                        default: {
                            System.out.println("Zła odpowiedź.");
                            state = State.ADMIN_ACCOUNTS_OPTIONS;
                        }
                    }
                    break;
                }
                case LOGGING_IN_AS_ACCT: {
                    System.out.println("Podaj login:");
                    String login = scanner.nextLine();

                    System.out.println("Podaj hasło:");
                    String password = scanner.nextLine();

                    boolean loginSuccess = AdminController.loginAdmin(login, password);
                    if (loginSuccess) {
                        state = State.ACCT_ACCOUNTS_OPTIONS;
                    } else {
                        state = State.INIT;
                    }
                    break;
                }
                case ACCT_ACCOUNTS_OPTIONS: {
                    String login, password;

                    System.out.println("Konta ksiegowych?");
                    System.out.println("1 - wyświetl konta ksiegowych");
                    System.out.println("2 - dodaj konto ksiegowych");
                    System.out.println("3 - usuń konto ksiegowych");
                    System.out.println("0 - powrót");

                    String answer = scanner.nextLine();
                    switch (answer) {
                        case "1":
                            AccountantController.listAccountants();

                            break;
                        case "2":
                            System.out.println("Podaj login: ");
                            login = scanner.nextLine();
                            System.out.println("Podaj haslo: ");
                            password = scanner.nextLine();
                            AccountantController.addAccountant(login, password);

                            break;
                        case "3":
                            System.out.println("Podaj login: ");
                            login = scanner.nextLine();

                            AccountantController.removeAccountant(login);

                            break;
                        case "0":
                            state = State.LOGGED_AS_ADMIN;
                            break;
                        default: {
                            System.out.println("Zła odpowiedź.");
                            state = State.ACCT_ACCOUNTS_OPTIONS;
                        }
                    }
                    break;
                }

                case LOGGED_AS_ACCT: {
                    System.out.println("Co chcesz zrobic?");
                    System.out.println("1 - wyświetl konta ksiegowych");
                    System.out.println("2 - dodać firmę");
                    System.out.println("3 - dodać kontrachęta");
                    System.out.println("4 - dodać fakturę");
                    System.out.println("0 - powrót");

                    String answer = scanner.nextLine();
                    switch (answer) {
                        case "1":
                            AccountantController.listAccountants();
                        case "2":
                            AccountantController.addCompany();
                        case "3":
                            AccountantController.addContrctor();
                        case "4":
                            AccountantController.addInvoice();
                        case "0":
                            state = State.ACCT_ACCOUNTS_OPTIONS;
                    }
                }
                case COMPANY_OPTIONS: {
                    //todo opcje firmy dla admina
                }
            }
        }
        saveData();
    }

    private static void saveData() {
        AccountantRegistry.getInstance().saveData();
        AdminRegistry.getInstance().saveData();

    }
}
