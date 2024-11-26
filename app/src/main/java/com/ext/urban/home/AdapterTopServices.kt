package com.ext.urban.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.databinding.HomescreenTopServicesDesignBinding

class AdapterTopServices : RecyclerView.Adapter<AdapterTopServices.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomescreenTopServicesDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(val binding: HomescreenTopServicesDesignBinding) : RecyclerView.ViewHolder(binding.root)
}