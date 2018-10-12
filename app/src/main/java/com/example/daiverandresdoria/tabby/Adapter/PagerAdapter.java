package com.example.daiverandresdoria.tabby.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.daiverandresdoria.tabby.Fragments.FormFragment;
import com.example.daiverandresdoria.tabby.Fragments.ListFragment;

import static com.example.daiverandresdoria.tabby.Activity.MainActivity.From_fragment;
import static com.example.daiverandresdoria.tabby.Activity.MainActivity.List_fragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numboftabs;

    public PagerAdapter(FragmentManager fm,int numboftab) {
        super(fm);
        numboftabs = numboftab;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case From_fragment:
                return new FormFragment();
            case List_fragment:
                return new ListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numboftabs;
    }
}
