package com.example.hw_product_recycleview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.hw_product_recycleview.ProductListFragmentDirections
import com.example.hw_product_recycleview.R
import com.example.hw_product_recycleview.model.Product

class ProductAdapter (val context:Context, val dataset:List<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){
    class ProductViewHolder(view : View): RecyclerView.ViewHolder(view){
        val producrImage : ImageView = view.findViewById(R.id.product_image)
        val productName: TextView  = view.findViewById(R.id.product_name)
        val productPrice :TextView = view.findViewById(R.id.product_price)
        val productIsVip : ImageView = view.findViewById(R.id.product_isVip)
        val productQuantity:Button = view.findViewById(R.id.quantity)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val adapterToProduct = LayoutInflater.from(parent.context).inflate(R.layout.item_product_list,parent,false)
        return ProductViewHolder(adapterToProduct)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = dataset[position]
        holder.producrImage.setImageResource(item.imageSource)
        holder.productName.text = item.name
        holder.productPrice.text = context.resources.getString(R.string.price, item.price.toString())
        if (item.isVip) {
            holder.productIsVip.setImageResource(R.drawable.star)
        }
        holder.productQuantity.setOnClickListener {
            if (item.quantityNumber>0){
                val action = ProductListFragmentDirections.actionProductListFragmentToProductNameFragment(item.name)
                holder.productQuantity.findNavController().navigate(action)
            } else{
                val toast = Toast.makeText(context, "This product is not available right now", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }

    override fun getItemCount(): Int = dataset.size

}