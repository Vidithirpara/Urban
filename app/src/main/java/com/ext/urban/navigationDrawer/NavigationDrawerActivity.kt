package com.ext.urban.navigationDrawer

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.ext.urban.R
import com.ext.urban.bottommenu.ProfileActivity
import com.ext.urban.databinding.ActivityNavigationDrawerBinding
import com.google.android.material.navigation.NavigationView

open class NavigationDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityNavigationDrawerBinding
    private lateinit var toggle: ActionBarDrawerToggle
    lateinit var navigationView: NavigationView
    lateinit var drawerLayout: DrawerLayout
    lateinit var container2: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigationView = findViewById(R.id.nav_view)
        drawerLayout = findViewById(R.id.drawer_layout)
        container2 = findViewById(R.id.container2)

        toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        setOnClickListener()

    }

    private fun setOnClickListener(){
        binding.txtViewProflile.setOnClickListener{
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.llProfileManagement.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        binding.llBillingSetting.setOnClickListener {
            val intent = Intent(this, BillingSettingsActivity::class.java)
            startActivity(intent)
        }

        binding.llNotificationPreferences.setOnClickListener {
            val intent = Intent(this, NotificationPreferencesActivity::class.java)
            startActivity(intent)
        }

        binding.llWishlist.setOnClickListener {
            val intent = Intent(this, WishListActivity::class.java)
            startActivity(intent)
        }

        binding.llHelpCenter.setOnClickListener {
            val intent = Intent(this, HelpCenterActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return true
    }
}