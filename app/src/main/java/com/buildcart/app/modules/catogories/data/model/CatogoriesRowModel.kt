package com.buildcart.app.modules.catogories.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class CatogoriesRowModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtCategoryOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_category1)

)
