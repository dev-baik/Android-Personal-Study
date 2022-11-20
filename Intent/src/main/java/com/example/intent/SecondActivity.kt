package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.intent.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }

    companion object {
        const val EXTRA_REPLY = "extra_reply"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        binding.textMessage.text = message
    }

    fun returnReply(view: View) {
        val reply = binding.editTextSecond.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(RESULT_OK, replyIntent)
        finish()
    }

    fun gotoHomework(view: View) {
        val intent = Intent(applicationContext, HomeworkActivity::class.java)
        startActivity(intent)
    }
}