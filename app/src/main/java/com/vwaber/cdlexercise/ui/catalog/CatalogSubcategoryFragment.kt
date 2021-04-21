package com.vwaber.cdlexercise.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.vwaber.cdlexercise.databinding.FragmentCatalogCategoryListBinding

class CatalogSubcategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCatalogCategoryListBinding.inflate(layoutInflater)

        arguments?.let { bundle ->
            val id = CatalogSubcategoryFragmentArgs.fromBundle(bundle).id
            val viewModelFactory = SubcategoriesViewModelFactory(id)
            val viewModel = ViewModelProvider(this, viewModelFactory)
                .get(SubcategoriesViewModel::class.java)
            with(binding.rvCategories) {
                layoutManager = LinearLayoutManager(context)
                viewModel.subcategories.observe(viewLifecycleOwner, Observer {
                    adapter = CatalogSubcategoryRecyclerViewAdapter(it)
                })
            }
        }

        return binding.root
    }

    class SubcategoriesViewModelFactory(private val finalScore: Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(SubcategoriesViewModel::class.java)) {
                return SubcategoriesViewModel(finalScore) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}
