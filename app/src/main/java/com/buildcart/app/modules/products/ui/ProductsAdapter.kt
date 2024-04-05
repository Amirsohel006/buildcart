package com.buildcart.app.modules.products.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowProductsBinding
import com.buildcart.app.modules.products.`data`.model.ProductsRowModel
import kotlin.Int
import kotlin.collections.List

class ProductsAdapter(
  var list: List<ProductsRowModel>
) : RecyclerView.Adapter<ProductsAdapter.RowProductsVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowProductsVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_products,parent,false)
    return RowProductsVH(view)
  }

  override fun onBindViewHolder(holder: RowProductsVH, position: Int) {
    val productsRowModel = ProductsRowModel()
    // TODO uncomment following line after integration with data source
    // val productsRowModel = list[position]
    holder.binding.productsRowModel = productsRowModel
  }

  override fun getItemCount(): Int = 8
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<ProductsRowModel>) {
    list = newData
    notifyDataSetChanged()
  }

  fun setOnItemClickListener(clickListener: OnItemClickListener) {
    this.clickListener = clickListener
  }

  interface OnItemClickListener {
    fun onItemClick(
      view: View,
      position: Int,
      item: ProductsRowModel
    ) {
    }
  }

  inner class RowProductsVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowProductsBinding = RowProductsBinding.bind(itemView)
    init {
      binding.imageRectangle105.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ProductsRowModel())
      }
      binding.txtDesignTiles.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ProductsRowModel())
      }
      binding.btnAddToCart.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ProductsRowModel())
      }
      binding.linearColumnrectangle105.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, ProductsRowModel())
      }
    }
  }
}
