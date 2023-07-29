package com.UAS.CRUD;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

// ...

// ...

// ...

public class DataTableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_table);

        ListView listView = findViewById(R.id.listView);
        DBHelper DB = new DBHelper(this);

        Cursor res = DB.getdata();
        if (res.getCount() == 0) {
            // Handle the case when no data is available
            return;
        }

        ArrayList<String[]> data = new ArrayList<>();
        while (res.moveToNext()) {
            String name = res.getString(0);
            String contact = res.getString(1);
            String dob = res.getString(2);
            data.add(new String[]{name, contact, dob});
        }

        CustomAdapter adapter = new CustomAdapter(this, data);
        listView.setAdapter(adapter);
    }
}

