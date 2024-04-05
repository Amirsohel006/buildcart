package com.buildcart.app.modules.product.`data`.model

import com.buildcart.app.R
import com.buildcart.app.appcomponents.di.MyApp
import kotlin.String

data class ProductModel(
  /**
   * TODO Replace with dynamic value
   */
  var txtProductdetails: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_product_details)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDesignTiles: String? = MyApp.getInstance().resources.getString(R.string.lbl_design_tiles)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPrice: String? = MyApp.getInstance().resources.getString(R.string.lbl_17_per_piece)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtQuantity: String? = MyApp.getInstance().resources.getString(R.string.lbl_quantity)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtGroup452: String? = MyApp.getInstance().resources.getString(R.string.lbl_00)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtPieces: String? = MyApp.getInstance().resources.getString(R.string.lbl_pieces)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtProductDescrip: String? =
      MyApp.getInstance().resources.getString(R.string.msg_product_descrip)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDescription: String? =
      MyApp.getInstance().resources.getString(R.string.msg_lorem_ipsum_dol)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtEnterPincodet: String? =
      MyApp.getInstance().resources.getString(R.string.msg_enter_pincode_t)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguage: String? = MyApp.getInstance().resources.getString(R.string.lbl_order_now)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtAddToCart: String? = MyApp.getInstance().resources.getString(R.string.lbl_add_to_cart)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtLanguageOne: String? = MyApp.getInstance().resources.getString(R.string.lbl_for_pincode)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtZipcode: String? = MyApp.getInstance().resources.getString(R.string.lbl_560068)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtStockAvailable: String? =
      MyApp.getInstance().resources.getString(R.string.lbl_stock_available)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtDeliveryWithin: String? =
      MyApp.getInstance().resources.getString(R.string.msg_delivery_within)
  ,
  /**
   * TODO Replace with dynamic value
   */
  var txtMoreProducts: String? = MyApp.getInstance().resources.getString(R.string.lbl_more_products)

)
