package com.example.a2_viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel

/*
ViewModel 에서 아래와 같이 변수하나만 만들어서
사용하지는 않고 LiveData 등을 이용해서 함께 사용함
 */
class MainViewModel : ViewModel(){

    var countValue = 0

    fun plus(){
        countValue++
        Log.d("MainViewModel", countValue.toString())
    }

    fun minus(){
        countValue--
        Log.d("MainViewModel", countValue.toString())
    }

    fun getCount() : Int {
        return countValue
    }
}