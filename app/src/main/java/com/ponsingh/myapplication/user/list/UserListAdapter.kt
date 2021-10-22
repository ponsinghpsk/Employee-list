package com.ponsingh.myapplication.user.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ponsingh.myapplication.databinding.UserListItemBinding

class UserListAdapter(val list:ArrayList<UserListModel>,val listner:UserClickListner): RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val binding= UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent,false)

      return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.model= list[position]
        holder.binding.listner=listner

    }

    override fun getItemCount(): Int {
        return list.size

    }
}