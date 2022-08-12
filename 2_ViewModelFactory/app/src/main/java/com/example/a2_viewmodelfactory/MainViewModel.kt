package com.example.a2_viewmodelfactory

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(num : Int) : ViewModel() {

    init{
        Log.d("MainViewModel" , num.toString())
    }
    /*
    repository

    네트워크 통신을 하거나,
    localDB
    room SQLite
    데이터를 ViewModel로 넘겨주고 싶을 때
     */
}