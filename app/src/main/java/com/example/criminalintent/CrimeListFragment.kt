package com.example.criminalintent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import java.util.*

class CrimeListFragment : Fragment() {
    private var m_crimes = ArrayList<Crime>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initCrimes()

        var v = inflater.inflate(R.layout.fragment_crime_list,container,false)
        return v
    }

    fun initCrimes(){
        for (i in 0..100){
            if(i % 2 == 0){
                var cri = Crime(UUID.randomUUID(),i.toString(),Date(),false)
                m_crimes.add(cri)
            }
            else{
                var cri = Crime(UUID.randomUUID(),i.toString(),Date(),true)
                m_crimes.add(cri)

            }
        }
    }
}