package com.azhar.resepmasakan.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.azhar.resepmasakan.R
import com.azhar.resepmasakan.activities.DetailRecipesActivity
import com.azhar.resepmasakan.model.ModelRecipes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

/**
 * Created by Azhar Rivaldi on 16-03-2021
 */

class FavoritesAdapter(private val context: Context, private val modelRecipes: List<ModelRecipes>) :
        RecyclerView.Adapter<FavoritesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_favorite, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = modelRecipes[position]
        Glide.with(context)
                .load(data.strThumbnail)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageThumbnail)
        holder.tvTitleRecipe.text = data.strTitleResep
        holder.tvDificulty.text = data.strDificulty
        holder.tvPortion.text = data.strPortion
        holder.tvTimes.text = data.strTimes
        holder.cvListRecipe.setOnClickListener {
            val intent = Intent(context, DetailRecipesActivity::class.java)
            intent.putExtra(DetailRecipesActivity.DETAIL_RECIPES, modelRecipes[position])
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return modelRecipes.size
    }

    internal class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cvListRecipe: CardView
        var imageThumbnail: ImageView
        var tvTitleRecipe: TextView
        var tvDificulty: TextView
        var tvPortion: TextView
        var tvTimes: TextView

        init {
            cvListRecipe = itemView.findViewById(R.id.cvListRecipe)
            imageThumbnail = itemView.findViewById(R.id.imageThumbnail)
            tvTitleRecipe = itemView.findViewById(R.id.tvTitleRecipe)
            tvDificulty = itemView.findViewById(R.id.tvDificulty)
            tvPortion = itemView.findViewById(R.id.tvPortion)
            tvTimes = itemView.findViewById(R.id.tvTimes)
        }
    }
}