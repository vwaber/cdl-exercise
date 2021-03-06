package com.vwaber.cdlexercise.ui.catalog

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.vwaber.core.entities.Category
import com.vwaber.cdlexercise.databinding.ItemCatalogCategoryBinding

class CatalogCategoryRecyclerViewAdapter(private val values: List<Category>) :
    RecyclerView.Adapter<CatalogCategoryRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemCatalogCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.binding.tvName.text = item.name

        holder.binding.root.setOnClickListener {
            it.findNavController().navigate(
                CatalogCategoryFragmentDirections.actionNavigationCatalogCategoryToCatalogSubcategoryFragment(
                    item.id
                )
            )
        }
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: ItemCatalogCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

}
