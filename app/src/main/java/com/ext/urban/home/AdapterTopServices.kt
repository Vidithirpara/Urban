package com.ext.urban.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.R

class AdapterTopServices() : RecyclerView.Adapter<AdapterTopServices.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTopServices.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.homescreen_top_services_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterTopServices.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    }
}