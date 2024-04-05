package com.buildcart.app.modules.ordersten.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityOrdersTenBinding
import com.buildcart.app.modules.ordersten.`data`.viewmodel.OrdersTenVM
import kotlin.String
import kotlin.Unit

class OrdersTenActivity : BaseActivity<ActivityOrdersTenBinding>(R.layout.activity_orders_ten) {
  private val viewModel: OrdersTenVM by viewModels<OrdersTenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.ordersTenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "ORDERS_TEN_ACTIVITY"

  }
}
