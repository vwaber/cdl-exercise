package com.vwaber.cdlexercise.ui.catalog

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vwaber.cdlexercise.R
import com.vwaber.cdlexercise.ui.catalog.dummy.DummyContent

class CatalogCategoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_catalog_category_list, container, false)

        if (view is RecyclerView) {
            with(view) {
                layoutManager =  LinearLayoutManager(context)
                adapter = CatalogCategoryRecyclerViewAdapter(DummyContent.ITEMS)
            }
        }
        return view
    }

}