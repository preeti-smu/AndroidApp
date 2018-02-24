package com.example.user.bmicalc;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.*;

public class DataListLayoutActivity extends AppCompatActivity {
    ListView listView;
    InClassDatabaseHelper userDBhelper;
    Cursor cursor;
    SQLiteDatabase sqliteDatabase;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_list);
        listView = (ListView) findViewById(R.id.list_view);
        userDBhelper = new InClassDatabaseHelper(getApplicationContext());
        sqliteDatabase = userDBhelper.getReadableDatabase();
        cursor = userDBhelper.getData();
        listAdapter = new ListAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listAdapter);

        if(cursor.moveToFirst())
        {
            do {
                Double weight,height,bmi;
                weight= cursor.getDouble(0);
                height= cursor.getDouble(1);
                bmi = cursor.getDouble(2);
                Date date_value = new Date();
                BMIResult bmiResult = new BMIResult(weight ,height,bmi,date_value.toString());
            }
            while(cursor.moveToNext());
        }
    }
}
