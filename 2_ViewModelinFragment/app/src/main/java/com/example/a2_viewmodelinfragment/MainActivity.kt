package com.example.a2_viewmodelinfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/*
Fragment에서의 ViewModel


 */
class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //초기화 하지 않고 예외처리를 해줌
        //라이프사이클을 초기화 하지 않음
        //하지만 구글에서는 권장하지 않음
        if(savedInstanceState == null){
            val transaction = manager.beginTransaction()
            val fragment = TestFragment()
            transaction.replace(R.id.frameArea, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


    }
}