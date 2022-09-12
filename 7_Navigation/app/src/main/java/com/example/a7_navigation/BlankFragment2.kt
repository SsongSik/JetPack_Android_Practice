package com.example.a7_navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs


class BlankFragment2 : Fragment() {

    val args : BlankFragment2Args by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank2, container, false)

        val getString = arguments?.getString("key")
        Log.d("BlankFragment2", getString.toString())

        view.findViewById<Button>(R.id.btn2).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_blankFragment2_to_blankFragment3)
        }

        Log.d("BlackFragment2", args.key)

        return view
    }

}