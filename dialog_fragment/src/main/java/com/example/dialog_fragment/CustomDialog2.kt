package com.example.dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.dialog_fragment.databinding.DialogLayout2Binding
import com.example.dialog_fragment.databinding.DialogLayoutBinding

class CustomDialog2 : DialogFragment() {
    private lateinit var binding: DialogLayout2Binding

    private lateinit var listener: OnOkClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = DialogLayout2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dialBtn1.setOnClickListener {
            listener.onClick(binding.dialBtn1.text.toString())
            dismiss()
        }

        binding.dialBtn2.setOnClickListener {
            listener.onClick(binding.dialBtn2.text.toString())
            dismiss()
        }
    }

    fun setOnOkClickListener(listener: (String) -> Unit) {
        this.listener = object : OnOkClickListener {
            override fun onClick(content: String) {
                listener(content)
            }
        }
    }

    interface OnOkClickListener {
        fun onClick(content: String)
    }
}