package com.ext.urban.navigationDrawer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ext.urban.R
import com.ext.urban.databinding.ActivityNotificationPreferencesBinding

class NotificationPreferencesActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNotificationPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotificationPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickListener()

    }

    private fun setOnClickListener(){
        binding.llEmail.setOnClickListener {
            val currentDrawable = binding.imgMail.drawable
            val uncheckedDrawable = ContextCompat.getDrawable(this, R.drawable.checkbox_unchecked)

            if (currentDrawable?.constantState == uncheckedDrawable?.constantState) {
                binding.imgMail.setImageResource(R.drawable.checkbox_checked)
            } else {
                binding.imgMail.setImageResource(R.drawable.checkbox_unchecked)
            }
        }

        binding.llCall.setOnClickListener {
            val currentDrawable = binding.imgCall.drawable
            val uncheckedDrawable = ContextCompat.getDrawable(this, R.drawable.checkbox_unchecked)

            if (currentDrawable?.constantState == uncheckedDrawable?.constantState) {
                binding.imgCall.setImageResource(R.drawable.checkbox_checked)
            } else {
                binding.imgCall.setImageResource(R.drawable.checkbox_unchecked)
            }
        }

        binding.llPushNotification.setOnClickListener {
            val currentDrawable = binding.imgPushNotification.drawable
            val uncheckedDrawable = ContextCompat.getDrawable(this, R.drawable.checkbox_unchecked)

            if (currentDrawable?.constantState == uncheckedDrawable?.constantState) {
                binding.imgPushNotification.setImageResource(R.drawable.checkbox_checked)
            } else {
                binding.imgPushNotification.setImageResource(R.drawable.checkbox_unchecked)
            }
        }
    }
}