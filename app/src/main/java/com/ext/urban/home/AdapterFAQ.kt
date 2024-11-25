package com.ext.urban.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.R

class AdapterFAQ : RecyclerView.Adapter<AdapterFAQ.ViewHolder>() {

    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterFAQ.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.homescreen_faq_design, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterFAQ.ViewHolder, position: Int) {

        // Handling visibility based on the expanded state
        if (position == lastPosition) {
            holder.llAns.visibility = View.VISIBLE
            holder.imgDownArrow.visibility = View.GONE
            holder.imgUpArrow.visibility = View.VISIBLE
        } else {
            holder.llAns.visibility = View.GONE
            holder.imgDownArrow.visibility = View.VISIBLE
            holder.imgUpArrow.visibility = View.GONE
        }

        holder.imgDownArrow.setOnClickListener {
            // Collapse the previously expanded item
            if (lastPosition != -1 && lastPosition != position) {
                notifyItemChanged(lastPosition)
            }

            holder.llAns.visibility = View.VISIBLE
            holder.imgDownArrow.visibility = View.GONE
            holder.imgUpArrow.visibility = View.VISIBLE

            // Update the last expanded position
            lastPosition = position
        }

        holder.imgUpArrow.setOnClickListener {

            holder.llAns.visibility = View.GONE
            holder.imgDownArrow.visibility = View.VISIBLE
            holder.imgUpArrow.visibility = View.GONE

            lastPosition = -1
        }
    }

    override fun getItemCount(): Int {
        return 3 // Change this to the actual size of your data
    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imgDownArrow: ImageView = itemView.findViewById(R.id.imgDownArrow)
        val imgUpArrow: ImageView = itemView.findViewById(R.id.imgUpArrow)
        val tvAns: TextView = itemView.findViewById(R.id.tvAns)
        val llAns: LinearLayout = itemView.findViewById(R.id.llAns)
    }
}
