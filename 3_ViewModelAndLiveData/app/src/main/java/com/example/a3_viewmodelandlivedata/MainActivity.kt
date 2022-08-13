package com.example.a3_viewmodelandlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

/*
분리해서 사용하면 화면을 뒤집여저도 값이 유지됨.
라이브데이터를 액티비티에 같이 넣으면 액티비티의 생명주기에 따라 데이터가 사라질 수 있음
 */
class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        findViewById<Button>(R.id.btnArea).setOnClickListener {
            viewModel.plusLiveDataValue()
        }

        viewModel.testMutableLiveData.observe(this, Observer {
            findViewById<TextView>(R.id.textArea).text = viewModel.testMutableLiveData.value.toString()
        })

    }
}