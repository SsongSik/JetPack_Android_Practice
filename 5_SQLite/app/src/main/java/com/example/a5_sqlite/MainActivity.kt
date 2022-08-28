package com.example.a5_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

/*
네트워크가 끊어져있어도 카톡채팅방은 올라와있음
이 방들은 왜 보일까?
다른 곳에다가 저장을 해두고, 불러오는 방식일 수 있음
우리는 LocalDB 를 이용할 수 있음

Room은 SQLite를 완벽히 활용하면서 원활한 데이터베이스 엑세스가 가능하도록 한다.
-> 반복적이고 오류가 발생하기 쉬운 상용구 코드를 최소하하는 편의 주석

SQLite -> Room
 */
class MainActivity : AppCompatActivity() {

    lateinit var db : SQLiteHelperSample

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = SQLiteHelperSample(this)

        val inputArea = findViewById<EditText>(R.id.inputArea)

        val insertBtn = findViewById<Button>(R.id.insert)
        val getAllBtn = findViewById<Button>(R.id.getAll)
        val deleteBtn = findViewById<Button>(R.id.deleteAll)

        val resultArea = findViewById<TextView>(R.id.resultArea)

        insertBtn.setOnClickListener {
            val inputText = inputArea.text.toString()
            db.insert(inputText)
            inputArea.setText("")
        }

        getAllBtn.setOnClickListener {
            val arr = db.getAllData()
            resultArea.text = arr.toString()
        }

        deleteBtn.setOnClickListener {
            db.deleteAll()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        db.close()
    }
}