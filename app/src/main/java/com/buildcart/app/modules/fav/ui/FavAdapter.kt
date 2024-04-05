package com.buildcart.app.modules.fav.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowFavBinding
import com.buildcart.app.modules.fav.`data`.model.FavRowModel
import kotlin.Int
import kotlin.collections.List

class FavAdapter(
  var list: List<FavRowModel>
) : RecyclerView.Adapter<FavAdapter.RowFavVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowFavVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_fav,parent,false)
    return RowFavVH(view)
  }

  override fun onBindViewHolder(holder: RowFavVH, position: Int) {
    val favRowModel = FavRowModel()
    // TODO uncomment following line after integration with data source
    // val favRowModel = list[position]
    holder.binding.favRowModel = favRowModel
  }

  override fun getItemCount(): Int = 8
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<FavRowModel>) {
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
      item: FavRowModel
    ) {
    }
  }

  inner class RowFavVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowFavBinding = RowFavBinding.bind(itemView)
    init {
      binding.imageRectangle105.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, FavRowModel())
      }
      binding.txtDesignTiles.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, FavRowModel())
      }
      binding.btnAddToCart.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, FavRowModel())
      }
      binding.linearColumnrectangle105.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, FavRowModel())
      }
    }
  }
}
