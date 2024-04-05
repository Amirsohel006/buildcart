package com.buildcart.app.modules.ordersfive.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowOrdersFiveBinding
import com.buildcart.app.modules.ordersfive.`data`.model.OrdersFiveRowModel
import kotlin.Int
import kotlin.collections.List

class OrdersFiveAdapter(
  var list: List<OrdersFiveRowModel>
) : RecyclerView.Adapter<OrdersFiveAdapter.RowOrdersFiveVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowOrdersFiveVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_orders_five,parent,false)
    return RowOrdersFiveVH(view)
  }

  override fun onBindViewHolder(holder: RowOrdersFiveVH, position: Int) {
    val ordersFiveRowModel = OrdersFiveRowModel()
    // TODO uncomment following line after integration with data source
    // val ordersFiveRowModel = list[position]
    holder.binding.ordersFiveRowModel = ordersFiveRowModel
  }

  override fun getItemCount(): Int = 2
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<OrdersFiveRowModel>) {
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
      item: OrdersFiveRowModel
    ) {
    }
  }

  inner class RowOrdersFiveVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowOrdersFiveBinding = RowOrdersFiveBinding.bind(itemView)
  }
}
