package com.example.a4_coroutineviewmodelscope

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
간단한 코투린 / ViewModelScope
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val goToSecond = findViewById<Button>(R.id.goToSecond)

        goToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }


//        Log.d("TEST", "START")
//        CoroutineScope(Dispatchers.IO).launch {
//            Log.d("TEST", "CoroutineScope START")
//            a()
//            b()
//            Log.d("TEST", "CoroutineScope END")
//        }
//        Log.d("TEST", "END")

        //start -> end -> AP1 -> BP1 -> AP2 -> BP2
        //이런식으로 예상할 수 있음
    }

    suspend fun a() {

        //a작업은 오래 걸려서 2초정도
        delay(1000)
        Log.d("TEST", "AP1")

        delay(1000)
        Log.d("TEST", "AP2")
    }

    suspend fun b() {
        //b작업은 오래 걸려서 2초정도
        delay(1000)
        Log.d("TEST", "BP1")

        delay(1000)
        Log.d("TEST", "BP2")
    }
}