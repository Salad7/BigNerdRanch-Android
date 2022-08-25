package com.example.criminalintent

import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.runner.RunWith
@RunWith(AndroidJUnit4::class)

class CrimeActivityTest {

    private lateinit var scenario: ActivityScenario<CrimeActivity>
    @Before
    fun setUp() {
        var crime = CrimeActivity()
//        scenario = launch(CrimeActivity::class.java)
    }

    @After
    fun tearDown() {
    }
}