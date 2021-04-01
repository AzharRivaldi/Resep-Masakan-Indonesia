package com.azhar.resepmasakan.realm

import android.content.Context
import com.azhar.resepmasakan.model.ModelRecipes
import io.realm.Realm
import java.util.*

/**
 * Created by Azhar Rivaldi on 16-03-2021
 */

class RealmHelper(context: Context) {

    val realm: Realm

    init {
        Realm.init(context)
        realm = Realm.getDefaultInstance()
    }

    //show favorite
    fun showFavoriteRecipes(): ArrayList<ModelRecipes> {
        val data = ArrayList<ModelRecipes>()
        val modelRecipes = realm.where(ModelRecipes::class.java).findAll()
        if (modelRecipes.size > 0) {
            for (i in modelRecipes.indices) {
                val listRecipes = ModelRecipes()
                listRecipes.strKeyResep = modelRecipes[i]!!.strKeyResep
                listRecipes.strTitleResep = modelRecipes[i]!!.strTitleResep
                listRecipes.strThumbnail = modelRecipes[i]!!.strThumbnail
                listRecipes.strDificulty = modelRecipes[i]!!.strDificulty
                listRecipes.strPortion = modelRecipes[i]!!.strPortion
                listRecipes.strTimes = modelRecipes[i]!!.strTimes
                data.add(listRecipes)
            }
        }
        return data
    }

    //insert favorite
    fun addFavoriteRecipes(KeyResep: String?, TitleResep: String?, Thumbnail: String?,
                           Dificulty: String?, StrPortion: String?, Times: String?) {
        val listRecipes = ModelRecipes()
        listRecipes.strKeyResep = KeyResep
        listRecipes.strTitleResep = TitleResep
        listRecipes.strThumbnail = Thumbnail
        listRecipes.strDificulty = Dificulty
        listRecipes.strPortion = StrPortion
        listRecipes.strTimes = Times
        realm.beginTransaction()
        realm.copyToRealm(listRecipes)
        realm.commitTransaction()

    }

    //delete favorite
    fun deleteFavoriteRecipes(KeyResep: String?) {
        realm.beginTransaction()
        val listRecipes = realm.where(ModelRecipes::class.java).equalTo("KeyResep", KeyResep).findAll()
        listRecipes.deleteAllFromRealm()
        realm.commitTransaction()

    }

}