package com.example.a6_workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf

/*
WorkManager?

실행을 했는데 사용자가 기다리기 싫어서 나갔을 때
멈춰버림.
이 사용자가 나가도 오래 걸리는 작업같은 경우 : 캘린더 동기화 등
사용자가 앱을 나가버리면 멈춰버림

이 때 workManager를 만들 수 있음
앱을 꺼졌는데도 workManager는 시간이 지난 다음 실행이 됨.
지속적인 작업에 권장되는 솔루션
백그라운드 작업 하기 쉬운데
코루틴을 지원하고, 작업 순서 설정이 가능하다.
A -> 1 / 2
B -> 2 / 1
C -> 3
이런것들까지 해줄 수 있음
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val workManagerA =  OneTimeWorkRequestBuilder<WorkManagerA>().build()
//        WorkManager.getInstance(this).enqueue(workManagerA)

        val myData : Data = workDataOf(
            "a" to 10,
            "b" to 20
        )

        val workManagerB = OneTimeWorkRequestBuilder<WorkManagerB>().setInputData(myData).build()
        WorkManager.getInstance(this).enqueue(workManagerB)

        WorkManager.getInstance(this).getWorkInfoByIdLiveData(workManagerB.id)
            .observe(this, Observer { info ->
                if(info != null && info.state.isFinished){
                    val result = info.outputData.getInt("result", 10000)
                    val result2 = info.outputData.getInt("result", 20000)
                    Log.d("MainActivity", result.toString())
                    Log.d("MainActivity", result2.toString())
                }
            })
    }
}
