package main.java.sdacademy.models;

import java.io.Serializable;

/**
 * Created by marcin on 13.12.2017.
 */
public class Company implements Serializable {
    private String name;
    private int yearFound;

    public Company(String name, int yearFound) {
        this.name = name;
        this.yearFound = yearFound;
    }

    public String getName() {
        return name;
    }

    public int getYearFound() {
        return yearFound;
    }
}