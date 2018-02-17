package com.example.user.bmicalc;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class BMIListActivity extends ListActivity {
    //BMIResult[] results = { new BMIResult(5.5,100),new BMIResult(4.3,155)};

    ArrayList<BMIResult> results = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ListView listBMIResults = getListView();
       // listBMIResults = (ListView) findViewById( R.id.mainListView );
        InClassDatabaseHelper helper = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        //run a cursor
        Cursor cursor = db.query(InClassDatabaseHelper.TABLE_NAME_BMI, new String[]
                        {"WEIGHT", "HEIGHT", "BMI", "DATE"},
                null, null, null, null, null);

        if(cursor.moveToFirst())

        {
            do {
                Double weight = Double.parseDouble(cursor.getString(0));
                Double height = Double.parseDouble(cursor.getString(1));
                Double bmi = Double.parseDouble(cursor.getString(2));
                String date_value = cursor.getString(3);
                results.add(new BMIResult(weight,height,bmi,date_value));
            }
            while (cursor.moveToNext());

        }

        ArrayAdapter<BMIResult> listAdapter = new ArrayAdapter<BMIResult>(
                this,
                android.R.layout.simple_list_item_1,
                results
        );
        listBMIResults.setAdapter(listAdapter);

        cursor.close();
        db.close();

    }

    public void onListItemClick(ListView listView, View itemView, int position, long id)
    {
        //System.out.println("Clicked on "+ results[position].toString());
        String selectedValue = (String) getListAdapter().getItem(position);
        Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();

    }
    }
