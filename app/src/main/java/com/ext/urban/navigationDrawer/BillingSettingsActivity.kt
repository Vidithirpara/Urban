package com.ext.urban.navigationDrawer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.urban.R
import com.ext.urban.databinding.ActivityBillingSettingsBinding

class BillingSettingsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBillingSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBillingSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}