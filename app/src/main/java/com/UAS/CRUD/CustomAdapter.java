package com.UAS.CRUD;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String[]> {

    private Context mContext;
    private ArrayList<String[]> mData;

    public CustomAdapter(Context context, ArrayList<String[]> data) {
        super(context, 0, data);
        mContext = context;
        mData = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.list_item_layout, parent, false);
        }

        String[] itemData = mData.get(position);

        TextView textName = listItem.findViewById(R.id.textName);
        TextView textContact = listItem.findViewById(R.id.textContact);
        TextView textDOB = listItem.findViewById(R.id.textDOB);

        textName.setText(itemData[0]);
        textContact.setText(itemData[1]);
        textDOB.setText(itemData[2]);

        return listItem;
    }
}
