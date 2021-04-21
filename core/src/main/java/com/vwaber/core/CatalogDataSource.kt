package com.vwaber.core

import com.vwaber.core.entities.Category

interface CatalogDataSource {

    fun loadCategories(onSuccess: (List<Category>) -> Unit, onFailure: (Throwable) -> Unit)

}