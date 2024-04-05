package com.buildcart.app.modules.product.`data`.viewmodel

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.buildcart.app.modules.product.`data`.model.Listrectangle105FourRowModel
import com.buildcart.app.modules.product.`data`.model.Listrectangle105OneRowModel
import com.buildcart.app.modules.product.`data`.model.ProductModel
import com.buildcart.app.modules.product.`data`.model.SpinnerGroupThirtyTwoModel
import kotlin.collections.MutableList
import org.koin.core.KoinComponent

class ProductVM : ViewModel(), KoinComponent {
  val productModel: MutableLiveData<ProductModel> = MutableLiveData(ProductModel())

  var navArguments: Bundle? = null

  val spinnerGroupThirtyTwoList: MutableLiveData<MutableList<SpinnerGroupThirtyTwoModel>> =
      MutableLiveData()

  val listrectangle105OneList: MutableLiveData<MutableList<Listrectangle105OneRowModel>> =
      MutableLiveData(mutableListOf())

  val listrectangle105FourList: MutableLiveData<MutableList<Listrectangle105FourRowModel>> =
      MutableLiveData(mutableListOf())
}
