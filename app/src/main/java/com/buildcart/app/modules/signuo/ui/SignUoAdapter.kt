package com.buildcart.app.modules.signuo.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowSignUoBinding
import com.buildcart.app.modules.signuo.`data`.model.SignUoRowModel
import kotlin.Int
import kotlin.collections.List

class SignUoAdapter(
  var list: List<SignUoRowModel>
) : RecyclerView.Adapter<SignUoAdapter.RowSignUoVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowSignUoVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_sign_uo,parent,false)
    return RowSignUoVH(view)
  }

  override fun onBindViewHolder(holder: RowSignUoVH, position: Int) {
    val signUoRowModel = SignUoRowModel()
    // TODO uncomment following line after integration with data source
    // val signUoRowModel = list[position]
    holder.binding.signUoRowModel = signUoRowModel
  }

  override fun getItemCount(): Int = 1
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<SignUoRowModel>) {
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
      item: SignUoRowModel
    ) {
    }
  }

  inner class RowSignUoVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowSignUoBinding = RowSignUoBinding.bind(itemView)
  }
}
