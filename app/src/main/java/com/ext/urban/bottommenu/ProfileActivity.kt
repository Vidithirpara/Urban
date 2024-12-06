package com.ext.urban.bottommenu

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewpager.Utils.validateAadharNumber
import com.example.viewpager.Utils.validateAddress
import com.example.viewpager.Utils.validateBirthDate
import com.example.viewpager.Utils.validateEmailAddress
import com.example.viewpager.Utils.validateFatherNameORMotherName
import com.example.viewpager.Utils.validateFirstNameORLastName
import com.example.viewpager.Utils.validateGenderAndCategory
import com.example.viewpager.Utils.validatePhoneNumber
import com.example.viewpager.Utils.validatePincode
import com.example.viewpager.Utils.validateStateAndCity
import com.ext.urban.R
import com.ext.urban.databinding.ActivityProfileBinding
import com.ext.urban.databinding.ActivityRegistration1Binding
import com.ext.urban.databinding.RawTopServicesBinding
import com.ext.urban.registration.RegistrationActivity2
import com.ext.urban.registration.RegistrationActivity3
import java.util.Calendar

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private var imageUri: Uri? = null
    private var filePath = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()
        memoryAllocation()

    }

    private fun setOnClickListener(){

        binding.tvEdit.setOnClickListener {
            binding.tvSaveDetails.visibility = View.VISIBLE
            binding.imgUser.setEnabled(true)
            binding.etFirstName.setEnabled(true)
            binding.etLastName.setEnabled(true)
            binding.etMobileNumber.setEnabled(true)
            binding.etEmail.setEnabled(true)
            binding.etAadharCardNumber.setEnabled(true)
            binding.llBirthdate.setEnabled(true)
            binding.llGender.setEnabled(true)
            binding.llCategory.setEnabled(true)
            binding.etFathersName.setEnabled(true)
            binding.etMothersName.setEnabled(true)
            binding.seekBar.setEnabled(true)
            binding.etAddress1.setEnabled(true)
            binding.etAddress2.setEnabled(true)
            binding.llState.setEnabled(true)
            binding.llCity.setEnabled(true)
            binding.etPinCode.setEnabled(true)

            binding.llBirthdate.setOnClickListener {
                openDatePicker()
            }

            openGenderSpinner(binding.spinnerGender, binding.tvGender)
            binding.llGender.setOnClickListener {
                binding.spinnerGender.performClick()
            }

            openCategorySpinner(binding.spinnerCategory, binding.tvCategory)
            binding.llCategory.setOnClickListener {
                binding.spinnerCategory.performClick()
            }

            openStateSpinner(binding.spinnerState, binding.tvState)
            binding.llState.setOnClickListener {
                binding.spinnerState.performClick()
            }

            openCitySpinner(binding.spinnerCity, binding.tvCity)
            binding.llCity.setOnClickListener {
                binding.spinnerCity.performClick()
            }

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

            binding.llUpdateProfile.setOnClickListener{
                if (validateFirstNameORLastName(this@ProfileActivity, binding.etFirstName, binding.etLastName) && validatePhoneNumber(this@ProfileActivity, binding.etMobileNumber) && validateEmailAddress(this@ProfileActivity, binding.etEmail) && validateAadharNumber(this@ProfileActivity, binding.etAadharCardNumber) && validateBirthDate(this@ProfileActivity, binding.tvBirthDate) && validateGenderAndCategory(this@ProfileActivity, binding.tvGender, binding.tvCategory) && validateFatherNameORMotherName(this@ProfileActivity, binding.etFathersName, binding.etMothersName) && validateAddress(this@ProfileActivity, binding.etAddress1) && validateStateAndCity(this@ProfileActivity, binding.tvState, binding.tvCity) && validatePincode(this@ProfileActivity, binding.etPinCode)){
                    val intent = Intent(this, BottomViewNavigationActivity::class.java)
                    startActivity(intent)
                }
            }

        }

        binding.imgUser.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                openGallery()
            } else {
                takeStoragePermission.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }

        binding.imgBack.setOnClickListener{
            onBackPressed()
        }
    }

    private fun memoryAllocation(){
        binding.imgUser.setEnabled(false)
        binding.etFirstName.setEnabled(false)
        binding.etLastName.setEnabled(false)
        binding.etMobileNumber.setEnabled(false)
        binding.etEmail.setEnabled(false)
        binding.etAadharCardNumber.setEnabled(false)
        binding.llBirthdate.setEnabled(false)
        binding.llGender.setEnabled(false)
        binding.llCategory.setEnabled(false)
        binding.etFathersName.setEnabled(false)
        binding.etMothersName.setEnabled(false)
        binding.seekBar.setEnabled(false)
        binding.etAddress1.setEnabled(false)
        binding.etAddress2.setEnabled(false)
        binding.llState.setEnabled(false)
        binding.llCity.setEnabled(false)
        binding.etPinCode.setEnabled(false)

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

    private val takeStoragePermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted: Boolean ->
        if (isGranted) {
            openGallery()
        } else {
            Toast.makeText(this, "Storage permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    private val imagePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
            imageUri = result.data?.data
            binding.imgUser.setImageURI(imageUri)

            imageUri?.let { uri ->
                filePath = getRealPath(uri).toString()
            }

        }
    }

    private fun getRealPath(uri: Uri): String? {
        var cursor: Cursor? = null
        return try {
            val projection = arrayOf(MediaStore.Images.Media.DATA)
            cursor = contentResolver.query(uri, projection, null, null, null)
            val columnIndex = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
            cursor?.moveToFirst()
            columnIndex?.let { cursor?.getString(it) }
        } finally {
            cursor?.close()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        imagePickerLauncher.launch(intent)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}