package com.example.user.bmicalc;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class bmicalc_main extends AppCompatActivity {
    EditText results_name;
    EditText results_email;
    EditText results_password;
    EditText results_healthcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmicalc_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        results_name = findViewById(R.id.editText4);
        results_email = findViewById(R.id.editText6);
        results_password = findViewById(R.id.editText6);
        results_healthcard = findViewById(R.id.editText7);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


            InClassDatabaseHelper helper = new InClassDatabaseHelper(this);
            SQLiteDatabase db = helper.getWritableDatabase();

            //run a cursor
            Cursor cursor = db.query(InClassDatabaseHelper.TABLE_NAME, new String[]
                            {"NAME", "PASSWORD", "DATE"},
                    null, null, null, null, null);

            if (cursor.moveToFirst())

            {
                String name = cursor.getString(0);
                //  String name = cursor.getString(0);
                String card = cursor.getString(2);
                // String password = cursor.getString(3);

                results_name.setText(name);
                results_healthcard.setText(card);
            }
            cursor.close();
            db.close();

    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bmicalc_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    public void onClickEvent(View view)
    {
        if(results_name.getText().toString().matches("") || results_healthcard.getText().toString().matches("")
                || results_email.getText().toString().matches("") || results_password.getText().toString().matches(""))
        {
            Toast.makeText(this, "You did not enter all the details", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, TestActivity.class);
            startActivity(intent);
        }

    }
}
