package com.ext.urban.bottommenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.ext.urban.R
import com.ext.urban.home.AdapterFAQ
import com.ext.urban.home.AdapterTopCategories
import com.ext.urban.home.AdapterTopServices
import com.ext.urban.home.AdapterTopViewPager
import com.ext.urban.home.AdapterYourOrderViewPager
import com.google.android.material.navigation.NavigationView
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment(val drawerLayout: DrawerLayout) : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var adapterTopViewPager: AdapterTopViewPager
    lateinit var adapterYourOrderViewPager: AdapterYourOrderViewPager
    lateinit var adapterTopCategories: AdapterTopCategories
    lateinit var adapterTopServices: AdapterTopServices
    lateinit var adapterFAQ: AdapterFAQ


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager>(R.id.viewPager)
        val viewPagerYourOrder = view.findViewById<ViewPager>(R.id.viewPagerYourOrder)
        val rvTopCategories = view.findViewById<RecyclerView>(R.id.rvTopCategories)
        val rvTopServices = view.findViewById<RecyclerView>(R.id.rvTopServices)
        val rvFAQ = view.findViewById<RecyclerView>(R.id.rvFAQ)
        val dotIndicator = view.findViewById<DotsIndicator>(R.id.dotIndicator)
        val dotIndicatorYourOrder = view.findViewById<DotsIndicator>(R.id.dotIndicatorYourOrder)
        val imgNavigationDrawer = view.findViewById<ImageView>(R.id.img_navigationDrawer)

        adapterTopViewPager = AdapterTopViewPager(requireContext())
        adapterYourOrderViewPager = AdapterYourOrderViewPager(requireContext())
        adapterTopCategories = AdapterTopCategories()
        adapterTopServices = AdapterTopServices()
        adapterFAQ = AdapterFAQ()

        viewPager.adapter = adapterTopViewPager
        viewPagerYourOrder.adapter = adapterYourOrderViewPager

        rvTopCategories.layoutManager =
            GridLayoutManager(requireContext(), 3, GridLayoutManager.VERTICAL, false)
        rvTopCategories.adapter = adapterTopCategories

        rvTopServices.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        rvTopServices.adapter = adapterTopServices

        rvFAQ.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        rvFAQ.adapter = adapterFAQ

        viewPagerYourOrder.setPageMargin(-75)

        dotIndicator.attachTo(viewPager)
        dotIndicatorYourOrder.attachTo(viewPagerYourOrder)

        imgNavigationDrawer.setOnClickListener {
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                drawerLayout.openDrawer(GravityCompat.START)
            }

        }

    }


}