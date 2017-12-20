package pl.sdacademy.models;

import pl.sdacademy.exceptions.AccountantNotFoundException;
import pl.sdacademy.exceptions.CompanyNotFoundException;
import pl.sdacademy.exceptions.DuplicateFoundException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcin on 13.12.2017.
 */
public class CompanyRegistry {
    private static CompanyRegistry instance = null;

    public static CompanyRegistry getInstance() {
        if (instance == null) {
            instance = new CompanyRegistry();
        }
        return instance;
    }


    private ArrayList<Company> companies;

    public CompanyRegistry() {
        this.companies = new ArrayList<>();

        this.companies.add(new Company("Ziutex sp. z o.o.", 1990, " 7251801126"));
        this.companies.add(new Company("Krakbud s.j.", 1995, "4582668978"));
    }

    public Company findCompany(String name) throws CompanyNotFoundException {
        for (Company company : companies) {
            if (company.getName().equals(name)) {
                return company;
            }
        }
        throw new CompanyNotFoundException();
    }

    public List<Company> getCompanies() {
        return this.companies;
    }

    public void add(Company company) {
        this.companies.add(company);
    }

    public void removeCompany(String name) throws CompanyNotFoundException {
        try {
            Company temp = findCompany(name);
            companies.remove(temp);
        } catch (CompanyNotFoundException e) {
            // return "Firma nie istnieje";
        }
    }

    public Company lookForDuplicate(String nip) throws DuplicateFoundException {
        for (Company company : this.companies) {
            if (company.getNip().equals(nip)) {
                return null;
            }
        }
        throw new DuplicateFoundException();
    }

    public void assignAccountant(String name, String login) throws AccountantNotFoundException, CompanyNotFoundException {

        Accountant accountant = AccountantRegistry.getInstance().findAccountantByLogin(login);

        Company company = findCompany(name);

        company.assignAccountant(accountant.getLogin());
    }
}
