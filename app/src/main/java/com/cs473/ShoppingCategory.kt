package com.cs473

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cs473.adapter.CategoryItemAdapter
import com.cs473.databinding.ActivityShoppingCategoryBinding
import com.cs473.model.ShoppingItem

class ShoppingCategory : AppCompatActivity() {

    private lateinit var binding: ActivityShoppingCategoryBinding
    private val items = arrayOf(
        ShoppingItem("Electronics", R.drawable.electronics),
        ShoppingItem("Clothing", R.drawable.clothing),
        ShoppingItem("Beauty", R.drawable.beauty),
        ShoppingItem("Food", R.drawable.food)
    )

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
        val adapter = CategoryItemAdapter(items)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = GridLayoutManager(this, 2)

    }

}