package com.example.criminalintent;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.criminalintent.Database.CrimeBaseHelper;

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

    public void addCrime(Crime c){
        mCrimes.add(c);
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
