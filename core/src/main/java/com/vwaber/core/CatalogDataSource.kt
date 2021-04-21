package com.vwaber.core

import com.vwaber.core.entities.Category
import com.vwaber.core.entities.Subcategory

interface CatalogDataSource {

    fun loadCategories(onSuccess: (List<Category>) -> Unit, onFailure: (Throwable) -> Unit)
    fun loadSubcategories(id: Int, onSuccess: (List<Subcategory>) -> Unit, onFailure: (Throwable) -> Unit)

}