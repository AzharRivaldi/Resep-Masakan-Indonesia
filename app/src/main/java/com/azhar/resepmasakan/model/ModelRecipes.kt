package com.azhar.resepmasakan.model

import io.realm.RealmObject
import java.io.Serializable

/**
 * Created by Azhar Rivaldi on 14-03-2021
 */

class ModelRecipes : RealmObject(), Serializable {
    var strTitleResep: String? = null
    var strThumbnail: String? = null
    var strKeyResep: String? = null
    var strTimes: String? = null
    var strPortion: String? = null
    var strDificulty: String? = null
}