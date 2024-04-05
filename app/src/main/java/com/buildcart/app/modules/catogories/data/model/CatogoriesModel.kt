package com.buildcart.app.modules.catogories.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class CatogoriesModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCategories: String? = MyApp.getInstance().resources.getString(R.string.lbl_categories)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtCategoriesOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_categories)

)
