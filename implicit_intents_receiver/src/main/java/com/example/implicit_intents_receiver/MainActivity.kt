package com.example.implicit_intents_receiver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.implicit_intents_receiver.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val uri = intent.data

        if (uri != null) {
            val uri_string = "URI: $uri"
            binding.textUriMessage.text = uri_string
        }
    }
}