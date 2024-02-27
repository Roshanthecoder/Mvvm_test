package com.example.test.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.test.R
import com.example.test.models.StateList


class CustomSpinnerAdapter(private val context: Context, private val data: List<StateList>) : BaseAdapter() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun getCount(): Int {
        return data.size + 1 // Add 1 for the hint
    }

    override fun getItem(position: Int): Any? {
        return if (position == 0) null else data[position - 1]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = inflater.inflate(R.layout.custom_spinner_item, parent, false)
        }

        val textView = view!!.findViewById<TextView>(R.id.textViewSpinnerItem)
        if (position == 0) {
            textView.text = "Select a state"
        } else {
            textView.text = data[position - 1].State
        }

        return view
    }
}


