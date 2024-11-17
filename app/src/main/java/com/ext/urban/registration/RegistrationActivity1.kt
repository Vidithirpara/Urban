package com.ext.urban.registration

import android.app.DatePickerDialog
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
import com.example.viewpager.Utils.validateBirthDate
import com.example.viewpager.Utils.validateEmailAddress
import com.example.viewpager.Utils.validateFirstNameORLastName
import com.example.viewpager.Utils.validateGenderAndCategory
import com.example.viewpager.Utils.validatePhoneNumber
import com.ext.urban.R
import com.ext.urban.databinding.ActivityRegistration1Binding
import java.util.Calendar

class RegistrationActivity1 : AppCompatActivity() {

    private lateinit var binding : ActivityRegistration1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegistration1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
    }

    private fun setOnClickListener(){
        openGenderSpinner(binding.spinnerGender, binding.tvGender)
        binding.llGender.setOnClickListener {
            binding.spinnerGender.performClick()
        }

        openCategorySpinner(binding.spinnerCategory, binding.tvCategory)
        binding.llCategory.setOnClickListener {
            binding.spinnerCategory.performClick()
        }

        binding.llContinue.setOnClickListener{
            if (validateFirstNameORLastName(this@RegistrationActivity1, binding.etFirstName, binding.etLastName) && validatePhoneNumber(this@RegistrationActivity1, binding.etPhoneNumber) && validateEmailAddress(this@RegistrationActivity1, binding.etEmail) && validateAadharNumber(this@RegistrationActivity1, binding.etAadharCardNumber) && validateBirthDate(this@RegistrationActivity1, binding.tvBirthDate) && validateGenderAndCategory(this@RegistrationActivity1, binding.tvGender, binding.tvCategory)){
                val intent = Intent(this, RegistrationActivity2::class.java)
                startActivity(intent)
            }
        }

        binding.tvBirthDate.setOnClickListener{
            openDatePicker()
        }
    }
    private fun memoryAllocation(){

    }

    private fun openGenderSpinner(spinnerCategory: Spinner, tvGender: TextView) {
        val category = resources.getStringArray(R.array.spinner_gender)
        val adapter = ArrayAdapter(this, R.layout.spinner_background, R.id.text1, category)
        spinnerCategory.adapter = adapter
        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
                val selectedCategory = parent.getItemAtPosition(position).toString()
                tvGender.text = selectedCategory

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun openCategorySpinner(spinnerCategory: Spinner, tvCategory: TextView) {
        val category = resources.getStringArray(R.array.spinner_category2)
        val adapter = ArrayAdapter(this, R.layout.spinner_background, R.id.text1, category)
        spinnerCategory.adapter = adapter

        spinnerCategory.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {

                val selectedCategory = parent.getItemAtPosition(position).toString()
                tvCategory.text = selectedCategory

            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }

    private fun openDatePicker() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { view, year, monthOfYear, dayOfMonth ->
                val dat = (dayOfMonth.toString() + "-" + (monthOfYear + 1) + "-" + year)
                binding.tvBirthDate.setText(dat)
            }, year, month, day
        )
        datePickerDialog.show()
    }
}