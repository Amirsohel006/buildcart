package com.buildcart.app.modules.tile.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowTileBinding
import com.buildcart.app.modules.tile.`data`.model.TileRowModel
import kotlin.Int
import kotlin.collections.List

class TileAdapter(
  var list: List<TileRowModel>
) : RecyclerView.Adapter<TileAdapter.RowTileVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowTileVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_tile,parent,false)
    return RowTileVH(view)
  }

  override fun onBindViewHolder(holder: RowTileVH, position: Int) {
    val tileRowModel = TileRowModel()
    // TODO uncomment following line after integration with data source
    // val tileRowModel = list[position]
    holder.binding.tileRowModel = tileRowModel
  }

  override fun getItemCount(): Int = 12
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<TileRowModel>) {
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
      item: TileRowModel
    ) {
    }
  }

  inner class RowTileVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowTileBinding = RowTileBinding.bind(itemView)
    init {
      binding.imageRectangle105.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, TileRowModel())
      }
      binding.txtDesignTiles.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, TileRowModel())
      }
      binding.btnAddToCart.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, TileRowModel())
      }
      binding.linearColumnrectangle105.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, TileRowModel())
      }
    }
  }
}
