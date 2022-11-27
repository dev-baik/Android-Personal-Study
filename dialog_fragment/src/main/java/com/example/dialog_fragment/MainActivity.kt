package com.example.dialog_fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dialog_fragment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val dialog = CustomDialog()

            dialog.setButtonClickListener(object: CustomDialog.OnButtonClickListener {
                override fun onButton1Clicked() {
                    binding.text1.text = "감사합니다!"
                }

                override fun onButton2Clicked(content: String) {
                    binding.text1.text = "조금 더 노력하겠습니다."
                }
            })
            dialog.show(supportFragmentManager, "CustomDialog")
        }

        binding.button2.setOnClickListener {
            val dialog = CustomDialog2()

            dialog.setOnOkClickListener { content ->
                binding.text1.text = content
            }
            dialog.show(supportFragmentManager, null)
        }

        binding.button3.setOnClickListener {
            val dialog = CustomDialog3()

            dialog.setOnOKClickListener { content ->
                binding.text1.text = content
            }
            dialog.show(supportFragmentManager, dialog.tag)
        }
    }
}