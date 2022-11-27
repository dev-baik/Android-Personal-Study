package com.example.viewpager2_tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.viewpager2_tabs.databinding.LayoutCollectionDemoBinding
import com.google.android.material.tabs.TabLayoutMediator

class CollectionDemoFragment : Fragment() {
    private lateinit var binding: LayoutCollectionDemoBinding
    private lateinit var viewPager2Adapter: ViewPager2Adapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        binding = LayoutCollectionDemoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewPager2Adapter = ViewPager2Adapter(this)
        binding.pager.adapter = viewPager2Adapter

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
    }
}