package com.buildcart.app.modules.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.databinding.RowHomeBinding
import com.buildcart.app.modules.home.data.model.HomeRowModel

class CategoryAdapterForDummy:
    RecyclerView.Adapter<CategoryAdapterForDummy.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.categories_item_layout, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        // Bind your data here
        //holder.cardTitle.text = items[position]
    }

    override fun getItemCount(): Int = 6

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val cardTitle: TextView = itemView.findViewById(R.id.card_title)
//        val cardTime: TextView = itemView.findViewById(R.id.card_time)
//        val cardStatus: TextView = itemView.findViewById(R.id.card_status)

        val cardView:CardView=itemView.findViewById(R.id.cardview)

        init {

            cardView.setOnClickListener {
                Toast.makeText(itemView.context,"Please Sign-up or Login To Access All the products",Toast.LENGTH_LONG).show()
            }
        }
    }
}
