package com.example.mrmjo.listviewwithcheckboxes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class CAdapter extends BaseAdapter {

    private final ArrayList<String> arrayList1;
    private final ArrayList<String> arrayList2;
    private final Context applicationContext;
    CAdapter.ViewHolder viewHolder;

    private static class ViewHolder {
        TextView txtGame;
        TextView txtCompany;
        CheckBox checkBox;
    }


    public CAdapter(ArrayList<String> arrayList1, ArrayList<String> arrayList2, Context applicationContext) {
        this.arrayList1 = arrayList1;
        this.arrayList2 = arrayList2;
        this.applicationContext = applicationContext;
    }


    @Override
    public int getCount() {
        return arrayList1.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList1.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View result;

        if (convertView == null) {
            viewHolder = new CAdapter.ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.second_layout, parent, false);

            viewHolder.txtGame = convertView.findViewById(R.id.tvGame);
            viewHolder.txtCompany = convertView.findViewById(R.id.tvCompany);


            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (CAdapter.ViewHolder) convertView.getTag();
            result = convertView;
        }


        viewHolder.txtGame.setText(arrayList1.get(position));
        viewHolder.txtCompany.setText(arrayList2.get(position));


        return result;


    }
}
