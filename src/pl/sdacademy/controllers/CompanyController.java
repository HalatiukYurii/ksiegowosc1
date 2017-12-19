package pl.sdacademy.controllers;

import pl.sdacademy.exceptions.AdminNotFoundException;
import pl.sdacademy.exceptions.CompanyNotFoundException;
import pl.sdacademy.models.Admin;
import pl.sdacademy.models.Company;
import pl.sdacademy.models.CompanyRegistry;
import pl.sdacademy.views.CompanyView;

/**
 * Created by marcin on 13.12.2017.
 */
public class CompanyController {
    public static void createCompany(String name, int yearFound, String nip) {
        CompanyRegistry.getInstance().add(new Company(name, yearFound, nip));
    }
    
    public static void listCompanies() {
        CompanyView.printCompanies(CompanyRegistry.getInstance().getCompanies());

    }

    public static String removeCompany(String name) {
        CompanyRegistry.getInstance().removeCompany(name);
    }
}
