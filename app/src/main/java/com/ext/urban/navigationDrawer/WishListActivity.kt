package com.ext.urban.navigationDrawer

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.R
import com.ext.urban.databinding.ActivityBillingSettingsBinding
import com.ext.urban.databinding.ActivityWishListBinding

class WishListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWishListBinding
    lateinit var adapterWishList: AdapterWishList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWishListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
        memoryAllocation()

    }

    private fun setOnClickListener() {
        binding.tvServices.setOnClickListener {
            binding.tvServices.setBackgroundResource(R.drawable.rounded_corner_white)
            binding.tvServiceProvider.setBackgroundResource(0)
        }

        binding.tvServiceProvider.setOnClickListener {
            binding.tvServiceProvider.setBackgroundResource(R.drawable.rounded_corner_white)
            binding.tvServices.setBackgroundResource(0)
        }

        binding.tvEditList.setOnClickListener{
            binding.llSaveWishList.visibility = View.VISIBLE
            adapterWishList.updateVisibility(true)
        }

        binding.llSaveWishList.setOnClickListener {

        }
    }

    private fun memoryAllocation() {

        adapterWishList = AdapterWishList()

        binding.rvServices.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvServices.adapter = adapterWishList
    }
}