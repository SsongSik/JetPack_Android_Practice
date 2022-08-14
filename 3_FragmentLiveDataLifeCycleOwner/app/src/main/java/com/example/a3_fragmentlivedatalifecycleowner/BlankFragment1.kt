package com.example.a3_fragmentlivedatalifecycleowner

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.a3_fragmentlivedatalifecycleowner.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {

    private val TAG = "BlankFragment1"

    private var _binding : FragmentBlank1Binding? = null
    private val binding get() = _binding!!

    private val viewModel : BlankViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentBlank1Binding.inflate(inflater, container, false)
        val view = binding.root

//        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            viewModel.plusCountValue()
        }
        //this를 사용하는 것이 아닌 viewLifeCycleOwner를 사용해야함
        /*
        미묘한 버그를 방지하기 위해
        프래그먼트랑 뷰랑 라이프사이클이 다르기 때문에 관찰할 때 중복해서 데이터를 관찰할 수 있는 문제가 발생할 수 있음
         */
        viewModel.liveCount.observe(viewLifecycleOwner, Observer {
            binding.text1.text = it.toString()
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d(TAG, "onDestoryView")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }



}