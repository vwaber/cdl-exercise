package com.vwaber.core

import com.vwaber.core.entities.Category

class CatalogUseCases constructor(private val dataSource: CatalogDataSource) {

    fun loadCategories(onSuccess: (List<Category>) -> Unit, onFailure: (Throwable) -> Unit) =
        dataSource.loadCategories(onSuccess, onFailure)

}