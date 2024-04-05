package com.buildcart.app.modules.catogories


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R

class CategoriesProductsAdapter(private val context: Context, private val productList: List<Product>) :
    RecyclerView.Adapter<CategoriesProductsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.product_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productList[position]

        // Bind data to the views
        holder.productImage.setImageResource(product.imageRes)
        holder.productName.text = product.name
        holder.productPrice.text = "Price: $" + product.price

        // Set up the quantity spinner
        val quantityOptions = arrayOf("1", "2", "3", "4", "5")
        val quantityAdapter =
            ArrayAdapter(context, android.R.layout.simple_spinner_item, quantityOptions)
        quantityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        holder.quantitySpinner.adapter = quantityAdapter
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val productImage: ImageView = itemView.findViewById(R.id.productImage)
        val productName: TextView = itemView.findViewById(R.id.productName)
        val productPrice: TextView = itemView.findViewById(R.id.productPrice)
        val quantitySpinner: Spinner = itemView.findViewById(R.id.quantitySpinner)
    }
}

data class Product(val name: String, val price: Double, val imageRes: Int)
