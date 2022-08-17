package com.example.criminalintent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer

class CrimeFragment : Fragment() {

    lateinit var title :EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_crime,container,false)
        title = v.findViewById(R.id.title_et)
        val observable = Observable.just(1,2,3)
        observable.subscribe{
            Log.d("CrimeFragment",it.toString())
        }

        return v
    }
}