package com.mobile.fintech

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class utsfragment : Fragment() {
    private lateinit var tvNama1 : TextView
    private lateinit var tvEmail1 : TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_utsfragment, container, false)
        tvNama1 = view.findViewById(R.id.tvnama1)
        tvEmail1 =view.findViewById(R.id.tvmail1)
        val data = arguments
        tvNama1.text = data!!.get("nama").toString()
        tvEmail1.text = data.get("email").toString()
        return view
    }
}