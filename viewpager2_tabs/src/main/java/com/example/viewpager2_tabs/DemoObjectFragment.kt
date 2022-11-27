package com.example.viewpager2_tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager2_tabs.databinding.FragmentCollectionObjectBinding

class DemoObjectFragment : Fragment() {
    private lateinit var binding : FragmentCollectionObjectBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = FragmentCollectionObjectBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey("testKey") }?.apply {
            binding.fragmentTextView.text = getInt("testKey").toString()
        }
    }
}