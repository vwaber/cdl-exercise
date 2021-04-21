package com.vwaber.cdlexercise.ui.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vwaber.core.CatalogUseCases
import com.vwaber.core.entities.Category
import com.vwaber.data.CatalogRepository

class CatalogViewModel : ViewModel() {

    private val _categories = MutableLiveData<List<Category>>().apply {
        CatalogUseCases(CatalogRepository).loadCategories({ value = it }, {})
    }
    val categories: LiveData<List<Category>> = _categories

}