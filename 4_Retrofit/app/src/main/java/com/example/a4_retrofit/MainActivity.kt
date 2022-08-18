package com.example.a4_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*
Retrofit2

Server, LocalDB 에서 데이터를 받아옴
(Retrofit), (ROOM)

코틀린(Kotlin)
코루틴(Coroutine)
비동기적으로 실행되는 코드를 간소화하기 위해
ViewModel, WorkManager + Coroutine

Simple Retrofit Ex
JSONPlaceholder
https://jsonplaceholder.typicode.com/
https://jsonplaceholder.typicode.com/posts/2
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val api = RetrofitInstance.getInstance().create(MyApi::class.java)
        api.getPost1().enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API1", response.body().toString())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API1", "fail")
            }

        })

        api.getPostNumber(3).enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API2", response.body().toString())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API2", "fail")
            }

        })
    }
}