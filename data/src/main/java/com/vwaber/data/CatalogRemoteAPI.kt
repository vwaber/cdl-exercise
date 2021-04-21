package com.vwaber.data

import com.vwaber.core.entities.Category
import retrofit2.Call
import retrofit2.http.GET

interface CatalogRemoteAPI {
    @GET("catalog.json")
    fun getCategories(): Call<List<Category>>
}