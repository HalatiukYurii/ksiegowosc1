package main.java.sdacademy.controllers;


import main.java.sdacademy.models.Company;
import main.java.sdacademy.models.CompanyRegistry;
import main.java.sdacademy.views.CompanyView;


/**
 * Created by marcin on 13.12.2017.
 */
public class CompanyController {
    public static void createCompany(String name, int yearFound) {
        CompanyRegistry.getInstance().add(new Company(name, yearFound));
    }


    public static void listCompanies() {
        CompanyView.printCompanies(CompanyRegistry.getInstance().getCompanies());

    }
}
