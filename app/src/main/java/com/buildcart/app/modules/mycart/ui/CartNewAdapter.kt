package com.buildcart.app.modules.mycart.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.MyCartItemBinding
import com.buildcart.app.modules.mycart.data.adapter.CartAdapter
import com.buildcart.app.modules.mycart.data.model.CartProduct
import com.buildcart.app.modules.mycart.data.model.CartProductItem
import com.buildcart.app.modules.mycart.data.viewmodel.MyCartVM
import com.buildcart.app.service.APIManager
import com.squareup.picasso.Picasso
import org.w3c.dom.Text
import retrofit2.Call
import retrofit2.Response

class CartNewAdapter (private val cartItems: List<CartProductItem>,
    private val sessionManager: SessionManager) :
    RecyclerView.Adapter<CartNewAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.row_added_to_cart,parent,false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        return holder.bind(cartItems[position])

    }

    override fun getItemCount(): Int {
        return cartItems.size
    }




    fun calculateTotalPrices(): Double {
        var totalPrices = 0.0

        for (cartItem in cartItems) {
            totalPrices += cartItem.totalPrice!!
        }

        return totalPrices
    }
    inner class CartViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        val imageView:ImageView=itemView.findViewById(R.id.imageUntitled1080)

        val linearLayout:LinearLayout=itemView.findViewById(R.id.linearRowuntitled1080)

        val productName:TextView=itemView.findViewById(R.id.txtCreamColour)


        val quantity:TextView=itemView.findViewById(R.id.txtGroup434)


        val amount:TextView=itemView.findViewById(R.id.txtPrice)

        val removeIcon:ImageView=itemView.findViewById(R.id.image)
        fun bind(cartItem: CartProductItem) {


            productName.text=cartItem.productName

            quantity.text=cartItem.quantity.toString()

            amount.text=cartItem.totalPrice.toString()





            removeIcon.setOnClickListener {
                deleteFromCart(cartItem.id.toString())
            }

//            val file=cartItem.productImages[2].img2
//            val imgUrl= file.let { APIManager.getImageUrl(it!!) }
//
//            Picasso.get()
//                .load(imgUrl)
//                .fit()
//                .into(imageView)


            if (cartItem.productImages.isNotEmpty()) {
                val firstImage = cartItem.productImages[0]
                val imageUrl = firstImage.img1 ?: firstImage.img2 // Try to get img1, fallback to img2 if img1 is null

                if (imageUrl != null) {
                    val file = APIManager.getImageUrl(imageUrl)
                    Log.d("All Images Retrieved From Anything ",file)
                    Picasso.get().load(file).into(imageView)
                } else {
                    // Set a placeholder image if both img1 and img2 are null
                    imageView.setImageResource(R.drawable.placeholder_solid_color)
                }
            } else {
                // Set a placeholder image if the productImages list is empty
                imageView.setImageResource(R.drawable.placeholder_solid_color)
            }


//            val file=APIManager.getImageUrl(cartItem.productImages[0].img1!!)
//
//            Picasso.get().load(file).into(imageView)
        }



        fun deleteFromCart(id: String) {
            // Get the selected position from the adapter


            // Use the selected position to send the request
            val serviceGenerator = APIManager.apiInterface
            val accestoken = sessionManager.fetchAuthToken()
            val authorization = "Bearer $accestoken"


            val call = serviceGenerator.deleteFromCart(authorization,id)

            call.enqueue(object : retrofit2.Callback<CartProduct> {
                override fun onResponse(
                    call: Call<CartProduct>,
                    response: Response<CartProduct>
                ) {
                    if (response.isSuccessful) {
                        // Handle the response
                        // Toast.makeText(requireContext(), "Your Order Is Confirmed...Ready To Ship", Toast.LENGTH_SHORT).show()
                        linearLayout.visibility=View.GONE

                    }
                }

                override fun onFailure(call: Call<CartProduct>, t: Throwable) {
                    t.printStackTrace()
                    Log.e("Error In Deleting", t.message.toString())
                }
            })
        }


    }

}
