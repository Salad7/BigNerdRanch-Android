package com.example.criminalintent

import junit.framework.TestCase
import org.junit.Assert.assertEquals
import org.junit.Test
import java.util.*

class CrimeTest {

    @Test
    fun properCrimeName(){
        var crime = Crime(UUID(0,0),"Title")
        assertEquals("Title",crime.title)
    }

}