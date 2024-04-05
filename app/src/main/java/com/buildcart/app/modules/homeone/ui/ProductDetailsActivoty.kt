package com.buildcart.app.modules.homeone.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.buildcart.app.R // Replace with your actual project's R class
import com.buildcart.app.data.SessionManager
import com.buildcart.app.databinding.ActivityProductDetailsBinding
import com.buildcart.app.modules.homeone.data.ProductsRepository
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModel
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModelFactory
import com.buildcart.app.modules.homeone.data.viewmodel.ProductDetailsViewModel
import com.buildcart.app.modules.homeone.data.viewmodel.ProductDetailsViewModelFactory
import com.buildcart.app.service.APIManager
import com.bumptech.glide.Glide
import com.squareup.picasso.Picasso

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
//    private val viewModel: ProductDetailsViewModel by viewModels()

    private val productsRepository = ProductsRepository(APIManager.apiInterface)
val viewModel: ProductDetailsViewModel by viewModels {
    ProductDetailsViewModelFactory(productsRepository)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_details)
        binding.productDetailsViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.setSessionManager(SessionManager(this))

        val productId = intent.getStringExtra("productId")
        if (productId != null) {
            viewModel.fetchProductDetails(productId)
        }


        viewModel.productDetails.observe(this, Observer { productDetails ->
            // No need to manually update UI, data binding will handle it
            // You can still perform additional UI updates or logic if needed

            val imgProduct = binding.imgProduct

            // Use Picasso to load the image into the ImageView
            Picasso.get()
                .load(productDetails.productGalleries[0].image)
                .fit()
                .centerCrop()
                .into(imgProduct)

        })


        // Handle error LiveData if needed
        // viewModel.error.observe(this, Observer { errorMessage ->
        //    // Handle error
        // })
    }

}
