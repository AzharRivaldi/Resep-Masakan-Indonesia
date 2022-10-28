package com.azhar.resepmasakan.networking

/**
 * Created by Azhar Rivaldi on 06-03-2021
 */

object ApiEndpoint {
    var BASEURL = "https://masak-apa-tomorisakura.vercel.app"
    var PAGE = "/api/recipes/{page}"
    var CATEGORIES = "/api/category/recipes"
    var LIST_CATEGORIES = "/api/category/recipes/{key}"
    var DETAIL_RECIPES = "/api/recipe/{key}"
    var SEARCH_RECIPES = "/api/search/?q={query}"
}
