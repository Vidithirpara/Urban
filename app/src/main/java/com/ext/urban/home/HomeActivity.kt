package com.ext.urban.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.urban.R
import com.ext.urban.databinding.ActivityHomeBinding
import com.ext.urban.databinding.ActivityRegistration1Binding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    lateinit var adapterTopViewPager: AdapterTopViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterTopViewPager = AdapterTopViewPager(this@HomeActivity)

        binding.viewPager.adapter = adapterTopViewPager

        binding.dotIndicator.attachTo(binding.viewPager)

    }
}