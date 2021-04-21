package com.vwaber.cdlexercise.ui.catalog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vwaber.core.CatalogUseCases
import com.vwaber.core.entities.Subcategory
import com.vwaber.data.CatalogRepository

class SubcategoriesViewModel(id: Int) : ViewModel() {

    private val _subcategories = MutableLiveData<List<Subcategory>>().apply {
        CatalogUseCases(CatalogRepository).loadSubcategories(id, { value = it }, {})
    }
    val subcategories: LiveData<List<Subcategory>> = _subcategories

}
