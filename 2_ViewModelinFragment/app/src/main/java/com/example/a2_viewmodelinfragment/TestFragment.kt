package com.example.a2_viewmodelinfragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.a2_viewmodelinfragment.databinding.FragmentTestBinding


class TestFragment : Fragment() {

    private lateinit var binding : FragmentTestBinding

//    var countValue = 0

    private lateinit var viewmodel : TestFragmentViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TestFramgnet", "onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TestFramgnet", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("TestFramgnet", "onCreateView")

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container, false)

        viewmodel= ViewModelProvider(this).get(TestFragmentViewModel::class.java)

        binding.resultArea.text = viewmodel.countValue.toString()

        binding.plus.setOnClickListener {
            viewmodel.plus()
            binding.resultArea.text = viewmodel.countValue.toString()
//            countValue++
//            binding.resultArea.text = countValue.toString()
        }

        binding.minus.setOnClickListener {
            viewmodel.minus()
            binding.resultArea.text = viewmodel.countValue.toString()
//            countValue--
//            binding.resultArea.text = countValue.toString()
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        Log.d("TestFramgnet", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TestFramgnet", "onStop")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("TestFramgnet", "onDestroyView")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TestFramgnet", "onDestroy")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TestFramgnet", "onDetach")
    }

}