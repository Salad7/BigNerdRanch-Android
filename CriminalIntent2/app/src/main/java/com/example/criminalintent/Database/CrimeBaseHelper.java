package com.example.criminalintent.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CrimeBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    public CrimeBaseHelper(Context context){
        super(context,DATABASE_NAME,null,VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table "+CrimeDbSchema.CrimeTable.name + "(" +
                " _id integer primary key autoincrement, " +
                CrimeDbSchema.UUID + ", " +
                CrimeDbSchema.TITLE + ", "+
                        CrimeDbSchema.DATE + ", "+
                        CrimeDbSchema.SOLVED+
                CrimeDbSchema.SUSPECT+
                ")"
                );

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
