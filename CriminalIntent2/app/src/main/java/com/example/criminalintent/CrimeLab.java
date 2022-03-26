package com.example.criminalintent;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.criminalintent.Database.CrimeBaseHelper;
import com.example.criminalintent.Database.CrimeDbSchema;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CrimeLab {

    private static CrimeLab sCrimeLab;
    private ArrayList<Crime> mCrimes;
    private Context context;
    private SQLiteDatabase mDatabase;

    public static CrimeLab get(Context context){
        if (sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    public void addCrime(Crime c)
    {
        ContentValues values = getContentValues(c);
        mDatabase.insert(CrimeDbSchema.CrimeTable.name,null,values);
    }

    private Cursor queryCrimes(String whereClause, String[] whereArgs){
        Cursor cursor = mDatabase.query(
                CrimeDbSchema.CrimeTable.name,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        )
    }

    public void updateCrime(Crime crime) {
        String uuidString = crime.getmId().toString();
        ContentValues values = getContentValues(crime);
        mDatabase.update(CrimeDbSchema.CrimeTable.name, values,
                CrimeDbSchema.UUID + " = ? ",
                new String[]{uuidString});

    }
    private CrimeLab(Context context){
        this.context  = context;
        mDatabase = new CrimeBaseHelper(context).getWritableDatabase();
        mCrimes = new ArrayList<>();
//        for(int i = 0; i < 100; i++){
//            Crime crime = new Crime();
//            crime.setmTitle("Crime #"+i);
//            crime.setSolved(i % 2 == 0);
//            mCrimes.add(crime);
//        }
    }

    private static ContentValues getContentValues(Crime crime){
        ContentValues contentValues = new ContentValues();
        contentValues.put(CrimeDbSchema.UUID, crime.getmId().toString());
        contentValues.put(CrimeDbSchema.TITLE, crime.getmTitle().toString());
        contentValues.put(CrimeDbSchema.DATE, crime.getDate().getTime());
        contentValues.put(CrimeDbSchema.SOLVED, crime.getSolved() ? 1 : 0);
        return contentValues;
    }

    public Crime getCrime(UUID id){
        for (Crime crime : mCrimes){
            if(crime.getmId().equals(id)){
                return crime;
            }
        }
        return null;
    }

    public ArrayList<Crime> getCrimes(){
        return mCrimes;
    }





}
