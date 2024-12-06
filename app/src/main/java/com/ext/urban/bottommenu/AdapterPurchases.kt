package com.ext.urban.bottommenu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.databinding.RawPurchasesBinding

class AdapterPurchases(requireContext: Context) : RecyclerView.Adapter<AdapterPurchases.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPurchases.ViewHolder {
        val binding = RawPurchasesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AdapterPurchases.ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }

    class ViewHolder(val binding: RawPurchasesBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}