package com.example.fragmentbackstackdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fragmentbackstackdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var dataFragments = ArrayList<DataFragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnAddFragment.setOnClickListener {
            addDataFragment()
        }

        binding.btnRemoveFragment.setOnClickListener {
            removeDataFragment()
        }
    }

    private fun addDataFragment(){
        var dataFragment = DataFragment()
        dataFragments.add(dataFragment)

        var data = Data(
                "Bitcode Technologies",
                11
        )

        var input = Bundle()
        input.putSerializable("data", data)
        dataFragment.arguments = input

        supportFragmentManager.beginTransaction()
            .add(R.id.mainContainer,dataFragment, null)
            .addToBackStack(null)
            .commit()
    }

    private fun removeDataFragment(){
            supportFragmentManager.beginTransaction()
                .remove(dataFragments[dataFragments.size - 1])
                .addToBackStack(null)
                .commit()

        dataFragments.removeAt(dataFragments.size - 1)
    }
}