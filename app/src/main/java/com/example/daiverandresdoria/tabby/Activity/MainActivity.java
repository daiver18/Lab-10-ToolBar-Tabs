package com.example.daiverandresdoria.tabby.Activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.daiverandresdoria.tabby.Adapter.PagerAdapter;
import com.example.daiverandresdoria.tabby.Fragments.ListFragment;
import com.example.daiverandresdoria.tabby.Model.Person;
import com.example.daiverandresdoria.tabby.R;
import com.example.daiverandresdoria.tabby.interfaces.Onpersoncreated;

public class MainActivity extends AppCompatActivity implements Onpersoncreated{
    private ViewPager viewPager;
    private TabLayout tabLayout;

    final static public int From_fragment = 0;
    final static public int List_fragment = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTabLayout();
        setViewPager();
        setTabFuntion(viewPager);


        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

    }

    private void setTabLayout() {
        tabLayout = findViewById(R.id.TabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Form"));
        tabLayout.addTab(tabLayout.newTab().setText("List"));
    }

    private void setViewPager() {
        viewPager = findViewById(R.id.ViewPage);
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }

    private void setTabFuntion(final ViewPager viewPager){
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void creatPerson(Person person) {
        ListFragment listFragment = (ListFragment) getSupportFragmentManager().getFragments().get(List_fragment);
        listFragment.addPerson(person);
        viewPager.setCurrentItem(List_fragment);
    }
}
