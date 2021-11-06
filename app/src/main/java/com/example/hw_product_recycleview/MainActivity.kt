package com.example.hw_product_recycleview

import adapter.ProductAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_product_recycleview.databinding.ActivityMainBinding
import data.DataSource

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val data = DataSource().loadProduct()
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ProductAdapter(this,data)
        recyclerView.setHasFixedSize(true)

    }
}