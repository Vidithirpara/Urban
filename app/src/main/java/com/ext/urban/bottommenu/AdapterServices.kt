package com.ext.urban.bottommenu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.databinding.RawServiceBinding

class AdapterServices(requireContext: Context) : RecyclerView.Adapter<AdapterServices.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterServices.ViewHolder {
        val binding = RawServiceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterServices.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(val binding: RawServiceBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}