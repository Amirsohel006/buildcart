package com.buildcart.app.modules.homeone.ui



import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.buildcart.app.R
import com.buildcart.app.data.SessionManager
import com.buildcart.app.modules.homeone.adapter.CategoryAdapter
import com.buildcart.app.modules.homeone.adapter.HomeOneAdapter
import com.buildcart.app.modules.homeone.data.CategoriesRepository
import com.buildcart.app.modules.homeone.data.ProductsRepository
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModel
import com.buildcart.app.modules.homeone.data.viewmodel.HomeOneViewModelFactory
import com.buildcart.app.service.APIManager

class AllProductsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewCategories: RecyclerView
    private lateinit var homeOneAdapter: HomeOneAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    //private lateinit var viewModel: HomeOneViewModel
    private lateinit var sessionManager: SessionManager

    private val productsRepository = ProductsRepository(APIManager.apiInterface)
    private val categoriesRepository= CategoriesRepository(APIManager.apiInterface)
    val viewModelHome: HomeOneViewModel by viewModels {
        HomeOneViewModelFactory(productsRepository, categoriesRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_products)


        sessionManager= SessionManager(this)
        viewModelHome.setSessionManager(sessionManager)
// Get categoryId from the Intent
        val categoryId = intent.getStringExtra("categoryId")


        // Call the fetchProductList method to get the data
        viewModelHome.fetchProductList()

        // Call the fetchProductList method with the categoryId to get the data for the specific category
        viewModelHome.fetchProductByCategoryId(categoryId.toString())

        recyclerView = findViewById(R.id.recyclerViewAllProducts)
        homeOneAdapter = HomeOneAdapter(mutableListOf(), viewModelHome)

        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = homeOneAdapter


        viewModelHome.getProductList().observe(this){
            productList->
            homeOneAdapter.updateData(productList)
        }

        // Observe changes in the LiveData (productList)
        viewModelHome.getProductByCategories().observe(this) { productList ->
            // Update the adapter with the new data
            homeOneAdapter.updateData(productList)
        }


        window.statusBarColor= ContextCompat.getColor(this,R.color.gray_703)
    }



}



