package com.buildcart.app.modules.signuofive.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.modules.responses.AddressResponse
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class AddressAdapter(  var list: List<AddressResponse> ): RecyclerView.Adapter<AddressAdapter.ViewHolder>() {

    //private var selectedPosition = -1
    private var selectedAddressId: Int = -1
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddressAdapter.ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.row_cart_address,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AddressAdapter.ViewHolder, position: Int) {
        return  holder.bindView(list[position],position)
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // ...

        val locality:TextView=itemView.findViewById(R.id.txtLanguage)
        val flatno:TextView=itemView.findViewById(R.id.txtLanguage1)
        val city:TextView=itemView.findViewById(R.id.txtLanguage2)
        val state:TextView=itemView.findViewById(R.id.txtLanguage3)
        val pincode:TextView=itemView.findViewById(R.id.txtLanguage4)

        val radioButton: RadioButton = itemView.findViewById(R.id.viewEllipseSix)
        val itemContainer: View = itemView.findViewById(R.id.container) // Replace with your container ID


        val customerName:TextView=itemView.findViewById(R.id.txtRahul)
        val phoneNumber:TextView=itemView.findViewById(R.id.txtPhone75859941)

        fun bindView(postModel: AddressResponse, position: Int) {
//            radioButton.isChecked = postModel.id == selectedAddressId
            locality.text = postModel.area
            flatno.text = postModel.houseNo
            city.text = postModel.city
            state.text = postModel.state
            pincode.text = postModel.pincode
            customerName.text=postModel.fullName
            phoneNumber.text=postModel.mobileNumber

            radioButton.isChecked = postModel.id == selectedAddressId

            // Set an OnClickListener on the itemContainer
            radioButton.setOnClickListener {
                    selectedAddressId = postModel.id!!

            }


            itemContainer.setOnClickListener {
                selectedAddressId=postModel.id!!
            }
//            radioButton.setOnClickListener {
//                    selectedAddressId = postModel.id!!
//
//            }


        }
    }


    // Create a method to get the selected position
    fun getSelectedPosition(): Int {
        return selectedAddressId
    }

}