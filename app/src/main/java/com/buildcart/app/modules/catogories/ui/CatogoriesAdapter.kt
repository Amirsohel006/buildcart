package com.buildcart.app.modules.catogories.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowCatogoriesBinding
import com.buildcart.app.modules.catogories.`data`.model.CatogoriesRowModel
import kotlin.Int
import kotlin.collections.List

class CatogoriesAdapter(
  var list: List<CatogoriesRowModel>
) : RecyclerView.Adapter<CatogoriesAdapter.RowCatogoriesVH>() {
  private var clickListener: OnItemClickListener? = null

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowCatogoriesVH {
    val view=LayoutInflater.from(parent.context).inflate(R.layout.row_catogories,parent,false)
    return RowCatogoriesVH(view)
  }

  override fun onBindViewHolder(holder: RowCatogoriesVH, position: Int) {
    val catogoriesRowModel = CatogoriesRowModel()
    // TODO uncomment following line after integration with data source
    // val catogoriesRowModel = list[position]
    holder.binding.catogoriesRowModel = catogoriesRowModel
  }

  override fun getItemCount(): Int = 6
  // TODO uncomment following line after integration with data source
  // return list.size

  public fun updateData(newData: List<CatogoriesRowModel>) {
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
      item: CatogoriesRowModel
    ) {
    }
  }

  inner class RowCatogoriesVH(
    view: View
  ) : RecyclerView.ViewHolder(view) {
    val binding: RowCatogoriesBinding = RowCatogoriesBinding.bind(itemView)
    init {
      binding.linearColumncategoryone.setOnClickListener {
        // TODO replace with value from datasource
        clickListener?.onItemClick(it, adapterPosition, CatogoriesRowModel())
      }
    }
  }
}
