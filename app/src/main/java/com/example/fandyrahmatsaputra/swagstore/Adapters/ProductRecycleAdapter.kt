package com.example.fandyrahmatsaputra.swagstore.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.fandyrahmatsaputra.swagstore.Model.Product
import com.example.fandyrahmatsaputra.swagstore.R

class ProductRecycleAdapter(val context: Context, val products: List<Product>) : RecyclerView.Adapter<ProductRecycleAdapter.ProductHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(context)
                .inflate(R.layout.product_list_item, parent, false)
        return ProductHolder(view)
    }

    override fun getItemCount(): Int {
        return products.count()
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder?.bindProduct(products[position], context)
    }

    inner class ProductHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        val productImage = itemView?.findViewById<ImageView>(R.id.img_product)
        val productName = itemView?.findViewById<TextView>(R.id.tv_product_name)
        val productPrice = itemView?.findViewById<TextView>(R.id.tv_product_price)

        fun bindProduct(products: Product, context: Context) {
            val resourceId = context.resources.getIdentifier(products.image,
                    "drawable",
                    context.packageName)
            productImage?.setImageResource(resourceId)
            productName?.text = products.title
            productPrice?.text = products.price
        }

    }

}