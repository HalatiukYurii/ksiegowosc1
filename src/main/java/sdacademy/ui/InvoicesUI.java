package sdacademy.ui;

import sdacademy.enums.TypeInvoice;
import sdacademy.exceptions.CompanyNotFoundException;
import sdacademy.exceptions.ContractorNotFoundException;
import sdacademy.models.*;
import java.math.BigDecimal;
import java.util.Scanner;

enum State{
    INIT,
    ADD_COMPANY,
    ADD_CONTRACOTR,
    INIT_CD,
    ADD_INVOICE,
}

public class InvoicesUI {
    public static void main(String[] args) {


    }
    public static Invoice getInvoice() {
        Invoice invoice = null;
        Company company = null;
        Contractor contractor = null;
        TypeInvoice type;
        BigDecimal rateVat;
        boolean stateInvoice;

        State state = State.INIT;
        Scanner scanner = new Scanner(System.in);
        switch (state) {
            case INIT :{
                System.out.println("Podaj NIP firmy dla której chcesz dodać fakturę ");
                String nipCompany = scanner.nextLine();
                try {
                    company = CompanyRegistry.findCompanyByNip(nipCompany);
                } catch (CompanyNotFoundException e) {
                    System.out.println("Czy chcesz dodać firmę\n" +
                            "1 - tak\n" +
                            "2 - nie?");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        state = State.ADD_COMPANY;
                        break;
                    } else {
                        break;
                    }
                }
                state = State.INIT_CD;
                break;
            }
            case ADD_COMPANY: {
                company = CompaniesUI.addCompany();
                state = State.INIT_CD;
                break;
            }
            case INIT_CD: {
                System.out.println("Podaj NIP kontrachenta dla której chcesz dodać fakturę ");
                String nipContractor = scanner.nextLine();
                try {
                    contractor = ContractorRegistry.findContractorByNip(nipContractor);
                } catch (ContractorNotFoundException e) {
                    System.out.println("Czy chcesz dodać kontrachęta\n" +
                            "1 - tak\n" +
                            "2 - nie?");
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        state = State.ADD_CONTRACOTR;
                        break;
                    } else {
                        break;
                    }
                }
                state = State.ADD_INVOICE;
                break;
            }
            case ADD_CONTRACOTR:{
                contractor = ContractorUI.addContractor();
                state = State.ADD_INVOICE;
                break;
            }
            case ADD_INVOICE:{
                System.out.println("Podaj typ faktury\n" +
                        "1 - faktura sprzedaży\n" +
                        "2 - faktura zakupu");
                String choice = scanner.nextLine();
                if(choice.equals("1")){
                    type = TypeInvoice.SALE;
                }else if(choice.equals("2")){
                    type = TypeInvoice.PURCHASE;
                }else {
                    System.out.println("Zły typ faktury");
                    state = State.ADD_INVOICE;
                    break;
                }
                System.out.println("Podaj kwote netto faktury");
                double netAmout = scanner.nextDouble();
                BigDecimal netAmountBD = new BigDecimal(netAmout);
                System.out.println("Podaj stawkę podatku VAT\n" +
                        "1 - VAT = 8%\n" +
                        "2 - VAT = 23%");
                choice = scanner.nextLine();
                if(choice.equals("1")){
                    rateVat = new BigDecimal(0.08);
                }else if(choice.equals("2")){
                    rateVat = new BigDecimal(0.23);
                }else {
                    System.out.println("Zła stawka VAT");
                    state = State.ADD_INVOICE;
                    break;
                }
                System.out.println("Czy faktura jest zapłacona\n" +
                        "1 - tak, faktura zapłacona\n" +
                        "2 - nie, faktura nie zaplacona ");
                if(choice.equals("1")){
                    stateInvoice = true;
                }else if(choice.equals("2")){
                    stateInvoice = false;
                }else {
                    System.out.println("Nie wybrałeś popawnej stanu faktury");
                    state = State.ADD_INVOICE;
                    break;
                }
                invoice = new Invoice(type, netAmountBD, rateVat, stateInvoice);
            }
        }
        return invoice;
    }
}
