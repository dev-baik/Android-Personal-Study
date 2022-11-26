package com.example.dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.dialog_fragment.databinding.DialogLayoutBinding

class CustomDialog : DialogFragment() {
    private lateinit var binding: DialogLayoutBinding

    // 클릭 이벤트 실행
    private lateinit var buttonClickListener: OnButtonClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = DialogLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 각 버튼 클릭 시 각각의 함수 호출
        binding.dialBtn1.setOnClickListener {
            buttonClickListener.onButton1Clicked()
            dismiss()
        }

        binding.dialBtn2.setOnClickListener {
            buttonClickListener.onButton2Clicked(binding.dialBtn2.text.toString())
            dismiss()
        }
    }

    // 이벤트 설정
    fun setButtonClickListener(buttonClickListener: OnButtonClickListener) {
        this.buttonClickListener = buttonClickListener
    }

    // 인터페이스
    interface OnButtonClickListener {
        fun onButton1Clicked()
        fun onButton2Clicked(content: String)
    }
}