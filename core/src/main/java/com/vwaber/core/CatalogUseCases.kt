package com.vwaber.core

import com.vwaber.core.entities.Category
import com.vwaber.core.entities.Subcategory

class CatalogUseCases constructor(private val dataSource: CatalogDataSource) {

    fun loadCategories(onSuccess: (List<Category>) -> Unit, onFailure: (Throwable) -> Unit) =
        dataSource.loadCategories(onSuccess, onFailure)

    fun loadSubcategories(
        id: Int,
        onSuccess: (List<Subcategory>) -> Unit,
        onFailure: (Throwable) -> Unit
    ) =
        dataSource.loadSubcategories(id, onSuccess, onFailure)

}