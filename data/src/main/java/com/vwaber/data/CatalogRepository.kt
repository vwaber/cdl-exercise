package com.vwaber.data

import com.vwaber.core.CatalogDataSource
import com.vwaber.core.entities.Category
import com.vwaber.core.entities.Subcategory

object CatalogRepository : CatalogDataSource {

    override fun loadCategories(
        onSuccess: (List<Category>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) =
        CatalogRemoteClient.getCategories(onSuccess, onFailure)

    override fun loadSubcategories(
        id: Int,
        onSuccess: (List<Subcategory>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) =
        CatalogRemoteClient.getSubcategories(id, onSuccess, onFailure)

}
