package com.example.bottom_sheet_dialog_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bottom_sheet_dialog_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val bottomSheet = CustomBottomSheet()

            bottomSheet.setOnOkClickListener { content ->
                binding.text1.text = content
            }

            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }
}