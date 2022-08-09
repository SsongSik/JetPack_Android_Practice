package com.example.a2_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

/*
안드로이드의 생명주기를 관리하기 쉽다.

onSaveInstanceState() 사용해서 데이터를 관리할 수 있지만
적절하지 않다.

상태(LifeCycle)가 변경될 때 마다 데이터를 관리해줘야 하는데
이 관리가 편하다.

UI 컨트롤러 (Activity, Fragment)에서 모든 것을 다 하려고 하면 복잡해지는데,
그래서 ViewModel을 사용하면 테스트나 관리가 용이하다.
 */
class MainActivity : AppCompatActivity() {

//    private var countValue = 0

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        Log.d("MainAcitivty", "onCreate")

        val plusBtn : Button = findViewById(R.id.plus)
        val minusBtn : Button = findViewById(R.id.minus)

        val resultArea : TextView = findViewById(R.id.result)

        resultArea.text = viewModel.countValue.toString()

        plusBtn.setOnClickListener{
            viewModel.plus()
            resultArea.text = viewModel.countValue.toString()
//            countValue++
//            resultArea.text = countValue.toString()
        }
        minusBtn.setOnClickListener {
            viewModel.minus()
            resultArea.text = viewModel.countValue.toString()
//            countValue--
//            resultArea.text = countValue.toString()
        }
    }

    override fun onStart() {
        super.onStart()

        Log.d("MainAcitivty", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MainAcitivty", "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MainAcitivty", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MainAcitivty", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MainAcitivty", "onDestroy")
    }
}