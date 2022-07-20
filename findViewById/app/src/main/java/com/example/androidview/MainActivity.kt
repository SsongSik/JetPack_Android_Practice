package com.example.androidview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

//findViewById
//kotlin Extensions
// -> ViewBinding, DataBinding을 사용해라

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val btn1 : Button = findViewById(R.id.btn1)
//        btn1.text = "abcd"
//
//        val btn2 : Button = findViewById(R.id.btn2)
//        btn2.text = "abcd"
//
//        val btn3 : Button = findViewById(R.id.btn3)
//        btn3.text = "abcd"

        //만일 버튼이 100개라면 findViewById로 100개를 적어야함
        //가독성이 떨어지고 불편함

        //kotlin Extensions
        //구글에서 사용하지 말라고 권장함
        btn1.text = "abcd"
        btn2.text = "abcd"
        btn3.text = "abcd"

        //다른 액티비티에 있는 것을 건드릴 위험이 있음
        //문제가 발생할 수 있음
        secondBtn.text = "qwe"
    }
}