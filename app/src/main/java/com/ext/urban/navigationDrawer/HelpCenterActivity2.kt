package com.ext.urban.navigationDrawer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.urban.R
import com.ext.urban.databinding.ActivityHelpCenter2Binding
import com.ext.urban.databinding.ActivityHelpCenterBinding

class HelpCenterActivity2 : AppCompatActivity() {

    private lateinit var binding : ActivityHelpCenter2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHelpCenter2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}