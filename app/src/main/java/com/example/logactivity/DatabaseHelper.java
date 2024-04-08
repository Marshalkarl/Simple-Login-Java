package com.example.logactivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String databaseName = "Signup.db";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Signup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {

        MyDatabase.execSQL("create table allusers(email TEXT primary key, password TEXT)");

        MyDatabase.execSQL("CREATE TABLE reg( filiere TEXT primary key, matiere TEXT, heure TEXT, prof TEXT, salle TEXT, jours  TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int oldVersion, int newVersion) {
        MyDatabase.execSQL("drop table if exists allusers");
        MyDatabase.execSQL("DROP TABLE IF EXISTS reg");
        onCreate(MyDatabase);
    }

    public Boolean insertData(String email, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = MyDatabase.insert("allusers", null, contentValues);

        if (result == -1){
            return false ;
        }else{
            return true;
        }

    }
    public boolean insertReg(String filiere, String matiere, String heure, String prof,String salle, String jours){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("filiere", filiere);
        contentValues.put("matiere",matiere);
        contentValues.put("heure",heure);
        contentValues.put("prof",prof);
        contentValues.put("salle",salle);
        contentValues.put("jours",jours);
        long result = MyDatabase.insert("reg", null, contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ? ", new String[]{email});

        if (cursor.getCount() >0) {
            return true;
        }else{
            return false;
        }
    }

    public Boolean checkReg(String filiere){
        SQLiteDatabase MyDatabase = this.getReadableDatabase();
        Cursor cursor = MyDatabase.rawQuery("SELECT * FROM reg WHERE titre = ?", new String[]{filiere});
        boolean exists = cursor.moveToFirst();
        cursor.close();
        return exists;
    }
    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ? and password = ?" , new String[]{email, password});

        if (cursor.getCount() >0) {
            return true;
        }else{
            return false;
        }

    }


}
