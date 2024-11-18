package com.ext.urban.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewpager.Utils.validateAddress
import com.example.viewpager.Utils.validatePincode
import com.example.viewpager.Utils.validateStateAndCity
import com.ext.urban.R
import com.ext.urban.databinding.ActivityRegistration3Binding
import com.ext.urban.home.HomeActivity

class RegistrationActivity3 : AppCompatActivity() {

    private lateinit var binding : ActivityRegistration3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistration3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()

    }

    private fun setOnClickListener(){
        openStateSpinner()
        binding.llState.setOnClickListener {
            binding.spinnerState.performClick()
        }

        openCitySpinner()
        binding.llCity.setOnClickListener {
            binding.spinnerCity.performClick()
        }

        binding.llSaveDetails.setOnClickListener {
            if (validateAddress(this@RegistrationActivity3, binding.etAddress1) && validateStateAndCity(this@RegistrationActivity3, binding.tvState, binding.tvCity) && validatePincode(this@RegistrationActivity3, binding.etPinCode)){
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun openStateSpinner() {
        val category = resources.getStringArray(R.array.spinner_state)
        val adapter = ArrayAdapter(this, R.layout.spinner_background, R.id.text1, category)
        binding.spinnerState.adapter = adapter
        binding.spinnerState.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedCategory = parent.getItemAtPosition(position).toString()
                binding.tvState.text = selectedCategory

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun openCitySpinner() {
        val category = resources.getStringArray(R.array.spinner_city)
        val adapter = ArrayAdapter(this, R.layout.spinner_background, R.id.text1, category)
        binding.spinnerCity.adapter = adapter

        binding.spinnerCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                val selectedCategory = parent.getItemAtPosition(position).toString()
                binding.tvCity.text = selectedCategory

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}