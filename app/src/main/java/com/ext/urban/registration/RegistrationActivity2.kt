package com.ext.urban.registration

import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewpager.Utils.validateFatherNameORMotherName
import com.ext.urban.R
import com.ext.urban.databinding.ActivityRegistration2Binding

class RegistrationActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityRegistration2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistration2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()

    }

    private fun setOnClickListener(){
        binding.seekBar.max = (2000000 - 100) / 100

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val income = 100 + (progress * 100)
                val formattedIncome = when {
                    income < 100000 -> "${income / 1000}K"
                    else -> "${income / 100000}L"
                }
                binding.txtIncome.text = "$formattedIncome"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        binding.llContinue.setOnClickListener {
            if (validateFatherNameORMotherName(this@RegistrationActivity2, binding.etFatherName, binding.etMotherName)){
                val intent = Intent(this, RegistrationActivity3::class.java)
                startActivity(intent)
            }
        }
    }
}