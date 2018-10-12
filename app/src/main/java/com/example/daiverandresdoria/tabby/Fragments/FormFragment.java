package com.example.daiverandresdoria.tabby.Fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.daiverandresdoria.tabby.Model.Countrys;
import com.example.daiverandresdoria.tabby.Model.Person;
import com.example.daiverandresdoria.tabby.R;
import com.example.daiverandresdoria.tabby.Utils.Utils;
import com.example.daiverandresdoria.tabby.interfaces.Onpersoncreated;

import java.util.ArrayList;
import java.util.List;

public class FormFragment extends Fragment {
    private EditText EditTextname;
    private Spinner Spinnercountry;
    private List<Countrys> contrys;
    private Button save;
    private Onpersoncreated onpersoncreated;



    public FormFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Onpersoncreated){
            onpersoncreated = (Onpersoncreated) context;
        }else{
            throw  new ClassCastException(context.toString()+" should implement DataListener");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_from, container, false);
        EditTextname = view.findViewById(R.id.editTextName);
        Spinnercountry = view.findViewById(R.id.spinnerContry);
        save = view.findViewById(R.id.SaveName);
        loadSpinner();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (EditTextname !=null && !EditTextname.getText().toString().isEmpty()){
                    Countrys contry = (Countrys)Spinnercountry.getSelectedItem();
                    String Name = EditTextname.getText().toString().trim();
                    Person person = new Person(Name,contry);
                    onpersoncreated.creatPerson(person);
                    EditTextname.setText("");
                    Toast.makeText(getContext(),"saved",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getContext(),"imput a valid name",Toast.LENGTH_SHORT).show();
                }

            }
        });
        return view;
    }
    private void loadSpinner(){
        contrys = Utils.getCountrys();
        ArrayAdapter<Countrys> arrayAdapter = new ArrayAdapter<Countrys>(getContext(),R.layout.support_simple_spinner_dropdown_item,contrys);
        Spinnercountry.setAdapter(arrayAdapter);
    }
}
