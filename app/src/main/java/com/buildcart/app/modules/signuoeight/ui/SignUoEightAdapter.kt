package com.buildcart.app.modules.signuoeight.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowSignUoEightBinding
import com.buildcart.app.modules.signuoeight.`data`.model.SignUoEightRowModel
import kotlin.Int
import kotlin.collections.List

class SignUoEightAdapter(
  var list: List<SignUoEightRowModel>
) : RecyclerView.Adapter<SignUoEightAdapter.RowSignUoEightVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowSignUoEightVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_sign_uo_eight,parent,false)
    return RowSignUoEightVH(view)
  }

  override fun onBindViewHolder(holder: RowSignUoEightVH, position: Int) {
    val signUoEightRowModel = SignUoEightRowModel()
    // TODO uncomment following line after integration with data source
    // val signUoEightRowModel = list[position]
    holder.binding.signUoEightRowModel = signUoEightRowModel
  }

  override fun getItemCount(): Int = 4
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<SignUoEightRowModel>) {
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
      item: SignUoEightRowModel
    ) {
    }
  }

  inner class RowSignUoEightVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowSignUoEightBinding = RowSignUoEightBinding.bind(itemView)
  }
}
