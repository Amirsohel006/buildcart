package com.buildcart.app.modules

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.data.ProductGalleryItem
import com.buildcart.app.data.ProductResponseItem
import com.buildcart.app.data.SessionManager
import com.buildcart.app.data.response.FavrioteResponse
import com.buildcart.app.databinding.RowHomeOneBinding
import com.buildcart.app.modules.homeone.adapter.HomeOneAdapter
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModel
import com.buildcart.app.modules.product.ui.ProductActivity
import com.buildcart.app.service.APIManager
import com.bumptech.glide.Glide
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeAdapterForProductActivity(
    private val dataList: MutableList<ProductResponseItem>,
    private val viewModel: HomeOneViewModel,
    private val sessionManager: SessionManager,
    private val sharedPreferences: SharedPreferences,
    private val context: Context
) : RecyclerView.Adapter<HomeAdapterForProductActivity.HomeOneViewHolder>() {
    private var itemClickListener: OnItemClickListener? = null
    //private var addToCartButtonText: String = "Add to Cart" // Default value

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.itemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeOneViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowHomeOneBinding.inflate(layoutInflater, parent, false)
        return HomeOneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeOneViewHolder, position: Int) {
        holder.bind(dataList[position],position)
        // holder.binding.btnAddToCart.text = addToCartButtonText

        val buttonText = if (dataList[position].isAddedToCart) {
            "Go to Cart"
        } else {
            "Add to Cart"
        }
        holder.binding.btnAddToCart.text = buttonText

//        holder.binding.imageVectorTwo.setOnClickListener {
//            addEventToFavorites(holder.binding.imageVectorTwo,holder.itemView.context,dataList[position].product_id.toString())
//        }

        val isFavorite = sharedPreferences.getBoolean(dataList[position].product_id.toString(), false)
        holder.binding.imageVectorTwo.setImageResource(if (isFavorite) R.drawable.image_favriote_red else R.drawable.img_clock)
        holder.binding.imageVectorTwo.setOnClickListener {
            toggleFavorite(holder.binding.imageVectorTwo, holder.itemView.context, dataList[position].product_id.toString(), isFavorite)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class HomeOneViewHolder(val binding: RowHomeOneBinding) :
        RecyclerView.ViewHolder(binding.root) {



        init {
            binding.imgPlus.setOnClickListener {
                handleIncreaseClick(adapterPosition)
            }

            binding.imgMinus.setOnClickListener {
                handleDecreaseClick(adapterPosition)
            }

//            binding.btnAddToCart.setOnClickListener {
//                handleAddToCartClick(adapterPosition)
//            }

            binding.root.setOnClickListener {
                handleItemClick(adapterPosition)
            }
        }

        @SuppressLint("SuspiciousIndentation")
        fun bind(item: ProductResponseItem, position: Int) {
            binding.productResponse = item
            binding.viewModel = viewModel

            binding.executePendingBindings()
            binding.txtQuantity.text = item.initialQuantity.toString()
            val quantity=item.initialQuantity.toInt()

            binding.txtRating.text = viewModel.getFormattedRating(item)
            loadProductImages(binding.imageRectangle105, item.product_galleries)

            binding.btnAddToCart.setOnClickListener {
                if (quantity==0) {
                    Toast.makeText(
                        itemView.context,
                        "Please select at least 1 quantity",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else {
                    handleAddToCartClick(position)
                }
            }

        }

        private fun loadProductImages(imageView: ImageView, productGalleries: List<ProductGalleryItem>) {
            // Clear previous images
            imageView.setImageDrawable(null)

            // Load all product images into the ImageView using Glide or your preferred image loading library
            for (galleryItem in productGalleries) {
                Glide.with(imageView.context)
                    .load(viewModel.getFullImageUrl(listOf(galleryItem)))
                    .into(imageView)
            }
        }



        private fun handleIncreaseClick(position: Int) {
            val currentItem = dataList[position]
            currentItem.initialQuantity++
            binding.txtQuantity.text = currentItem.initialQuantity.toString()
            Log.d("Adapter", "Increased quantity to ${currentItem.initialQuantity}")
            itemClickListener?.onIncreaseClick(binding.root, position, currentItem)
        }

        private fun handleDecreaseClick(position: Int) {
            val currentItem = dataList[position]
            if (currentItem.initialQuantity > 0) {
                currentItem.initialQuantity--
                binding.txtQuantity.text = currentItem.initialQuantity.toString()
                Log.d("Adapter", "Decrease quantity to ${currentItem.initialQuantity}")
                itemClickListener?.onDecreaseClick(binding.root, position, currentItem)
            }
        }

        private fun handleAddToCartClick(position: Int) {
            val currentItem = dataList[position]
            viewModel.setSelectedProduct(currentItem)
            // viewModel.onAddToCartClick(currentItem, position)
            // Check if the item is already added to the cart
            if (!currentItem.isAddedToCart) {
                // If not added, trigger the API call to add the product to the cart
                itemClickListener?.onAddToCartClick(binding.root, position, currentItem)
                currentItem.isAddedToCart = true

                currentItem.addToCartButtonText = "Adding To Cart"
                notifyItemChanged(position)
                // Simulate the API call delay with a Handler
                Handler().postDelayed({
                    currentItem.addToCartButtonText = "Go to Cart"
                    notifyItemChanged(position)
                }, 1500)

//                currentItem.addToCartButtonText = "Go to Cart"
//                notifyItemChanged(position)
            } else {
                // If already added, handle the "Go to Cart" action
                itemClickListener?.onGoToCartClick(binding.root, position, currentItem)
            }
        }

        private fun handleItemClick(position: Int) {
            itemClickListener?.onItemClick(binding.root, position, dataList[position])

            // Open ProductDetailsActivity when the item is clicked
            val intent = Intent(binding.root.context, ProductActivity::class.java)
            intent.putExtra("productId", dataList[position].product_id)
            binding.root.context.startActivity(intent)
        }
//        private fun handleItemClick(position: Int) {
//            itemClickListener?.onItemClick(binding.root, position, dataList[position])
//        }
    }

    var eventId :String=""


    private var isFavorite: Boolean
        get() = sharedPreferences.getBoolean(eventId.toString(), false)
        set(value) = sharedPreferences.edit().putBoolean(eventId.toString(), value).apply()
    interface OnItemClickListener {
        fun onIncreaseClick(view: View, position: Int, item: ProductResponseItem)
        fun onDecreaseClick(view: View, position: Int, item: ProductResponseItem)
        fun onAddToCartClick(view: View, position: Int, item: ProductResponseItem)
        fun onGoToCartClick(view: View, position: Int, item: ProductResponseItem)
        fun onItemClick(view: View, position: Int, item: ProductResponseItem)
    }



    private fun toggleFavorite(favoriteIcon: ImageView, context: Context, eventId: String, isFavorite: Boolean) {
        val token = sessionManager.fetchAuthToken()
        val accessToken = "Bearer $token"
        val requestBody = AddToFavriote(product_id = eventId)
        val service = APIManager.apiInterface

        val call: Call<FavrioteResponse> = if (isFavorite) {
            service.addToFavourite(accessToken, requestBody)
        } else {
            service.removeFromFavourute(accessToken, requestBody)
        }

        call.enqueue(object : Callback<FavrioteResponse> {
            override fun onResponse(call: Call<FavrioteResponse>, response: Response<FavrioteResponse>) {
                if (response.isSuccessful) {
                    val favResponse = response.body()
                    if (favResponse?.success == "true") {
                        val newFavoriteState = !isFavorite
                        sharedPreferences.edit().putBoolean(eventId, newFavoriteState).apply()
                        updateFavoriteIcon(favoriteIcon, newFavoriteState)
                    } else {
                        Toast.makeText(context, "Failed to update favorites", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(context, "Failed to update favorites", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<FavrioteResponse>, t: Throwable) {
                Toast.makeText(context, "Failed to update favorites", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun updateFavoriteIcon(favoriteIcon: ImageView, isFavorite: Boolean) {
        favoriteIcon.setImageResource(if (isFavorite) R.drawable.image_favriote_red else R.drawable.img_clock)
    }

    // Update the function to use the correct data type
    fun updateData(newData: List<ProductResponseItem>) {
        dataList.clear()
        dataList.addAll(newData)
        notifyDataSetChanged()
    }

    fun setAddToCartButtonText(position: Int, buttonText: String) {
        if (position in 0 until dataList.size) {
            dataList[position].addToCartButtonText = buttonText
            // Ensure this method is called on the UI thread
            Handler(Looper.getMainLooper()).post {
                notifyItemChanged(position)
                Log.d("HomeOneAdapter", "Button text set for position $position: $buttonText")
            }
        }
    }
}