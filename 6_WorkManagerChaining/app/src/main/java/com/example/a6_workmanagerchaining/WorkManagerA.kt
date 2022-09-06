package com.example.a6_workmanagerchaining

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Thread.sleep

class WorkManagerA(context : Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {

    override fun doWork(): Result {

        for(i in 0..3){
            sleep(1000)
            Log.d("WorkManagerA", i.toString())

        }

        return Result.success()
    }

}