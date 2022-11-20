package com.example.intent

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.intent.databinding.ActivityMainBinding

private val LOG_TAG = MainActivity::class.java.simpleName

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    companion object {
        const val EXTRA_MESSAGE = "extra_message"
        const val TEXT_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if(isVisible) {
                binding.textHeaderReply.visibility = View.VISIBLE
                binding.textMessageReply.text = savedInstanceState.getString("reply_text")
                binding.textMessageReply.visibility = View.VISIBLE
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if(binding.textHeaderReply.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", binding.textMessageReply.text.toString())
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == TEXT_REQUEST) {
            if(resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                binding.textHeaderReply.visibility = View.VISIBLE
                binding.textMessageReply.text = reply
                binding.textMessageReply.visibility = View.VISIBLE
            }
        }
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(applicationContext, SecondActivity::class.java)
        val message = binding.editTextMain.text.toString()
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }
}