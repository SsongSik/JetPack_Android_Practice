package com.example.a2_viewmodelinfragment

import androidx.lifecycle.ViewModel

class TestFragmentViewModel : ViewModel() {

    var countValue = 0

    fun plus(){
        countValue++
    }
    fun minus(){
        countValue--
    }
}