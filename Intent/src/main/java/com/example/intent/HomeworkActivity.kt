package com.example.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.intent.databinding.ActivityHomeworkBinding

class HomeworkActivity : AppCompatActivity() {
    private val binding by lazy { ActivityHomeworkBinding.inflate(layoutInflater) }
    private var cnt = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if(savedInstanceState != null) {
            val num = savedInstanceState.getString("count_text")
            binding.countText.text = num
            cnt = num!!.toInt()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("count_text", binding.countText.text.toString())
    }

    fun cntClick(view: View) {
        cnt++
        binding.countText.text = cnt.toString()
    }
}