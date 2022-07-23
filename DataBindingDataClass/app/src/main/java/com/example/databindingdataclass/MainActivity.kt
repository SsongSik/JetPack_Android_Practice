package com.example.databindingdataclass

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.databindingdataclass.databinding.ActivityMainBinding

//DataBinding
//이름처럼, 데이터를 연결해줄 수 없을까?
//데이터 결합

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    var testCount = 25

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        /*
        기존의 방법으로 binding. 으로 접근한다면
        findViewById를 대체하는 ViewBinding와의 차이점은 없는 것
         */

        //데이터 결합
        val person=Person("윤성식", 25)
        binding.person = person

    }

    fun myClick(view : View){
        Log.d("MainActivity", "onClick")
        testCount++

        val person=Person("윤성식", testCount)
        binding.person = person
    }
}