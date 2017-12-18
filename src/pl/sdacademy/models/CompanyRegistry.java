package pl.sdacademy.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcin on 13.12.2017.
 */
public class CompanyRegistry implements Serializable{
    private static CompanyRegistry instance = null;
    final private String filename = "data/company.dat";
    public static CompanyRegistry getInstance() {
        if(instance == null) {
            instance = new CompanyRegistry();
        }
        return instance;
    }


    private ArrayList<Company> companies;

    public CompanyRegistry() {
        this.companies = new ArrayList<>();

        this.companies.add(new Company("Ziutex sp. z o.o.", 1990));
        this.companies.add(new Company("Krakbud s.j.", 1995));
    }


    public List<Company> getCompanies() {
        return this.companies;
    }


    public void add(Company company) {
        this.companies.add(company);
    }
}
