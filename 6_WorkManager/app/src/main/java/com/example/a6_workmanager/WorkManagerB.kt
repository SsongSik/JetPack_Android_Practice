package com.example.a6_workmanager

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf

class WorkManagerB(context : Context, workerParameters: WorkerParameters) :
    Worker(context, workerParameters){

    override fun doWork(): Result {

        val a = inputData.getInt("a", 1000)
        val b = inputData.getInt("b", 2000)
        val c = inputData.getInt("c", 3000)

        Log.d("WorkManagerB", a.toString())
        Log.d("WorkManagerB", b.toString())
        Log.d("WorkManagerB", c.toString())
        //c는 값이 없기 때문에 디폴트값인 3000이 찍힘

        //완료되고난 다음에 데이터를 다시 넘겨주고 싶을 때
        val output : Data = workDataOf(
            "result" to 10
        )

        return Result.success(output)
    }

}