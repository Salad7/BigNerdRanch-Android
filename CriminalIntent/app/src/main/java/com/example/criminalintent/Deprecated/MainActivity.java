package com.example.criminalintent.Deprecated;

import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;

import com.example.criminalintent.CrimeFragment;
import com.example.criminalintent.SingleFragmentActivity;

import java.util.UUID;

public class MainActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
    }


    private static final String EXTRA_CRIME_ID = "criminalintent_id";
    public static Intent newIntent(Context packageContext, UUID crimeID){
        Intent intent = new Intent(packageContext,MainActivity.class);
        intent.putExtra(EXTRA_CRIME_ID,crimeID);
        return intent;
    }
}