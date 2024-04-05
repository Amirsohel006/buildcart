package com.buildcart.app.modules.product.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowListrectangle105OneBinding
import com.buildcart.app.modules.product.`data`.model.Listrectangle105OneRowModel
import kotlin.Int
import kotlin.collections.List

class Listrectangle105OneAdapter(
  var list: List<Listrectangle105OneRowModel>
) : RecyclerView.Adapter<Listrectangle105OneAdapter.RowListrectangle105OneVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle105OneVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle105_one,parent,false)
    return RowListrectangle105OneVH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle105OneVH, position: Int) {
    val listrectangle105OneRowModel = Listrectangle105OneRowModel()
    // TODO uncomment following line after integration with data source
    // val listrectangle105OneRowModel = list[position]
    holder.binding.listrectangle105OneRowModel = listrectangle105OneRowModel
  }

  override fun getItemCount(): Int = 3
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectangle105OneRowModel>) {
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
      item: Listrectangle105OneRowModel
    ) {
    }
  }

  inner class RowListrectangle105OneVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectangle105OneBinding = RowListrectangle105OneBinding.bind(itemView)
  }
}
