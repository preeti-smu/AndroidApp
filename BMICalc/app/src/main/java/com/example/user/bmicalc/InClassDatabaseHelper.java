package com.example.user.bmicalc;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.content.Context;
import java.util.Date;

/**
 * Created by User on 2/3/2018.
 */

public class InClassDatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "inclass";  // name of the DB
    private static final int DB_VERSION = 1;  // version of the DB
    public static final String TABLE_NAME = "PERSON";  // name of the Tablepublic
    public static final String TABLE_NAME_BMI = "BMIValues";  // name of the Tablepublic


    public InClassDatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT,"
                + "PASSWORD TEXT,"
                + "HEALTH_CARD_NUMB TEXT,"
                + "DATE INTEGER);");

        Date today = new Date();
        ContentValues personValues = new ContentValues();
        personValues.put("NAME", "Preeti Padelkar");
        personValues.put("PASSWORD", "Super Secret");
        personValues.put("HEALTH_CARD_NUMB", "1234 5678 9101");
        personValues.put("DATE", today.getTime());

        db.insert(TABLE_NAME, null, personValues);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public void InsertData(double weight , double height , double bmi)
    {
        SQLiteDatabase db= this.getWritableDatabase();

        db.execSQL("CREATE TABLE " + TABLE_NAME_BMI + "("
                + "WEIGHT DOUBLE,"
                + "HEIGHT DOUBLE,"
                + "BMI DOUBLE,"
                + "DATE TEXT);");

        Date today = new Date();

        ContentValues bmiValues = new ContentValues();
        bmiValues.put("WEIGHT", weight);
        bmiValues.put("HEIGHT", height);
        bmiValues.put("BMI", bmi);
        bmiValues.put("DATE",today.toString());

        db.insert(TABLE_NAME_BMI, null, bmiValues);
    }

}