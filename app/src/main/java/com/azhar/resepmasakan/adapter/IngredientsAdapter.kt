package com.azhar.resepmasakan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azhar.resepmasakan.R
import com.azhar.resepmasakan.model.ModelIngredients

/**
 * Created by Azhar Rivaldi on 16-03-2021
 */

class IngredientsAdapter(private val modelIngredients: List<ModelIngredients>) :
        RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_ingredients, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelIngredients[position]
        holder.tvIngredients.text = data.strIngredient
    }

    override fun getItemCount(): Int {
        return modelIngredients.size
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvIngredients: TextView

        init {
            tvIngredients = itemView.findViewById(R.id.tvIngredients)
        }
    }
}