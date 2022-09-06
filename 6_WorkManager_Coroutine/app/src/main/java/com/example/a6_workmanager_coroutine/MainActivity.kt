package com.example.a6_workmanager_coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

//WorkManager + Coroutine

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val workManager = OneTimeWorkRequestBuilder<WorkManager2>().build()

        WorkManager.getInstance(this).enqueue(workManager)
    }
}