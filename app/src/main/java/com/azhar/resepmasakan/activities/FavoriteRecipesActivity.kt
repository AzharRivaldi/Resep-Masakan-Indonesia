package com.azhar.resepmasakan.activities

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.azhar.resepmasakan.R
import com.azhar.resepmasakan.adapter.FavoritesAdapter
import com.azhar.resepmasakan.model.ModelRecipes
import com.azhar.resepmasakan.realm.RealmHelper
import kotlinx.android.synthetic.main.activity_favorite_recipes.*
import java.util.*

class FavoriteRecipesActivity : AppCompatActivity() {

    var modelRecipes: MutableList<ModelRecipes> = ArrayList()
    var helper: RealmHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_recipes)

        helper = RealmHelper(this)

        setSupportActionBar(toolbar)
        assert(supportActionBar != null)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        rvListFavorite.setLayoutManager(LinearLayoutManager(this))
        rvListFavorite.setAdapter(FavoritesAdapter(this, modelRecipes))
        rvListFavorite.setHasFixedSize(true)

        //menampilkan data favorite
        getFavorite()
    }

    private fun getFavorite() {
            modelRecipes = helper!!.showFavoriteRecipes()
            if (modelRecipes.size == 0) {
                tvNoData.visibility = View.VISIBLE
                rvListFavorite.visibility = View.GONE
            } else {
                tvNoData.visibility = View.GONE
                rvListFavorite.visibility = View.VISIBLE
                rvListFavorite.adapter = FavoritesAdapter(this, modelRecipes)
            }
        }

    public override fun onResume() {
        super.onResume()
        getFavorite()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}