package com.buildcart.app.modules.orders.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.databinding.OrderItemLayoutBinding
import com.buildcart.app.modules.orders.data.model.OrdersData
import com.buildcart.app.modules.orders.data.viewmodel.OrdersResponse

class OrdersAdapter(private var ordersResponse: OrdersResponse) :
    RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: OrderItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(orderData: OrdersData) {
            // Bind your data to the layout using the data binding library or standard views
            binding.order = orderData

            // Access the product details and bind them to the respective views
            val product = orderData.product
            binding.textProductName.text = product?.description
            binding.textOrderStatus.visibility = View.VISIBLE
            binding.textOrderStatus.text = orderData.orderStatus

            // Customize visibility based on the order status (modify as needed)
            when (orderData.orderStatus) {
                "pending", "delivered" -> {
                    // Set visibility for active and completed orders
                    // Customize other views as needed
                    binding.btnReorder.visibility = View.VISIBLE
                    binding.btnViewDetails.visibility = View.VISIBLE
                }
                "cancelled" -> {
                    // Set visibility for cancelled orders
                    // Customize other views as needed
                    binding.btnReorder.visibility = View.GONE
                    binding.btnViewDetails.visibility = View.VISIBLE
                }
                else -> {
                    // Handle other order status if needed
                }
            }

            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            OrderItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(ordersResponse.response[position])
    }

    fun updateData(newOrdersResponse: OrdersResponse) {
        ordersResponse = newOrdersResponse
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return ordersResponse.response.size
    }
}
