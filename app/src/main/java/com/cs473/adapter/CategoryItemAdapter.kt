package com.cs473.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.cs473.databinding.CategoryItemLayoutBinding
import com.cs473.model.ShoppingItem

class CategoryItemAdapter(private val items: Array<ShoppingItem>): RecyclerView.Adapter<CategoryItemAdapter.CategoryItemViewHolder>() {

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
        fun bind(item: ShoppingItem){
            categoryView.shoppingItemTv.text = item.title
            categoryView.imageview.setImageResource(item.imageUri)
            categoryView.root.setOnClickListener{
                Toast.makeText(categoryView.root.context, "You have chosen " + item.title + " category of shopping", Toast.LENGTH_SHORT).show()
            }
        }
    }
}