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
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.subscribeBy

class CrimeFragment : Fragment() {

    lateinit var title :EditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var v = inflater.inflate(R.layout.fragment_crime,container,false)
        title = v.findViewById(R.id.title_et)
        val observable = Observable.just(1,2,3)
        observable.subscribe{
            Log.d("CrimeFragment",it.toString())
        }
        val disposables = CompositeDisposable()
        val createdObservable = Observable.create<Int> { emitter ->
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
            emitter.onComplete()
        }

        val createdSubscriber = createdObservable.subscribeBy(
                onNext = {
                    Log.d("CrimeFragment","created Subscriber: "+it.toString())
                }
        )
       val subscription =  observable.subscribeBy(
                onNext = {
                    Log.d("CrimeFragment","Item is: "+it.toString())
                },
                onError = {

                },
                onComplete = {
                    Log.d("CrimeFragment","Completed the syncing")
                }

        )
        disposables.add(subscription)
        disposables.add(createdSubscriber)
        disposables.dispose()
        return v
    }
}