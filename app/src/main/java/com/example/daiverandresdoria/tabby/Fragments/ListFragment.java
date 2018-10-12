package com.example.daiverandresdoria.tabby.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.daiverandresdoria.tabby.Adapter.ListViewAdapter;
import com.example.daiverandresdoria.tabby.Model.Person;
import com.example.daiverandresdoria.tabby.R;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private List<Person> listNames;
    private ListView listView;
    private ListViewAdapter listViewAdapter;

    public ListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        listNames = new ArrayList<Person>();
        listView = view.findViewById(R.id.ListViewFragment);
        listViewAdapter = new ListViewAdapter(R.layout.list_view_item,getContext(),listNames);
        listView.setAdapter(listViewAdapter);
        return view;
    }

    public void addPerson(Person person){
        listNames.add(person);
        listViewAdapter.notifyDataSetChanged();
    }

}
