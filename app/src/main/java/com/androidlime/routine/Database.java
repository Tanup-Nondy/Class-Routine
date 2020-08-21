package com.androidlime.routine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class Database extends SQLiteOpenHelper {
    private static final String Dbname="routine";
    private static final String Id="id";
    private static final String Table="class";
    private static final String Day="day";
    private static final String Class="classes";
    private static final String Time="time";
    private static String q;
    public Database(Context context) {
        super(context,Dbname,null,10);
    }
    public void CreateTable(){
        SQLiteDatabase db=this.getWritableDatabase();
        String sun="CREATE TABLE Sunday"+" ( "+Id+" INTEGER PRIMARY KEY, "+Class+" TEXT, "+Time+" TEXT"+")";
        String mon="CREATE TABLE Monday"+" ( "+Id+" INTEGER PRIMARY KEY, "+Class+" TEXT, "+Time+" TEXT"+")";
        String tue="CREATE TABLE Tuesday"+" ( "+Id+" INTEGER PRIMARY KEY, "+Class+" TEXT, "+Time+" TEXT"+")";
        String wed="CREATE TABLE Wednesday"+" ( "+Id+" INTEGER PRIMARY KEY, "+Class+" TEXT, "+Time+" TEXT"+")";
        String thur="CREATE TABLE Thursday"+" ( "+Id+" INTEGER PRIMARY KEY, "+Class+" TEXT, "+Time+" TEXT"+")";
        String sund="Drop TABLE IF EXISTS Sunday";
        String mond="Drop TABLE IF EXISTS Monday";
        String tued="Drop TABLE IF EXISTS Tuesday";
        String wedd="Drop TABLE IF EXISTS Wednesday";
        String thrsd="Drop TABLE IF EXISTS Thursday";
        db.execSQL(sund);
        db.execSQL(mond);
        db.execSQL(tued);
        db.execSQL(wedd);
        db.execSQL(thrsd);
        db.execSQL(sun);
        db.execSQL(mon);
        db.execSQL(tue);
        db.execSQL(wed);
        db.execSQL(thur);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String q="CREATE TABLE sample"+" ( "+Id+" INTEGER PRIMARY KEY, "+Day+" TEXT, "+Class+" TEXT "+")";
        db.execSQL(q);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS sample");
        onCreate(db);
    }
    void insert(String d,String c,String t){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(Class,c);
        cv.put(Time,t);
        db.insert(d,null,cv);
        db.close();

    }
    String[] show(String day) {
        SQLiteDatabase sw = this.getReadableDatabase();

        String[] s = new String[0];
        try {
            String query = "SELECT * FROM " + day;

            Cursor c = sw.rawQuery(query, null);
            s = new String[c.getCount()];
            c.moveToFirst();
            if (c.moveToFirst()) {
                int count = 0;
                do {
                    s[count] = "Class name: " + c.getString(c.getColumnIndex(Class + "")) + "\nTime: " +
                            c.getString(c.getColumnIndex(Time + "")) + "\n";
                    count++;
                } while (c.moveToNext());
            }

        } catch (SQLException e) {
            Log.d("Routine not found", "show: Create the routine first");
        }
        return s;
    }

}
