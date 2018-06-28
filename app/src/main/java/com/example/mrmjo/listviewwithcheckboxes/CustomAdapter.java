package com.example.mrmjo.listviewwithcheckboxes;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class CustomAdapter extends ArrayAdapter {

    private ArrayList dataSet;
    Context mContext;
    ViewHolder viewHolder;

    private static class ViewHolder {
        TextView txtName;
        TextView txtVersion;
        CheckBox checkBox;
        Button btn1;
    }

    public CustomAdapter(ArrayList data, Context context) {
        super(context, R.layout.row_item, data);
        this.dataSet = data;
        this.mContext = context;

    }

    @Override
    public int getCount() {

        return dataSet.size();
    }

    @Override
    public DataModel getItem(int position) {

        return (DataModel) dataSet.get(position);
    }

    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {

        final View result;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false);
            viewHolder.txtName = convertView.findViewById(R.id.tvtxtName);
            viewHolder.txtVersion = convertView.findViewById(R.id.tvDesig);
            viewHolder.checkBox = convertView.findViewById(R.id.cbcheckBox);
            viewHolder.btn1 = convertView.findViewById(R.id.ibtn1);
            result = convertView;
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        DataModel item = getItem(position);

        viewHolder.txtName.setText(item.name);
        viewHolder.txtVersion.setText(item.version);
        viewHolder.checkBox.setChecked(item.checked);


        viewHolder.btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                PopupMenu popup = new PopupMenu(mContext, v);

                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

                    public boolean onMenuItemClick(MenuItem item) {

                        dataSet.remove(position);
                        notifyDataSetChanged();

                        return true;
                    }
                });

                popup.show();
            }

        });

        return result;
    }
}