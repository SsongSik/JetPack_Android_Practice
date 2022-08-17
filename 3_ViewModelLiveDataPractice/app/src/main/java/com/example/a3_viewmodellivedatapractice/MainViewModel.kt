package com.example.a3_viewmodellivedatapractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var _mutableWord = MutableLiveData("")
    val liveWord : LiveData<String>
    get() = _mutableWord

    private var _randommutableWord = MutableLiveData("")
    val randomliveWord : LiveData<String>
        get() = _randommutableWord

    init{
        getNextData()
    }

    fun getNextData(){
        val currentWord = testDataList.random()
        val randomWord = currentWord.toCharArray()
        randomWord.shuffle()

        _mutableWord.value = currentWord
        _randommutableWord.value = String(randomWord)
    }

    val newData = Transformations.switchMap(liveWord){
        getRandomWordSuffeld(it)
    }

    fun getRandomWordSuffeld(word : String) : MutableLiveData<String>{
        val liveData = MutableLiveData("")
        val randomTestWord = word.toCharArray()
        randomTestWord.shuffle()
        liveData.value = String(randomTestWord)
        return liveData
    }

}