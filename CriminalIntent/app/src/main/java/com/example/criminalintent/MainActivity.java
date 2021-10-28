package com.example.criminalintent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }


    public static final String EXTRA_CRIME_ID = "criminalintent_id";
    public static Intent newIntent(Context packageContext, UUID crimeID){
        Intent intent = new Intent(packageContext,MainActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeID);
        return intent;
    }
}