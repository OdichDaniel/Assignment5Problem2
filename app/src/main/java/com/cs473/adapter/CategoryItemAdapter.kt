package com.cs473.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cs473.databinding.CategoryItemLayoutBinding
import com.cs473.model.Product

class CategoryItemAdapter(private val items: ArrayList<Product>, val onClickCallback: (product: Product) -> Unit): RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder>() {

    private lateinit var binding: CategoryItemLayoutBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryItemViewHolder {
        binding = CategoryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryItemViewHolder, position: Int) {
        holder.bind(items.get(position))
    }

    override fun getItemCount(): Int = items.size

    inner class CategoryItemViewHolder(private val categoryView: CategoryItemLayoutBinding): RecyclerView.ViewHolder(categoryView.root){
        fun bind(item: Product){
            categoryView.shoppingItemTv.text = item.title
            categoryView.price.text = "Price: $${item.price}"
            categoryView.color.text = "Color: ${item.color}"
            categoryView.imageview.setImageResource(item.imageUri)
            categoryView.root.setOnClickListener{
                onClickCallback.invoke(item)
            }

        }
    }
}