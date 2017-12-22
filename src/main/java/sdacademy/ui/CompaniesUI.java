package sdacademy.ui;

import sdacademy.exceptions.DuplicateFoundException;
import sdacademy.exceptions.IncorrectNipException;
import sdacademy.models.Company;
import sdacademy.models.CompanyRegistry;

import java.util.Scanner;

public class CompaniesUI {
    public static void main(String[] args) {


    }
    public static Company addCompany(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nip firmy którą chcesz dodać");
        String nip = scanner.nextLine();
        if(CompanyRegistry.checkCompanyByNip(nip)) {
            System.out.println("Ta firma już jest w systemie!");
            return null;
        }

        System.out.println("Podaj nazwę firmy");
        String name = scanner.nextLine();
        System.out.println("Podaj rok założenia");
        int yearOfFound = scanner.nextInt();
        Company company = null;
        try {
            company = new Company(name, yearOfFound, nip);
        } catch (IncorrectNipException e) {
            e.getMessage();
        }
        return company;

    }
}
