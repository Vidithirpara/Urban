package com.ext.urban.navigationDrawer

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
import com.example.viewpager.Utils.validateAadharNumber
import com.example.viewpager.Utils.validateAddress
import com.example.viewpager.Utils.validateBirthDate
import com.example.viewpager.Utils.validateEmailAddress
import com.example.viewpager.Utils.validateFatherNameORMotherName
import com.example.viewpager.Utils.validateFirstNameORLastName
import com.example.viewpager.Utils.validateGenderAndCategory
import com.example.viewpager.Utils.validateGstNumber
import com.example.viewpager.Utils.validateName
import com.example.viewpager.Utils.validatePhoneNumber
import com.example.viewpager.Utils.validatePincode
import com.example.viewpager.Utils.validateStateAndCity
import com.ext.urban.R
import com.ext.urban.bottommenu.BottomViewNavigationActivity
import com.ext.urban.databinding.ActivityBillingSettingsBinding

class BillingSettingsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBillingSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBillingSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        memoryAllocation()
        setOnClickListener()

    }

    private fun setOnClickListener(){
        binding.tvEdit.setOnClickListener{
            binding.etName.isEnabled = true
            binding.etAddress1.isEnabled = true
            binding.etAddress2.isEnabled = true
            binding.tvState.isEnabled = true
            binding.tvCity.isEnabled = true
            binding.etPinCode.isEnabled = true
            binding.etPinCode.isEnabled = true
            binding.tvUpdateProfile.visibility = View.VISIBLE
        }

        openStateSpinner(binding.spinnerState, binding.tvState)
        binding.llState.setOnClickListener {
            binding.spinnerState.performClick()
        }

        openCitySpinner(binding.spinnerCity, binding.tvCity)
        binding.llCity.setOnClickListener {
            binding.spinnerCity.performClick()
        }

        binding.tvUpdateProfile.setOnClickListener{
            if (validateName(this@BillingSettingsActivity, binding.etName) && validateAddress(this@BillingSettingsActivity, binding.etAddress1) && validateAddress(this@BillingSettingsActivity, binding.etAddress2) && validateStateAndCity(this@BillingSettingsActivity, binding.tvState, binding.tvCity) && validatePincode(this@BillingSettingsActivity, binding.etPinCode) && validateGstNumber(this@BillingSettingsActivity, binding.etGstNumber)){
                val intent = Intent(this, NavigationDrawerActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun memoryAllocation(){
        binding.etName.isEnabled = false
        binding.etAddress1.isEnabled = false
        binding.etAddress2.isEnabled = false
        binding.tvState.isEnabled = false
        binding.tvCity.isEnabled = false
        binding.etPinCode.isEnabled = false
        binding.etGstNumber.isEnabled = false
    }

    private fun openStateSpinner(spinnerState: Spinner, tvState: TextView) {
        val category = resources.getStringArray(R.array.spinner_state)
        val adapter = ArrayAdapter(this, R.layout.spinner_background, R.id.text1, category)
        spinnerState.adapter = adapter
        spinnerState.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedCategory = parent.getItemAtPosition(position).toString()
                tvState.text = selectedCategory

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun openCitySpinner(spinnerCity: Spinner, tvCity: TextView) {
        val category = resources.getStringArray(R.array.spinner_city)
        val adapter = ArrayAdapter(this, R.layout.spinner_background, R.id.text1, category)
        spinnerCity.adapter = adapter
        spinnerCity.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedCategory = parent.getItemAtPosition(position).toString()
                tvCity.text = selectedCategory

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}