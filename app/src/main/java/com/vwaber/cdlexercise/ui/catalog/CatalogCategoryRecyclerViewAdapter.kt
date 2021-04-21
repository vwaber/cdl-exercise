package com.vwaber.cdlexercise.ui.catalog

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

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
        holder.binding.itemNumber.text = item.id.toString()
        holder.binding.content.text = item.name
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(val binding: ItemCatalogCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

}