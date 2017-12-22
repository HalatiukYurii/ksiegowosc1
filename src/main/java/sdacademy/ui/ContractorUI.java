package sdacademy.ui;

import sdacademy.exceptions.ContractorNotFoundException;
import sdacademy.models.Contractor;
import sdacademy.models.ContractorRegistry;

import java.util.Scanner;

public class ContractorUI {
    public static void main(String[] args) {

    }
    public static Contractor addContractor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nip kontrchenta, którego chcesz dodać");
        String nip = scanner.nextLine();
        try{
            ContractorRegistry.findContractorByNip(nip);
            System.out.println("Ten kontrachent już jest w systemie!");
            return null;
        } catch (ContractorNotFoundException e) {
            e.getMessage();
        }
        System.out.println("Podaj nazwę firmy");
        String name = scanner.nextLine();
        System.out.println("Podaj rok założenia");
        int yearOfFound = scanner.nextInt();
        Contractor contractor = new Contractor(name, yearOfFound, nip);
        return contractor;
    }
}


