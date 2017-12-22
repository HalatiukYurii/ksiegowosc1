package sdacademy.views;

import sdacademy.models.Company;

import java.util.List;

public class CompanyView {
    public static void printCompanies(List<Company> companies) {
        for(Company company : companies) {
            System.out.println(company.getName() + " (rok założenia: " + company.getYearFound() + ")" + "nip: " + company.getNip());
        }
    }

    public static String assignedAccountant (String name, String login) {
        return "Ksiegowy " + login +  " zostal przydzielony do firmy " + name;
    }

    public static String companyAdded () {
        //System.out.println("Firma " + );
        return null;
    }


}
