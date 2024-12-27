package com.ext.urban.navigationDrawer

import android.content.Intent
import android.os.Bundle
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.databinding.ActivityHelpCenterBinding
import com.ext.urban.registration.RegistrationActivity2

class HelpCenterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHelpCenterBinding
    private lateinit var adapterHelpCenter: AdapterHelpCenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHelpCenterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
        memoryAllocation()

    }

    private fun setOnClickListener(){
        binding.imgBack.setOnClickListener {
            onBackPressed()
        }

        binding.tvAddNewTicket.setOnClickListener {
            val intent = Intent(this, HelpCenterActivity2::class.java)
            startActivity(intent)
        }
    }

    private fun memoryAllocation(){
        adapterHelpCenter = AdapterHelpCenter()

        binding.rvHelpCenter.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.rvHelpCenter.adapter = adapterHelpCenter

    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}