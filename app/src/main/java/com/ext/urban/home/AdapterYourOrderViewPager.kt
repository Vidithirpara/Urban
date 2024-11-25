package com.ext.urban.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.ext.urban.R

class AdapterYourOrderViewPager(val context: Context) : PagerAdapter() {
    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val itemView : View = layoutInflater.inflate(R.layout.homescreen_your_order_design, container, false)

        val txtServiceName: TextView = itemView.findViewById(R.id.txtServiceName)
        txtServiceName.isSelected = true

        container.addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // Remove the view from the container

    }
}