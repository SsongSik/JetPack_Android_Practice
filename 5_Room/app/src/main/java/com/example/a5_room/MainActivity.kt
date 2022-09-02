package com.example.a5_room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a5_room.adapter.CustomAdapter
import com.example.a5_room.db.TextDatabase
import com.example.a5_room.entity.TextEntity
import com.example.a5_room.entity.WordEntity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*
ROOM
 */
class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData()

        val db = TextDatabase.getDatabase(this)

        val inputArea = findViewById<EditText>(R.id.textInputArea)
        val insertBtn = findViewById<Button>(R.id.insert)
        val getAllBtn = findViewById<Button>(R.id.getData)
        val deleteBtn = findViewById<Button>(R.id.delete)

        insertBtn.setOnClickListener {
            /*
            Dispatchers.IO
            외부에서 디스크 또는 네트워크 I/O를 실행하도록 최적화되어 있다.
            Room지속성 라이브러리.
             */
            viewModel.insertData(inputArea.text.toString())
            inputArea.setText("")

        }

        val rv = findViewById<RecyclerView>(R.id.rv)

        viewModel.textList.observe(this, Observer {
            val customAdapter = CustomAdapter(it)
            rv.adapter = customAdapter
            rv.layoutManager = LinearLayoutManager(this)
        })

        getAllBtn.setOnClickListener {
            viewModel.getData()

        }

        deleteBtn.setOnClickListener {
//            CoroutineScope(Dispatchers.IO).launch {
//                db.textDao().deleteAllData()
//                db.wordDao().deleteAllData()
//            }
            viewModel.removeData()
        }






    }
}