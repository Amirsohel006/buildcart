package com.buildcart.app.modules.orders.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.modules.responses.CancelledResponse
import com.buildcart.app.modules.responses.CompleteResponse
import com.buildcart.app.service.APIManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class CancelledOrderAdapter(
    var list: List<CancelledResponse>
) : RecyclerView.Adapter<CancelledOrderAdapter.RowCompleteOrderVH>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CancelledOrderAdapter.RowCompleteOrderVH {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.row_order_cancelled, parent, false)
        return RowCompleteOrderVH(view)
    }

    override fun onBindViewHolder(holder: RowCompleteOrderVH, position: Int) {
        return holder.bindView(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }



    inner class RowCompleteOrderVH(
        view: View
    ) : RecyclerView.ViewHolder(view) {


        val productname: TextView =itemView.findViewById(R.id.txtCreamColour)

        val price: TextView =itemView.findViewById(R.id.txtPrice)

        val image: ImageView =itemView.findViewById(R.id.imageUntitled1080)

        // Define the corner radius in pixels (converted from dp)
        val cornerRadiusInPixels = 15 // Change to your dimension resource

        // Create a RequestOptions object with the RoundedCorners transformation
        val requestOptions = RequestOptions()
            .transform(RoundedCorners(cornerRadiusInPixels))

        @SuppressLint("SuspiciousIndentation")
        fun bindView(postModel: CancelledResponse) {


            //val file= APIManager.getImageUrl(postModel.product!!.productGalleries[0].image!!)


            productname.text=postModel.product!!.name

            price.text=postModel.quantity.toString()

//            Glide.with(itemView)
//                .load(file) // Replace with your image URL or resource ID
//                .apply(requestOptions)
//                .into(image)



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