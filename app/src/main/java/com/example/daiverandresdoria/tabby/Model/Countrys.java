package com.example.daiverandresdoria.tabby.Model;

import java.text.MessageFormat;

public class Countrys {

    private String Countryname;
    private String CountryCode;

    public Countrys(String countryname, String countryCode) {
        Countryname = countryname;
        CountryCode = countryCode;
    }

    public String getCountryname() {
        return Countryname;
    }

    public void setCountryname(String countryname) {
        Countryname = countryname;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String toString(){
        return Countryname;
    }

    public String getFlag(){
        return MessageFormat.format("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/{0}.png",this.CountryCode);
    }
}

