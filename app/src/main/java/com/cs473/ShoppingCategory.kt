package com.cs473

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs473.adapter.CategoryItemAdapter
import com.cs473.databinding.ActivityShoppingCategoryBinding
import com.cs473.model.Product

class ShoppingCategory : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShoppingCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.contentLayout.usernameTv.text = intent.getStringExtra("username")
        setUpRecyclerView()
    }

    private fun setUpRecyclerView(){
        val recyclerView = binding.contentLayout.recyclerView
        val adapter = CategoryItemAdapter(intent!!.getParcelableArrayListExtra<Product>("products") as ArrayList<Product>) { product: Product ->
           val intent = Intent(this, ScrollingActivity::class.java)
            intent.putExtra("product", product)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.layoutManager = LinearLayoutManager(this)

    }

}