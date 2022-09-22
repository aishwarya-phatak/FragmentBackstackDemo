package com.example.fragmentbackstackdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentbackstackdemo.databinding.DataFragmentBinding

class DataFragment : Fragment() {
    private lateinit var binding : DataFragmentBinding
    private lateinit var data : Data

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataFragmentBinding.inflate(inflater)
        data = arguments?.getSerializable("data") as Data
        binding.data = data
        return binding.root
    }
}