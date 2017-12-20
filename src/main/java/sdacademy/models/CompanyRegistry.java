package sdacademy.models;

import java.io.IOException;
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
        try{
            this.companies = (ArrayList<Company>) FileHandler.deserialize(filename);
        }catch (IOException e){
            this.companies = new ArrayList<>();
        }catch (ClassNotFoundException e){
            System.err.println("Serialization error!");
        }
    }

    public List<Company> getCompanies() {
        return this.companies;
    }

    public void add(Company company) {
        this.companies.add(company);
    }

    public void saveData(String filename){
        try {
            FileHandler.serialize(this.companies, filename);
        }catch (IOException e){
            System.err.println("Write error or file not found.");
        }
    }
}
