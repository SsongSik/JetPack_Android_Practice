package com.example.a7_navigation

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.Navigation

// 첫번째로 5에서 backbutton 눌렀을 때 Fragment1로 이동
class BlankFragment5 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

//        val callback : OnBackPressedCallback = object : OnBackPressedCallback(true){
//            override fun handleOnBackPressed() {
//                view?.let{
//                    Navigation.findNavController(it).navigate(R.id.action_blankFragment5_to_blankFragment1)
//                }
//            }
//        }
//        requireActivity().onBackPressedDispatcher.addCallback(this, callback)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank5, container, false)
    }


}