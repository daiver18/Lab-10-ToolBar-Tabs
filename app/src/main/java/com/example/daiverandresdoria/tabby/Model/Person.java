package com.example.daiverandresdoria.tabby.Model;

public class Person {
    private String name;
    private Countrys country;

    public Person(String name, Countrys country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Countrys getCountry() {
        return country;
    }

    public void setCountry(Countrys country) {
        this.country = country;
    }
}
