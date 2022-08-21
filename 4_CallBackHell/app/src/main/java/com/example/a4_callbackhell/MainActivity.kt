package com.example.a4_callbackhell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

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

        /*
            순서가 1, 2, 3, 4이렇게 실행되면 좋지만
            이 실행되는 순서는 매우 달라짐.
            ex) 된장찌개
            1. 물끓이기
            2. 두부, 야채 썰기
            3. 양념
            4. 밥 등등
            모두 완료된 상태에서 다음 단계로 넘어간다면 동기적으로 실행된다고 하고,
            이는 비효율적임
            -> 비동기로 변경해야함. 물끓이는 동안 다른 단계를 실행함
            api 호출되는 것은 비동기적으로 실행됨.

            만일, 1에서 유저정보를 가져온 값, 데이터기반으로
            2에서 실행하고, 3에서 실행한다면
            1, 2, 3, 4이렇게 순서가 진행되어야함

            밑과 같이 만들어 줄 수 있음
            이렇게 하면 순차적으로 실행함

            callBack이 서로서로 붙어있음
            코드가 엄청나게 복잡해질 우려가 있음
            가독성이 떨어짐
            이러한 것을 해결하기 위해 코루틴이 등장함
         */
        api.getPost1().enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API1", response.body().toString())
                api.getPostNumber(2).enqueue(object : Callback<Post>{
                    override fun onResponse(call: Call<Post>, response: Response<Post>) {
                        Log.d("API2", response.body().toString())
                    }

                    override fun onFailure(call: Call<Post>, t: Throwable) {
                        Log.d("API2", "fail")
                    }

                })
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API1", "fail")
            }

        })



        api.getPostNumber(3).enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API3", response.body().toString())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API3", "fail")
            }

        })

        api.getPostNumber(4).enqueue(object : Callback<Post>{
            override fun onResponse(call: Call<Post>, response: Response<Post>) {
                Log.d("API4", response.body().toString())
            }

            override fun onFailure(call: Call<Post>, t: Throwable) {
                Log.d("API4", "fail")
            }

        })
    }
}