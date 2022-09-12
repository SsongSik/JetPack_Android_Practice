package com.example.a7_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
기존에는 beginTransaction 을 통해 화면 이동을 했었음

//1 -> 2 -> 3 -> 4 -> 5
backbutton -> 5 -> 4 -> 3 -> 2 -> 1
5 -> 1
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}