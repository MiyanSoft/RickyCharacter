package com.miyansoft.rickycharacter.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.miyansoft.rickycharacter.R
import com.miyansoft.rickycharacter.data.model.User


class MainAdapter(private val users: ArrayList<User>) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)
        val tvStatus = itemView.findViewById<TextView>(R.id.tvStatus)
        val tvSpecies = itemView.findViewById<TextView>(R.id.tvSpecies)
        val imgCharacter = itemView.findViewById<ImageView>(R.id.imgCharacter)

        fun bind(user: User) {
            itemView.apply {
                tvName.text = user.name
                tvStatus.text = user.status
                tvSpecies.text = user.species
                Glide.with(imgCharacter.context)
                    .load(user.image)
                    .into(imgCharacter)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))


    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        holder.bind(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    fun addUsers(users: List<User>) {
        this.users.apply {
            clear()
            addAll(users)
        }
    }
}