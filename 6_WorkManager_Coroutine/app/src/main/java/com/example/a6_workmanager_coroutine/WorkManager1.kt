package com.example.a6_workmanager_coroutine

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class WorkManager1(context : Context, workerParameters: WorkerParameters) : Worker(context, workerParameters) {
    override fun doWork(): Result {

        return Result.success()
    }
}