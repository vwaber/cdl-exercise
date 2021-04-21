package com.vwaber.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.vwaber.core.entities.Category
import com.vwaber.core.entities.Subcategory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object CatalogRemoteClient {

    private const val BASE_URL: String = "http://yardclub.github.io/mobile-interview/api/"
    private const val AMBIGUOUS_ERROR = "Successfully failed"

    private val moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private val api: CatalogRemoteAPI = retrofit.create(CatalogRemoteAPI::class.java)

    fun getCategories(onSuccess: (List<Category>) -> Unit, onFailure: (Throwable) -> Unit) {
        api.getCategories().enqueue(
            object : Callback<List<Category>> {
                override fun onResponse(
                    call: Call<List<Category>>,
                    response: Response<List<Category>>
                ) {
                    response.body()?.let { onSuccess(it) } ?: onFailure(Throwable(AMBIGUOUS_ERROR))
                }

                override fun onFailure(call: Call<List<Category>>, t: Throwable) {
                    onFailure(t)
                }
            }
        )
    }

    fun getSubcategories(
        id: Int,
        onSuccess: (List<Subcategory>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        api.getSubcategories(id).enqueue(
            object : Callback<List<Subcategory>> {
                override fun onResponse(
                    call: Call<List<Subcategory>>,
                    response: Response<List<Subcategory>>
                ) {
                    response.body()?.let { onSuccess(it) } ?: onFailure(Throwable(AMBIGUOUS_ERROR))
                }

                override fun onFailure(call: Call<List<Subcategory>>, t: Throwable) {
                    onFailure(t)
                }
            }
        )
    }

}
