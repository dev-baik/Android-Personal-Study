package com.example.dialog_fragment

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class CustomDialog3 : DialogFragment() {
    private lateinit var listener: OnOKClickListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
        AlertDialog.Builder(requireContext())
            .setTitle("제목")
            .setMessage("전달할 메시지")
            .setPositiveButton("예?") { _, _ ->
                listener.onClick("예")
            }
            .setNegativeButton("아니오?") { _, _ ->
                listener.onClick("아니오")
            }
            .create()

    fun setOnOKClickListener(listener: (String) -> Unit) {
        this.listener = object : OnOKClickListener {
            override fun onClick(content: String) {
                listener(content)
            }
        }
    }

    interface OnOKClickListener {
        fun onClick(content: String)
    }
}