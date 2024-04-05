package com.buildcart.app.modules.mycart.data.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.data.ProductGalleryItem
import com.buildcart.app.databinding.MyCartItemBinding
import com.buildcart.app.modules.homeone.adapter.CategoryAdapter

import com.buildcart.app.modules.mycart.data.model.CartProductItem
import com.buildcart.app.modules.mycart.data.viewmodel.MyCartVM
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class CartAdapter(private val cartItems: List<CartProductItem>,private val viewModel:MyCartVM) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MyCartItemBinding.inflate(inflater, parent, false)
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(cartItems[position], viewModel)

    }

    override fun getItemCount(): Int = cartItems.size

    inner class CartViewHolder(private val binding: MyCartItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cartItem: CartProductItem, viewModel: MyCartVM) {
            binding.cartItem = cartItem
            binding.myCartVM = viewModel

        //    loadProductImages(binding.imgProduct, cartItem.productImages[0].image)
            // Load image using your preferred image loading library into an ImageView in your layout
            // For example: Glide.with(binding.root.context).load(cartItem.imageUrl).into(binding.imgProduct)

            binding.executePendingBindings()

        }

        private fun loadProductImages(imageView: ImageView, productImages: List<String>) {
            imageView.setImageDrawable(null)

            val imageUrl = viewModel.getFullImageUrl(productImages)
            Log.d("image_url_from_backend", productImages.toString())
            Log.d("image_url_after_fetch", imageUrl)

            // Use Picasso to load the image into the ImageView
            Picasso.get()
                .load(imageUrl)
                .fit()
                .into(imageView)
        }
    }

}
