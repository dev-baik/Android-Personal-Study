package com.example.implicit_intents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.implicit_intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    fun openWebsite(view: View) {}
    fun openLocation(view: View) {}
    fun shareText(view: View) {}
}