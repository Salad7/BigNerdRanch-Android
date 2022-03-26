package com.example.criminalintent.Database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.example.criminalintent.Crime;

public class CrimeCursorWrapper extends CursorWrapper {

    public CrimeCursorWrapper(Cursor cursor){
        super(cursor);
    }

    public Crime getCrime(){
        String uuidString = getString(getColumnIndex(CrimeDbSchema.UUID));
        String title = getString(getColumnIndex(CrimeDbSchema.TITLE));
        long date = getLong(getColumnIndex(CrimeDbSchema.DATE));
        int isSolved = getInt(getColumnIndex(CrimeDbSchema.SOLVED));

     return null;
    }
}
