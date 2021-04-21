package com.vwaber.cdlexercise.ui.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vwaber.cdlexercise.databinding.FragmentCatalogCategoryListBinding

class CatalogCategoryFragment : Fragment() {

    private lateinit var catalogViewModel: CatalogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCatalogCategoryListBinding.inflate(layoutInflater)

        catalogViewModel =
            ViewModelProvider(this).get(CatalogViewModel::class.java)

        with(binding.rvCategories) {
            layoutManager = LinearLayoutManager(context)
            catalogViewModel.categories.observe(viewLifecycleOwner, Observer {
                adapter = CatalogCategoryRecyclerViewAdapter(it)
            })
        }

        return binding.root
    }

}
