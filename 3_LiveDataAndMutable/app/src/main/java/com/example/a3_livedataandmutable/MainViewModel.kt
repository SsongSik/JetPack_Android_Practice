package com.example.a3_livedataandmutable

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _testMutableLiveData = MutableLiveData(0)

    val testLiveData : LiveData<Int>
        get() = _testMutableLiveData

    fun plusLiveDataValue(){
        _testMutableLiveData.value = _testMutableLiveData.value!!.plus(1)
    }

//    var testMutableLiveData = MutableLiveData(0)
//    // MutableLiveData <-> LiveData
//    /*
//       MutableLiveData는 변경이 가능하지만 LiveData는 변경이 안됨
//
//     */
//    fun plusLiveDataValue(){
//        testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
//    }


}