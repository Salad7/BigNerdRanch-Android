package com.example.criminalintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager

class CrimeActivity : AppCompatActivity() {

    lateinit var fragManager :FragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragManager = supportFragmentManager
        fragManager.beginTransaction().add(R.id.fragment_container,CrimeDetailFragment()).commit()


    }
}