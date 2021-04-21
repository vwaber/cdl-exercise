package com.vwaber.data

import com.vwaber.core.CatalogDataSource
import com.vwaber.core.entities.Category

object CatalogRepository : CatalogDataSource {

    override fun loadCategories(onSuccess: (List<Category>) -> Unit, onFailure: (Throwable) -> Unit) =
        CatalogRemoteClient.getCategories(onSuccess, onFailure)

}
