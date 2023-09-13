package com.example.daggerretrofitapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.daggerretrofitapp.R
import com.example.daggerretrofitapp.model.User
import com.example.daggerretrofitapp.viewmodel.OnClickItemListener

class MyAdapter(
    private val context: Context,
    private val list: List<User>,
    private val listener: OnClickItemListener
): RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_person_layout, null, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            listener.onItemClick(position)
        }
    }
}