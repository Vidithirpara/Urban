package com.ext.urban.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.databinding.RawFaqBinding

class AdapterFAQ : RecyclerView.Adapter<AdapterFAQ.ViewHolder>() {

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RawFaqBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (position == lastPosition) {
            holder.binding.llAns.visibility = View.VISIBLE
            holder.binding.imgDownArrow.visibility = View.GONE
            holder.binding.imgUpArrow.visibility = View.VISIBLE
        } else {
            holder.binding.llAns.visibility = View.GONE
            holder.binding.imgDownArrow.visibility = View.VISIBLE
            holder.binding.imgUpArrow.visibility = View.GONE
        }

        holder.binding.imgDownArrow.setOnClickListener {
            if (lastPosition != -1 && lastPosition != position) {
                notifyItemChanged(lastPosition)
            }

            holder.binding.llAns.visibility = View.VISIBLE
            holder.binding.imgDownArrow.visibility = View.GONE
            holder.binding.imgUpArrow.visibility = View.VISIBLE

            lastPosition = position
        }

        holder.binding.imgUpArrow.setOnClickListener {

            holder.binding.llAns.visibility = View.GONE
            holder.binding.imgDownArrow.visibility = View.VISIBLE
            holder.binding.imgUpArrow.visibility = View.GONE

            lastPosition = -1
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(val binding: RawFaqBinding) : RecyclerView.ViewHolder(binding.root)
}
