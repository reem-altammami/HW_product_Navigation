package com.example.hw_product_recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ProductPageActivity : AppCompatActivity() {
    companion object{
        const val productName = "name"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_page)
        val product = intent?.extras?.getString(productName).toString()
        val text : TextView = findViewById(R.id.showProduct)
        text.text = product
    }
}