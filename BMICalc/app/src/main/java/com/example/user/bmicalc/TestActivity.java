package com.example.user.bmicalc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TestActivity extends AppCompatActivity {

    EditText weight_val;
    EditText height_val;
    TextView tv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        weight_val = (EditText) findViewById(R.id.wgt);
        height_val  = (EditText) findViewById(R.id.hgt);
        tv4  = (TextView) findViewById(R.id.tv4);
    }



    public void onClickEvent(View v)
    {
        String weight1 = weight_val.getText().toString();
        String height1 = height_val.getText().toString();

        float weight = Float.parseFloat(weight1);
        float height = Float.parseFloat(height1)/100;

        //Calculate BMI value
        float bmiValue = calculateBMI(weight, height);

        //Define the meaning of the bmi value
        String bmiInterpretation = interpretBMI(bmiValue);

        tv4.setText(String.valueOf(bmiValue + "-" + bmiInterpretation));
    }

    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    // Interpret what BMI means
    private String interpretBMI(float bmiValue) {

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
