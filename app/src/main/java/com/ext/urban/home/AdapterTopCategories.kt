package com.ext.urban.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.databinding.HomescreenTopCategoriesDesignBinding

class AdapterTopCategories : RecyclerView.Adapter<AdapterTopCategories.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = HomescreenTopCategoriesDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 6
    }

    class ViewHolder(val binding: HomescreenTopCategoriesDesignBinding) : RecyclerView.ViewHolder(binding.root)
}