package com.example.daiverandresdoria.tabby.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.daiverandresdoria.tabby.Model.Countrys;
import com.example.daiverandresdoria.tabby.Model.Person;
import com.example.daiverandresdoria.tabby.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {

    private int Layout;
    private Context context;
    private List<Person> list;

    public ListViewAdapter(int layout, Context context, List<Person> list) {
        Layout = layout;
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Person getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(Layout,null);

            holder = new ViewHolder();
            holder.name = (TextView)convertView.findViewById(R.id.Name);
            holder.contry = (TextView)convertView.findViewById(R.id.Contry);
            holder.Flag = (ImageView)convertView.findViewById(R.id.flag);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        Person person = getItem(position);
        holder.name.setText(person.getName());
        holder.contry.setText(person.getCountry().getCountryname());
        String URL = person.getCountry().getFlag();
        Picasso.with(context).load(URL).into(holder.Flag);
        return convertView;
    }

    static class ViewHolder{
        private TextView name;
        private TextView contry;
        private ImageView Flag;
    }
}
