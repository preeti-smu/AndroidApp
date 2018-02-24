package com.example.user.bmicalc;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 2/23/2018.
 */

public class ListAdapter extends ArrayAdapter{
    List list = new ArrayList();
    public ListAdapter(Context context,int resource){
        super(context,resource);
    }

    static class LayoutHandler
    {
        TextView Weight, Height, BMI, Date_value;
    }

    @Override
    public void add(Object obj)
    {
        super.add(obj);
        list.add(obj);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View row = convertView;
        LayoutHandler layoutHandler;
        if(row==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler = new LayoutHandler();
            layoutHandler.Weight = (TextView)row.findViewById(R.id.txt_weight);
            layoutHandler.Height = (TextView)row.findViewById(R.id.txt_height);
            layoutHandler.BMI = (TextView)row.findViewById(R.id.txt_bmi);
            layoutHandler.Date_value = (TextView)row.findViewById(R.id.txt_date);
            row.setTag(layoutHandler);
        }else
        {
            layoutHandler = (LayoutHandler)row.getTag();
        }
        BMIResult bmiResult = (BMIResult)this.getItem(position);
        Double wgt = bmiResult.getWeight();
        Double hgt = bmiResult.getHeight();
        layoutHandler.Weight.setText(Double.toString(hgt));

        layoutHandler.Height.setText(Double.toString(wgt));
        Double bmi = bmiResult.getResult();

        DecimalFormat df_2 = new DecimalFormat("0.00");
        String bmi_value = df_2.format(bmi);

        layoutHandler.BMI.setText(bmi_value);
        layoutHandler.Date_value.setText(bmiResult.getDate());
        //Log.d("Weight in listadapter:",Double.toString(hgt)+ " Height in listadapter : " +Double.toString(wgt)+ " BMI in listadapter : " +bmi_value);
        return row ;
    }
}
