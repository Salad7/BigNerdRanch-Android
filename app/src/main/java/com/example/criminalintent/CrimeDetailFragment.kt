package com.example.criminalintent

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.fragment.app.Fragment
import java.util.*

class CrimeDetailFragment : Fragment() {
    private lateinit var crime :Crime
    private lateinit var crimeTitle :EditText
    private lateinit var crimeCheckBox :CheckBox
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_crime,container, false)
        crime = Crime(UUID.randomUUID(),"Text",Date(),false)
        crimeTitle = v.findViewById(R.id.title_et)
        crimeCheckBox = v.findViewById(R.id.checkBox)
        crimeTitle.addTextChangedListener(object: TextWatcher{
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                crime.title = p0.toString()
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //
            }

            override fun afterTextChanged(p0: Editable?) {
                //
            }
        })
        crimeCheckBox.isChecked = crime.isSolvedd()
        crimeCheckBox.setOnCheckedChangeListener { _, isChecked ->
            crime.setSolved(!crime.isSolvedd())
        }

        return v
    }
}