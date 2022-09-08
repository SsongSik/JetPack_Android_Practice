package com.example.a6_workmanager5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit

/*
WorkManager 주기적 실행
15분 마다/ 30분 마다/1시간 마다 실행하고 싶을 때
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager = PeriodicWorkRequestBuilder<WorkManager1>(15, TimeUnit.MINUTES).build()
        WorkManager.getInstance(this).enqueue(workManager)
    }
}