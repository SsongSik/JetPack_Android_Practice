package com.example.a7_navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation


class BlankFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bundle = Bundle()
        bundle.putString("key", "value") //null값이 전달될 수 있음

        val view = inflater.inflate(R.layout.fragment_blank1, container, false)

        val action = BlankFragment1Directions.actionBlankFragment1ToBlankFragment2("abcde")
        //데이터를 안넘기고 화면전환이 이루어지면 디폴트값이 들어감, null을 방지할 수 있음

        view.findViewById<Button>(R.id.btn1).setOnClickListener {
//            Navigation.findNavController(view).navigate(R.id.action_blankFragment1_to_blankFragment2, bundle)
            Navigation.findNavController(view).navigate(action)
        }

        return view
    }


}