package com.ext.urban.bottommenu

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.ext.urban.R
import com.ext.urban.navigationDrawer.NavigationDrawerActivity

class BottomViewNavigationActivity : NavigationDrawerActivity() {

    lateinit var txtService : TextView
    lateinit var txtHome : TextView
    lateinit var txtOrder : TextView
    lateinit var llHome : LinearLayout
    lateinit var llProfile : LinearLayout
    lateinit var llService : LinearLayout
    lateinit var llOrder : LinearLayout
    lateinit var imgService : ImageView
    lateinit var imgHome : ImageView
    lateinit var imgOrder : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layoutInflater.inflate(R.layout.activity_bottom_view_navigation, container2)

        txtService =findViewById(R.id.txtService)
        txtHome =findViewById(R.id.txtHome)
        txtOrder =findViewById(R.id.txtOrder)
        llHome =findViewById(R.id.llHome)
        llProfile =findViewById(R.id.llProfile)
        llService =findViewById(R.id.llService)
        llOrder =findViewById(R.id.llOrder)
        imgService =findViewById(R.id.imgService)
        imgHome =findViewById(R.id.imgHome)
        imgOrder =findViewById(R.id.imgOrder)

        loadFragment(HomeFragment(drawerLayout))
        setOnCLickListener()

    }

    private fun setOnCLickListener(){
        llHome.setOnClickListener {
            loadFragment(HomeFragment(drawerLayout))

            txtService.setTextColor(ContextCompat.getColor(this, R.color.white))
            txtHome.setTextColor(ContextCompat.getColor(this, R.color.orange))
            txtOrder.setTextColor(ContextCompat.getColor(this, R.color.white))

            txtService.setTextAppearance(R.style.poppinsRegularText)
            txtHome.setTextAppearance(R.style.poppinsSemiBoldText)
            txtOrder.setTextAppearance(R.style.poppinsRegularText)

            imgService.setImageResource(R.drawable.service_white)
            imgHome.setImageResource(R.drawable.home_orange)
            imgOrder.setImageResource(R.drawable.order_white)
        }

        llProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        llService.setOnClickListener {
            loadFragment(ServiceFragment())
            txtService.setTextColor(ContextCompat.getColor(this, R.color.orange))
            txtHome.setTextColor(ContextCompat.getColor(this, R.color.white))
            txtOrder.setTextColor(ContextCompat.getColor(this, R.color.white))

            txtService.setTextAppearance(R.style.poppinsSemiBoldText)
            txtHome.setTextAppearance(R.style.poppinsRegularText)
            txtOrder.setTextAppearance(R.style.poppinsRegularText)

            imgService.setImageResource(R.drawable.service_orange)
            imgHome.setImageResource(R.drawable.home_white)
            imgOrder.setImageResource(R.drawable.order_white)
        }

        llOrder.setOnClickListener {
            loadFragment(OrderFragment())

            txtService.setTextColor(ContextCompat.getColor(this, R.color.white))
            txtHome.setTextColor(ContextCompat.getColor(this, R.color.white))
            txtOrder.setTextColor(ContextCompat.getColor(this, R.color.orange))

            txtService.setTextAppearance(R.style.poppinsRegularText)
            txtHome.setTextAppearance(R.style.poppinsRegularText)
            txtOrder.setTextAppearance(R.style.poppinsSemiBoldText)

            imgService.setImageResource(R.drawable.service_white)
            imgHome.setImageResource(R.drawable.home_white)
            imgOrder.setImageResource(R.drawable.order_orange)
        }
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }


}