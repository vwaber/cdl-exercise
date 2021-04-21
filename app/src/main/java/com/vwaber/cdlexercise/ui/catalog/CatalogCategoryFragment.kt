package com.vwaber.cdlexercise.ui.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vwaber.cdlexercise.R

class CatalogCategoryFragment : Fragment() {

    private lateinit var catalogViewModel: CatalogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_catalog_category_list, container, false)

        catalogViewModel =
            ViewModelProvider(this).get(CatalogViewModel::class.java)

        if (view is RecyclerView) {
            with(view) {
                layoutManager =  LinearLayoutManager(context)
                catalogViewModel.categories.observe(viewLifecycleOwner, Observer {
                    adapter = CatalogCategoryRecyclerViewAdapter(it)
                })
            }
        }
        return view
    }

}