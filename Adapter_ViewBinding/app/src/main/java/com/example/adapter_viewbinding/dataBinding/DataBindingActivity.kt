package com.example.adapter_viewbinding.dataBinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.adapter_viewbinding.R
import com.example.adapter_viewbinding.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)

        val array = ArrayList<String>()
//
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")
        array.add("a")
        array.add("b")
        array.add("c")

        val CustomDataBinding = CustomDataBinding(array)

        val rv = binding.rv
        rv.adapter = CustomDataBinding
        rv.layoutManager = LinearLayoutManager(this)


    }
}