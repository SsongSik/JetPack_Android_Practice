package com.example.a4_retrofitpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.a4_retrofitpractice.api.MyApi
import com.example.a4_retrofitpractice.api.RetrofitInstance
import com.example.a4_retrofitpractice.model.Post
import com.example.a4_retrofitpractice.viewModel.MainViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/*

 */
class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getPost1()
        viewModel.getPostNumber(3)

        val area1 = findViewById<TextView>(R.id.area1)
        val area2 = findViewById<TextView>(R.id.area2)

        viewModel.liveWord1.observe(this, Observer {
            area1.text = it.toString()
        })

        viewModel.liveWord2.observe(this, Observer {
            area2.text = it.toString()
        })

    }
}