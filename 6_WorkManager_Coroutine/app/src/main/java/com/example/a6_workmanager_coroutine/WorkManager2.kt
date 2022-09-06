package com.example.a6_workmanager_coroutine

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class WorkManager2(context : Context, params : WorkerParameters) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {

        //Dispatchers 가 디폴트인데 이것을 이렇게 변경해줄 수 있음
        withContext(Dispatchers.IO) {
            test1()
            test2()
        }

        return Result.success()
    }

    suspend fun test1(){
        for(i in 1..3){
            delay(1000)
            Log.d("WorkManager2 test1", i.toString())
        }
    }

    suspend fun test2(){
        for(i in 1..3) {
            delay(1000)
            Log.d("WorkManager2 test2", i.toString())
        }
    }
}