package com.example.retrofitdemo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

private lateinit var recycleView : RecyclerView
private lateinit var layoutManager :LinearLayoutManager
class MainActivity : AppCompatActivity() {
    private lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager = LinearLayoutManager(this)
        binding = ActivityMainBinding.inflate(layoutInflater)
        recycleView = findViewById(R.id.rvTodos)
        recycleView.layoutManager = layoutManager
    }
}