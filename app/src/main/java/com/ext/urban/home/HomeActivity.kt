package com.ext.urban.home

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.R
import com.ext.urban.databinding.ActivityHomeBinding
import com.ext.urban.databinding.ActivityRegistration1Binding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    lateinit var adapterTopViewPager: AdapterTopViewPager
    lateinit var adapterYourOrderViewPager : AdapterYourOrderViewPager
    lateinit var adapterTopCategories : AdapterTopCategories
    lateinit var adapterTopServices : AdapterTopServices
    lateinit var adapterFAQ: AdapterFAQ

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        memoryAllocation()

    }

    private fun memoryAllocation(){
        adapterTopViewPager = AdapterTopViewPager(this@HomeActivity)
        adapterYourOrderViewPager = AdapterYourOrderViewPager(this@HomeActivity)
        adapterTopCategories = AdapterTopCategories()
        adapterTopServices = AdapterTopServices()
        adapterFAQ = AdapterFAQ()

        binding.viewPager.adapter = adapterTopViewPager
        binding.viewPagerYourOrder.adapter = adapterYourOrderViewPager

        binding.rvTopCategories.layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        binding.rvTopCategories.adapter = adapterTopCategories

        binding.rvTopServices.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvTopServices.adapter = adapterTopServices

        binding.rvFAQ.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvFAQ.adapter = adapterFAQ

        binding.viewPagerYourOrder.setPageMargin(-75)

        binding.dotIndicator.attachTo(binding.viewPager)
        binding.dotIndicatorYourOrder.attachTo(binding.viewPagerYourOrder)

    }
}