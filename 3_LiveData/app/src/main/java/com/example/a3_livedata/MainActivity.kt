package com.example.a3_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/*
LiveData

데이터를 관찰해줄 수 있는 친구(LifeCycle과 결합해서)
 */
class MainActivity : AppCompatActivity() {

    private var testMutableLiveData = MutableLiveData(0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnArea).setOnClickListener {
            testMutableLiveData.value = testMutableLiveData.value!!.plus(1)
        }

        //데이터가 변할 때 마다 관찰해줄 수 있는 친구
        testMutableLiveData.observe(this, Observer {
            Log.d("testMutableLiveData", testMutableLiveData.value.toString())
            findViewById<TextView>(R.id.textArea).text = testMutableLiveData.value.toString()
        })//변경될 때 마다 로그가 찍힘
        //
    }
}