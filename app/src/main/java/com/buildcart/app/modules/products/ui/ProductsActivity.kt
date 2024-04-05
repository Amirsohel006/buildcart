package com.buildcart.app.modules.products.ui

import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityProductsBinding
import com.buildcart.app.modules.product.ui.ProductActivity
import com.buildcart.app.modules.products.`data`.model.ProductsRowModel
import com.buildcart.app.modules.products.`data`.viewmodel.ProductsVM
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Unit

class ProductsActivity : BaseActivity<ActivityProductsBinding>(R.layout.activity_products) {
  private val viewModel: ProductsVM by viewModels<ProductsVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    val productsAdapter = ProductsAdapter(viewModel.productsList.value?:mutableListOf())
    binding.recyclerProducts.adapter = productsAdapter
    productsAdapter.setOnItemClickListener(
    object : ProductsAdapter.OnItemClickListener {
      override fun onItemClick(view:View, position:Int, item : ProductsRowModel) {
        onClickRecyclerProducts(view, position, item)
      }
    }
    )
    viewModel.productsList.observe(this) {
      productsAdapter.updateData(it)
    }
    binding.productsVM = viewModel
    setUpSearchViewGroup552Listener()
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  fun onClickRecyclerProducts(
    view: View,
    position: Int,
    item: ProductsRowModel
  ): Unit {
    when(view.id) {
      R.id.linearColumnrectangle105 ->  {
        onClickRecyclerProductsLinearColumnrectangle105(view, position, item)
      }
      R.id.txtDesignTiles ->  {
        onClickRecyclerProductsTxtDesignTiles(view, position, item)
      }
      R.id.imageRectangle105 ->  {
        onClickRecyclerProductsImageRectangle105(view, position, item)
      }
    }
  }

  private fun setUpSearchViewGroup552Listener(): Unit {
    binding.searchViewGroup552.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
      override fun onQueryTextSubmit(p0 : String) : Boolean {
        // Performs search when user hit
        // the search button on the keyboard
        return false
      }
      override fun onQueryTextChange(p0 : String) : Boolean {
        // Start filtering the list as user
        // start entering the characters
        return false
      }
      })
    }

    fun onClickRecyclerProductsLinearColumnrectangle105(
      view: View,
      position: Int,
      item: ProductsRowModel
    ) {
      /** TODO As per your logic, Add constant type for item click.*/
      when(0) {
        0 ->  {
          val destIntent = ProductActivity.getIntent(this, null)
          startActivity(destIntent)
        }
        1 ->  {
          val destIntent = ProductActivity.getIntent(this, null)
          startActivity(destIntent)
        }
      }
    }

    fun onClickRecyclerProductsTxtDesignTiles(
      view: View,
      position: Int,
      item: ProductsRowModel
    ) {
      /** TODO As per your logic, Add constant type for item click.*/
      when(0) {
        0 ->  {
          val destIntent = ProductActivity.getIntent(this, null)
          startActivity(destIntent)
        }
        1 ->  {
          val destIntent = ProductActivity.getIntent(this, null)
          startActivity(destIntent)
        }
      }
    }

    fun onClickRecyclerProductsImageRectangle105(
      view: View,
      position: Int,
      item: ProductsRowModel
    ) {
      /** TODO As per your logic, Add constant type for item click.*/
      when(0) {
        0 ->  {
          val destIntent = ProductActivity.getIntent(this, null)
          startActivity(destIntent)
        }
        1 ->  {
          val destIntent = ProductActivity.getIntent(this, null)
          startActivity(destIntent)
        }
      }
    }

    companion object {
      const val TAG: String = "PRODUCTS_ACTIVITY"

    }
  }
