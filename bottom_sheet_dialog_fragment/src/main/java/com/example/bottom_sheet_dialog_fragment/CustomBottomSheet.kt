package com.example.bottom_sheet_dialog_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bottom_sheet_dialog_fragment.databinding.BottomSheetLayoutBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CustomBottomSheet : BottomSheetDialogFragment() {
    private lateinit var binding: BottomSheetLayoutBinding

    private lateinit var listener: OnOkClickListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = BottomSheetLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bottomSheet = dialog?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
        val behavior = BottomSheetBehavior.from<View>(bottomSheet!!)
        behavior.state = BottomSheetBehavior.STATE_EXPANDED

        binding.dialBtn1.setOnClickListener {
            listener.onClick("최고")
            dismiss()
        }

        binding.dialBtn2.setOnClickListener {
            listener.onClick("별로")
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