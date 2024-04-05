package com.buildcart.app.modules.home.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class HomeModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtHiRahul: String? = MyApp.getInstance().resources.getString(R.string.lbl_hi_rahul)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategories: String? = MyApp.getInstance().resources.getString(R.string.lbl_categories)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategoryOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_category1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategoryTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_category2)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategoryOneOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_category1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategoryOneTwo: String? = MyApp.getInstance().resources.getString(R.string.lbl_category1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategoryOneThree: String? = MyApp.getInstance().resources.getString(R.string.lbl_category1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategoryOneFour: String? = MyApp.getInstance().resources.getString(R.string.lbl_category1)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtProducts: String? = MyApp.getInstance().resources.getString(R.string.lbl_products)

)
