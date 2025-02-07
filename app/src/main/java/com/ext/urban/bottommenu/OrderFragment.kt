package com.ext.urban.bottommenu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ext.urban.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapterPurchases = AdapterPurchases(requireContext())

        val rvPurchases: RecyclerView = view.findViewById(R.id.rvPurchases)
        rvPurchases.layoutManager = LinearLayoutManager(context)
        rvPurchases.adapter = adapterPurchases

        val tvAll : TextView = view.findViewById(R.id.tvAll)
        val tvNew : TextView = view.findViewById(R.id.tvNew)
        val tvOngoing : TextView = view.findViewById(R.id.tvOngoing)
        val tvCompleted : TextView = view.findViewById(R.id.tvCompleted)


        tvAll.setOnClickListener {
            tvAll.setBackgroundResource(R.drawable.rounded_corner_white)
            tvNew.setBackgroundResource(0)
            tvOngoing.setBackgroundResource(0)
            tvCompleted.setBackgroundResource(0)
        }

        tvNew.setOnClickListener {
            tvNew.setBackgroundResource(R.drawable.rounded_corner_white)
            tvAll.setBackgroundResource(0)
            tvOngoing.setBackgroundResource(0)
            tvCompleted.setBackgroundResource(0)
        }

        tvOngoing.setOnClickListener {
            tvOngoing.setBackgroundResource(R.drawable.rounded_corner_white)
            tvNew.setBackgroundResource(0)
            tvAll.setBackgroundResource(0)
            tvCompleted.setBackgroundResource(0)
        }

        tvCompleted.setOnClickListener {
            tvCompleted.setBackgroundResource(R.drawable.rounded_corner_white)
            tvAll.setBackgroundResource(0)
            tvOngoing.setBackgroundResource(0)
            tvNew.setBackgroundResource(0)
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment OrderFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            OrderFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}