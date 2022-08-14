package com.example.a3_fragmentlivedatalifecycleowner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.a3_fragmentlivedatalifecycleowner.databinding.ActivityMainBinding

//Fragment LiveData / LifeCycleOwner

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.btn1.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = BlankFragment1()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.btn2.setOnClickListener {
            val transaction = manager.beginTransaction()
            val fragment = BlankFragment2()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}