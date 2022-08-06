package com.example.messagedemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var sendBtn : Button;
    lateinit var messageet :EditText
    lateinit var rvlist :RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sendBtn = findViewById(R.id.send_btn)
        messageet = findViewById(R.id.message_et);
        rvlist = findViewById(R.id.rvlist);


    }
}