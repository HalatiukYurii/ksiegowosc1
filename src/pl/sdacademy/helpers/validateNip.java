package pl.sdacademy.helpers;

import pl.sdacademy.exceptions.IncorrectNip;

public class validateNip {
    int validateNip(String nip) throws IncorrectNip {

        if (nip.length() != 10) {
            System.out.println("Niepoprawna dlugosc nipu!");
        }

        int sum = (nip.charAt(0) * 6 + nip.charAt(1) * 5 + nip.charAt(2) * 7 + nip.charAt(3) * 2 + nip.charAt(4) * 3 + nip.charAt(5) * 4 +
                nip.charAt(6) * 5 + nip.charAt(7) * 6 + nip.charAt(8) * 7);

        sum %= 11;

        if (sum == nip.charAt(9) {
            System.out.println("Nip poprawny!");
        }
        System.out.println("Nip niepoprawny!");
    }
}