package com.ext.urban.navigationDrawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.R

class AdapterHelpCenter : RecyclerView.Adapter<AdapterHelpCenter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterHelpCenter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.raw_help_center, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterHelpCenter.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 25
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {

    }
}
