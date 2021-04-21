package com.vwaber.cdlexercise.ui.catalog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vwaber.cdlexercise.databinding.ItemCatalogCategoryBinding
import com.vwaber.core.entities.Subcategory

class CatalogSubcategoryRecyclerViewAdapter(private val values: List<Subcategory>) :
    RecyclerView.Adapter<CatalogSubcategoryRecyclerViewAdapter.ViewHolder>() {

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
        holder.binding.tvName.text = item.display_name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: ItemCatalogCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

}
