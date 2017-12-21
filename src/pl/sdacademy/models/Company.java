package pl.sdacademy.models;

import pl.sdacademy.exceptions.IncorrectNipException;
import pl.sdacademy.helpers.NipValidator;

import java.util.ArrayList;

/**
 * Created by marcin on 13.12.2017.
 */
public class Company {

    private String name;
    private int yearFound;
    private String nip;


    public Company(String name, int yearFound, String nip) throws IncorrectNipException {
        if(NipValidator.validateNip(nip)) {
            this.name = name;
            this.yearFound = yearFound;
            this.nip = nip;
        }
        throw new IncorrectNipException("Unable to create company, cause by invalid NIP number");
    }

    private ArrayList<String> accountantsCompany = new ArrayList<>();

    public void assignAccountant(String accountant) {
       accountantsCompany.add(accountant);
    }

    public String getName() {
        return name;
    }

    public int getYearFound() {
        return yearFound;
    }

    public String getNip() { return nip; }

    public void setName(String name) {
        this.name = name;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
