package pl.sdacademy.models;

import java.util.ArrayList;

/**
 * Created by marcin on 13.12.2017.
 */
public class Company {

    private String name;
    private int yearFound;
    private String nip;

    public Company(String name, int yearFound, String nip) {
        this.name = name;
        this.yearFound = yearFound;
        this.nip = nip;
    }

    private ArrayList<Company> accountants;

    public void AccountantRegistry() {
        this.accountants = new ArrayList<>();

        this.accountants.add(new Accountant("jan")); // FIXME
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
