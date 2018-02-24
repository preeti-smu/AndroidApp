package com.example.user.bmicalc;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    EditText weight_val;
    EditText height_val;
    TextView tv4;
    TextView tv5;
    InClassDatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        helper  = new InClassDatabaseHelper(this);
        SQLiteDatabase db = helper.getWritableDatabase();

        weight_val = (EditText) findViewById(R.id.wgt);
        height_val  = (EditText) findViewById(R.id.hgt);
        tv4  = (TextView) findViewById(R.id.tv4);

    }



    public void onClickEvent(View v)
    {
        String weight1 = weight_val.getText().toString();
        String height1 = height_val.getText().toString();

        double weight = Double.parseDouble(weight1);
        double height = Double.parseDouble(height1)/100;

        //Calculate BMI value
        double bmiValue = calculateBMI(weight, height);

        //Define the meaning of the bmi value
        String bmiInterpretation = interpretBMI(bmiValue);

        tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));

        helper.InsertData(weight,height,bmiValue);
    }

    public void onClickEventList(View view)
    {

        Intent intent = new Intent(this, DataListLayoutActivity.class);
        startActivity(intent);
    }

    private double calculateBMI (double weight, double height) {
        return (double) (weight / (height * height));
    }

    // Interpret what BMI means
    private String interpretBMI(double bmiValue) {

        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {

            return "Underweight";
        } else if (bmiValue < 25) {

            return "Normal";
        } else if (bmiValue < 30) {

            return "Overweight";
        } else {
            return "Obese";
        }
    }

}
