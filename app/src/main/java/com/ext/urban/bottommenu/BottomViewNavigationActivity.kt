package com.ext.urban.bottommenu

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.ext.urban.R
import com.ext.urban.databinding.ActivityBottomViewNavigationBinding
import com.ext.urban.registration.RegistrationActivity2

class BottomViewNavigationActivity : AppCompatActivity() {

    private lateinit var binding : ActivityBottomViewNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomViewNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadFragment(HomeFragment())
        setOnCLickListener()

    }

    private fun setOnCLickListener(){
        binding.llHome.setOnClickListener {
            loadFragment(HomeFragment())

            binding.txtService.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.txtHome.setTextColor(ContextCompat.getColor(this, R.color.orange))
            binding.txtOrder.setTextColor(ContextCompat.getColor(this, R.color.white))

            binding.txtService.setTextAppearance(R.style.poppinsRegularText)
            binding.txtHome.setTextAppearance(R.style.poppinsSemiBoldText)
            binding.txtOrder.setTextAppearance(R.style.poppinsRegularText)

            binding.imgService.setImageResource(R.drawable.service_white)
            binding.imgHome.setImageResource(R.drawable.home_orange)
            binding.imgOrder.setImageResource(R.drawable.order_white)
        }

        binding.llProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.llService.setOnClickListener {
            loadFragment(ServiceFragment())
            binding.txtService.setTextColor(ContextCompat.getColor(this, R.color.orange))
            binding.txtHome.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.txtOrder.setTextColor(ContextCompat.getColor(this, R.color.white))

            binding.txtService.setTextAppearance(R.style.poppinsSemiBoldText)
            binding.txtHome.setTextAppearance(R.style.poppinsRegularText)
            binding.txtOrder.setTextAppearance(R.style.poppinsRegularText)

            binding.imgService.setImageResource(R.drawable.service_orange)
            binding.imgHome.setImageResource(R.drawable.home_white)
            binding.imgOrder.setImageResource(R.drawable.order_white)
        }

        binding.llOrder.setOnClickListener {
            loadFragment(OrderFragment())

            binding.txtService.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.txtHome.setTextColor(ContextCompat.getColor(this, R.color.white))
            binding.txtOrder.setTextColor(ContextCompat.getColor(this, R.color.orange))

            binding.txtService.setTextAppearance(R.style.poppinsRegularText)
            binding.txtHome.setTextAppearance(R.style.poppinsRegularText)
            binding.txtOrder.setTextAppearance(R.style.poppinsSemiBoldText)

            binding.imgService.setImageResource(R.drawable.service_white)
            binding.imgHome.setImageResource(R.drawable.home_white)
            binding.imgOrder.setImageResource(R.drawable.order_orange)
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}