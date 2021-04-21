package com.vwaber.data

import com.vwaber.core.entities.Category
import com.vwaber.core.entities.Subcategory
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CatalogRemoteAPI {
    @GET("catalog.json")
    fun getCategories(): Call<List<Category>>

    @GET("catalog/{id}.json")
    fun getSubcategories(@Path("id") id: Int): Call<List<Subcategory>>
}