package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var text :TextView
    lateinit var rollBtn :Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text = findViewById(R.id.textView)
        rollBtn = findViewById(R.id.button)

        rollBtn.setOnClickListener(View.OnClickListener {
            var rand = (1..6).random()
            text.setText(rand.toString())

        })

    }
}