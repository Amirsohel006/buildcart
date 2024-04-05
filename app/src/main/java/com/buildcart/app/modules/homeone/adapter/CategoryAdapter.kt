package com.buildcart.app.modules.homeone.adapter

import android.graphics.Bitmap
import android.graphics.BitmapShader
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Shader
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.data.response.CategoriesResponse
import com.buildcart.app.databinding.RowCategoryItemBinding
import com.buildcart.app.modules.homeone.data.model.CategoryItem
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModel
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

class CategoryAdapter(
    private val categoryList: List<CategoriesResponse>,
    private val viewModel: HomeOneViewModel, private val itemClickListener: OnCategoryItemClickListener
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    interface OnCategoryItemClickListener {
        fun onCategoryItemClick(categoryItem: CategoriesResponse)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RowCategoryItemBinding = RowCategoryItemBinding.inflate(
            inflater,
            parent,
            false
        )
        return ViewHolder(binding,itemClickListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryItem = categoryList[position]
        holder.bind(categoryItem, viewModel)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    class ViewHolder(val binding: RowCategoryItemBinding, private val itemClickListener: OnCategoryItemClickListener) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(categoryItem: CategoriesResponse, viewModel: HomeOneViewModel) {
            binding.categoryItem=categoryItem
            binding.viewModel=viewModel
            Log.d("CategoryAdapter", "Category Id: ${categoryItem.id}")
            Log.d("CategoryAdapter", "Category Name: ${categoryItem.name}")
            Log.d("CategoryAdapter", "Category Image: ${categoryItem.image}")
            // Load image using Picasso with the full image URL
            Picasso.get()
                .load(viewModel.getCategoriesImageUrl(categoryItem))
                .placeholder(R.drawable.circular_background).transform(CircleTransformation())
                .into(binding.imageCategory)



            // Set other data to views if needed
           // binding.txtCategoryName.text = categoryItem.name

            binding.root.setOnClickListener {
                // Handle item click and pass the selected category
                itemClickListener.onCategoryItemClick(categoryItem)
            }


            binding.executePendingBindings()
        }
    }

    // Picasso's built-in CircleTransformation
    class CircleTransformation : Transformation {
        override fun key(): String {
            return "circleTransformation"
        }

        override fun transform(source: Bitmap): Bitmap {
            val size = Math.min(source.width, source.height)
            val x = (source.width - size) / 2
            val y = (source.height - size) / 2

            val squaredBitmap = Bitmap.createBitmap(source, x, y, size, size)
            if (squaredBitmap != source) {
                source.recycle()
            }

            val bitmap = Bitmap.createBitmap(size, size, source.config)
            val canvas = Canvas(bitmap)
            val paint = Paint()
            paint.shader = BitmapShader(squaredBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
            paint.isAntiAlias = true

            val radius = size / 2f
            canvas.drawCircle(radius, radius, radius, paint)

            squaredBitmap.recycle()
            return bitmap
        }
    }



}

