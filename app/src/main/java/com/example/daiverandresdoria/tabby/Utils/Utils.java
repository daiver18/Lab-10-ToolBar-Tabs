package com.example.daiverandresdoria.tabby.Utils;

import com.example.daiverandresdoria.tabby.Model.Countrys;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Countrys> getCountrys(){
        return new ArrayList<Countrys>(){{
            add(new Countrys("Colombia","25"));
            add(new Countrys("España","1"));
            add(new Countrys("Chile","5"));
            add(new Countrys("Mexico","6"));
            add(new Countrys("Peru","10"));
        }};
    }

}
