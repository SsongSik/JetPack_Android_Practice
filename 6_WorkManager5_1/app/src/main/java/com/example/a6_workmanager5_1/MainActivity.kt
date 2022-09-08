package com.example.a6_workmanager5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

/*
WorkManager 고유 작업
작업 관리
중복 작업을 방지하려면
24시간 마다 로그를 업로드 하려고 시도할 때
한 번만 해야하는데 여러 번 추가되는 상황이 발생하기도함
따라서 이 때 사용 가능.
고유 작업을 사용하면 중복 예약 문제를 해결할 수 있다.

충돌하면 여러 가지 옵션이 존재함
Replace, keep ,append 등
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val testBtn = findViewById<Button>(R.id.testBtn)
        testBtn.setOnClickListener {
            //기존에 했던 방식
            val testWorkManager = OneTimeWorkRequestBuilder<TestWorkManager>().build()
//            WorkManager.getInstance(this).enqueue(testWorkManager)

            //새로운 방식
            //끝나고 눌러야 재실행됨
//            WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.KEEP, testWorkManager)

            //한번 더누르면 기존에 있던 것이 없어지고 다시 실행됨
            WorkManager.getInstance(this).enqueueUniqueWork("test", ExistingWorkPolicy.REPLACE, testWorkManager)


        }
    }
}