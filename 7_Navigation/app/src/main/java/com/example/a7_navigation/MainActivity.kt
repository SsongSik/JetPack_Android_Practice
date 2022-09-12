package com.example.a7_navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
기존에는 beginTransaction 을 통해 화면 이동을 했었음

//1 -> 2 -> 3 -> 4 -> 5
backbutton -> 5 -> 4 -> 3 -> 2 -> 1
5 -> 1

// enterAnim -> A -> B 갈 때 B가 보이는 방식
// exitAnim -> A -> B 갈 때 A가 사라지는 방식
// popEnterAnim -> 뒤로가기 B -> A로 올 때 A가 나타나는 방식
// popExitAnim -> 뒤로가기로 B -> A로 올 때 B가 사라지는 방식
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}