package com.buildcart.app.modules.product.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowListrectangle105FourBinding
import com.buildcart.app.modules.product.`data`.model.Listrectangle105FourRowModel
import kotlin.Int
import kotlin.collections.List

class Listrectangle105FourAdapter(
  var list: List<Listrectangle105FourRowModel>
) : RecyclerView.Adapter<Listrectangle105FourAdapter.RowListrectangle105FourVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowListrectangle105FourVH {
    val
        view=LayoutInflater.from(parent.context).inflate(R.layout.row_listrectangle105_four,parent,false)
    return RowListrectangle105FourVH(view)
  }

  override fun onBindViewHolder(holder: RowListrectangle105FourVH, position: Int) {
    val listrectangle105FourRowModel = Listrectangle105FourRowModel()
    // TODO uncomment following line after integration with data source
    // val listrectangle105FourRowModel = list[position]
    holder.binding.listrectangle105FourRowModel = listrectangle105FourRowModel
  }

  override fun getItemCount(): Int = 3
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<Listrectangle105FourRowModel>) {
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
      item: Listrectangle105FourRowModel
    ) {
    }
  }

  inner class RowListrectangle105FourVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowListrectangle105FourBinding = RowListrectangle105FourBinding.bind(itemView)
  }
}
