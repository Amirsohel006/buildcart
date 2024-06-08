package com.buildcart.app.modules.signuofive.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.modules.responses.AddressResponse

class AddressAdapter(var list: List<AddressResponse>) : RecyclerView.Adapter<AddressAdapter.ViewHolder>() {

    private var selectedAddressId: Int = -1

    private var selectedAddress: AddressResponse? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_cart_address, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddressAdapter.ViewHolder, position: Int) {
        holder.bindView(list[position], position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val locality: TextView = itemView.findViewById(R.id.txtLanguage)
        val flatno: TextView = itemView.findViewById(R.id.txtLanguage1)
        val city: TextView = itemView.findViewById(R.id.txtLanguage2)
        val state: TextView = itemView.findViewById(R.id.txtLanguage3)
        val pincode: TextView = itemView.findViewById(R.id.txtLanguage4)

        val radioButton: RadioButton = itemView.findViewById(R.id.viewEllipseSix)
        val itemContainer: View = itemView.findViewById(R.id.container) // Replace with your container ID

        val customerName: TextView = itemView.findViewById(R.id.txtRahul)
        val phoneNumber: TextView = itemView.findViewById(R.id.txtPhone75859941)

        fun bindView(postModel: AddressResponse, position: Int) {
            locality.text = postModel.area
            flatno.text = postModel.houseNo
            city.text = postModel.city
            state.text = postModel.state
            pincode.text = postModel.pincode
            customerName.text = postModel.fullName
            phoneNumber.text = postModel.mobileNumber

            radioButton.isChecked = postModel.id == selectedAddressId

            radioButton.setOnClickListener {
                selectAddress(postModel)
            }

            itemContainer.setOnClickListener {
                selectAddress(postModel)
            }
        }
    }

    private fun selectAddress(address: AddressResponse) {
        selectedAddressId = address.id!!
        selectedAddress = address
        notifyDataSetChanged()
    }

    fun getSelectedAddress(): AddressResponse? {
        return selectedAddress
    }
}
