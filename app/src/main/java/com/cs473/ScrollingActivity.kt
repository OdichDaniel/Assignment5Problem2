package com.cs473

import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.cs473.databinding.ActivityScrollingBinding
import com.cs473.model.Product

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))

        val product = intent.getParcelableExtra<Product>("product")!!
        binding.image.setImageResource(product.imageUri)
        binding.scrollingContent.name.text = product.title
        binding.scrollingContent.color.text = "Color: ${product.color}"
        binding.scrollingContent.itemNumber.text = "Walmart #: ${product.itemId}"
        binding.scrollingContent.itemDescription.text = product.desc
    }
}