package com.buildcart.app.modules.orders.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.modules.responses.Response
import com.buildcart.app.service.APIManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import org.w3c.dom.Text

class ActiveOrderAdapter (
    var list: List<Response>
) : RecyclerView.Adapter<ActiveOrderAdapter.RowStudioBookongVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowStudioBookongVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_pending_data, parent, false)
        return RowStudioBookongVH(view)
    }

    override fun onBindViewHolder(holder: RowStudioBookongVH, position: Int) {
        return holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }






    inner class RowStudioBookongVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {
        //   val binding: RowStudioBookongBinding = RowStudioBookongBinding.bind(itemView)

       val productname:TextView=itemView.findViewById(R.id.txtDesignTiles)

        val price:TextView=itemView.findViewById(R.id.txtPrice)

        val image:ImageView=itemView.findViewById(R.id.imageUntitled1080)

        // Define the corner radius in pixels (converted from dp)
        val cornerRadiusInPixels = 15 // Change to your dimension resource

        // Create a RequestOptions object with the RoundedCorners transformation
        val requestOptions = RequestOptions()
            .transform(RoundedCorners(cornerRadiusInPixels))

        @SuppressLint("SuspiciousIndentation")
        fun bindView(postModel: Response) {


            val imageUrl = if (postModel.product?.productGalleries?.isNotEmpty() == true && !postModel.product!!.productGalleries[0].image.isNullOrEmpty()) {
                APIManager.getImageUrl(postModel.product!!.productGalleries[0].image!!)
            } else {
                // URL or resource ID of the placeholder or empty image
                "URL_OF_EMPTY_IMAGE" // Replace with actual URL or resource ID
            }

// Load the image using Glide




            productname.text=postModel.product!!.name

            price.text=postModel.quantity.toString()

                Glide.with(itemView)
                    .load(imageUrl) // Replace with your image URL or resource ID
                    .apply(requestOptions)
                    .into(image)



            // requestid=postModel.id


//            requestButton.setOnClickListener {
//                val context = itemView.context
//                val intent = Intent(context, Frame316Activity::class.java)
//                intent.putExtra("requestId", requestid) // Pass the id to the new activity
//                context.startActivity(intent)
//            }

        }
    }
}

