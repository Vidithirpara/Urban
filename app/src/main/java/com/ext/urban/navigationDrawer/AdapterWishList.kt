package com.ext.urban.navigationDrawer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.databinding.RawServicesBinding

class AdapterWishList : RecyclerView.Adapter<AdapterWishList.ViewHolder>() {

    private var showImgMinus = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RawServicesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(showImgMinus)

        holder.binding.imgMinus.setOnClickListener{

        }
    }

    override fun getItemCount(): Int {
        return 20
    }

    fun updateVisibility(show: Boolean) {
        showImgMinus = show
        notifyDataSetChanged()
    }


    class ViewHolder(val binding: RawServicesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(show: Boolean) {
            binding.imgMinus.visibility = if (show) View.VISIBLE else View.GONE
        }
    }
}