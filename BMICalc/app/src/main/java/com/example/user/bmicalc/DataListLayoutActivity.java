package com.example.user.bmicalc;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DecimalFormat;

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
        listView = (ListView) findViewById(R.id.listview);
        userDBhelper = new InClassDatabaseHelper(getApplicationContext());
        sqliteDatabase = userDBhelper.getReadableDatabase();
        cursor = userDBhelper.getData();
        listAdapter = new ListAdapter(getApplicationContext(),R.layout.row_layout);
        listView.setAdapter(listAdapter);
        //Log.d("In dataList java class ","Hello");

        if(cursor.moveToFirst())
        {
            do {
               // Log.d("In cursor do while","Hello");
                Double weight,height,bmi;
                weight= cursor.getDouble(0);
                height= cursor.getDouble(1);
                bmi = cursor.getDouble(2);
                //Date date_value = new Date();
               // double d = 28.6537625367;
                DecimalFormat df_2 = new DecimalFormat("0.00");
                String bmi_value = df_2.format(bmi);
                //Log.d("Decimal sample :",df_2.format(d));

                Date c = Calendar.getInstance().getTime();
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c);
                Double BMI = Double.parseDouble(bmi_value);
                BMIResult bmiResult = new BMIResult(weight ,height,BMI,formattedDate.toString());
                listAdapter.add(bmiResult);
                Log.d("Weight :",Double.toString(weight)+ " Height : " +Double.toString(height)+ " BMI : " +Double.parseDouble(bmi_value));
            }
            while(cursor.moveToNext());
        }
    }
}
