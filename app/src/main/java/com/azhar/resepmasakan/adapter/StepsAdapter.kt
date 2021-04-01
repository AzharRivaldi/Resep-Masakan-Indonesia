package com.azhar.resepmasakan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.azhar.resepmasakan.R
import com.azhar.resepmasakan.model.ModelSteps

/**
 * Created by Azhar Rivaldi on 16-03-2021
 */

class StepsAdapter(private val modelSteps: List<ModelSteps>) : RecyclerView.Adapter<StepsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_steps, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelSteps[position]
        holder.tvSteps.text = data.strSteps
    }

    override fun getItemCount(): Int {
        return modelSteps.size
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvSteps: TextView

        init {
            tvSteps = itemView.findViewById(R.id.tvSteps)
        }
    }
}