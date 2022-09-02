package com.example.a5_room

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.*
import com.example.a5_room.db.TextDatabase
import com.example.a5_room.entity.TextEntity
import com.example.a5_room.entity.WordEntity
import com.example.a5_room.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {

    val context : Context = getApplication<Application>().applicationContext

    val repository = Repository(context)

    private var _textList = MutableLiveData<List<TextEntity>>()
    val textList : LiveData<List<TextEntity>>
        get() = _textList

    private var _wordList = MutableLiveData<List<WordEntity>>()
    val wordList : LiveData<List<WordEntity>>
        get() = _wordList

    //Dispatchers.IO를 사용할 수 있음
    fun getData() = viewModelScope.launch(Dispatchers.IO) {
//        Log.d("MainViewModel", db.textDao().getAllData().toString())
//        Log.d("MainViewModel", db.wordDao().getAllData().toString())
        _textList.postValue(repository.getTextList())
        _wordList.postValue(repository.getWordList())
    }

    fun insertData(text : String) = viewModelScope.launch(Dispatchers.IO) {
//        db.textDao().insert(TextEntity(0, text))
//        db.wordDao().insert(WordEntity(0, text))
        repository.insertTextData(text)
        repository.insertWordData(text)
    }

    fun removeData() = viewModelScope.launch(Dispatchers.IO) {
//        db.textDao().deleteAllData()
//        db.wordDao().deleteAllData()
        repository.deleteTextData()
        repository.deleteWordData()
    }
}