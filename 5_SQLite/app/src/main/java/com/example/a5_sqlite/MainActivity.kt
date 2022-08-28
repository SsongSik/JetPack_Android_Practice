package com.example.a5_sqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}