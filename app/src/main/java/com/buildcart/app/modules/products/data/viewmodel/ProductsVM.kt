package com.buildcart.app.modules.products.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.products.`data`.model.ProductsModel
import com.buildcart.app.modules.products.`data`.model.ProductsRowModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ProductsVM : ViewModel(), KoinComponent {
  val productsModel: MutableLiveData<ProductsModel> = MutableLiveData(ProductsModel())

  var navArguments: Bundle? = null

  val productsList: MutableLiveData<MutableList<ProductsRowModel>> =
      MutableLiveData(mutableListOf())
}
