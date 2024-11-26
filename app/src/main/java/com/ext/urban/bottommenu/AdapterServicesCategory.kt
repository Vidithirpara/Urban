package com.ext.urban.bottommenu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.databinding.RawServicesCategoryBinding

class AdapterServicesCategory(val requireContext: Context) : RecyclerView.Adapter<AdapterServicesCategory.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RawServicesCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val serviceAdapter = AdapterServices(requireContext)

        holder.binding.rvServices.layoutManager = LinearLayoutManager(requireContext)
        holder.binding.rvServices.adapter = serviceAdapter
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(val binding: RawServicesCategoryBinding) : RecyclerView.ViewHolder(binding.root)
}
