package com.ext.urban.home

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.ext.urban.R

class AdapterTopViewPager(val context: Context) : PagerAdapter() {
    override fun getCount(): Int {
        return 2
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    @SuppressLint("ResourceAsColor")
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val itemView : View = layoutInflater.inflate(R.layout.homescreen_top_viewpager_design, container, false)
        val latestNews : TextView = itemView.findViewById(R.id.tvLatestNews)

        val spannableString = SpannableString(latestNews.text)
        val orangeColor = Color.parseColor("#FF724C")
        spannableString.setSpan(
            ForegroundColorSpan(orangeColor),
            6, // start
            10, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )

        latestNews.text = spannableString
        container.addView(itemView)

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        // Remove the view from the container
        container.removeView(`object` as View)
    }
}