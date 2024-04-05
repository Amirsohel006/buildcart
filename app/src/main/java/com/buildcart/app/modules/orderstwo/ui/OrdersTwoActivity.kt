package com.buildcart.app.modules.orderstwo.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityOrdersTwoBinding
import com.buildcart.app.modules.orderstwo.`data`.viewmodel.OrdersTwoVM
import kotlin.String
import kotlin.Unit

class OrdersTwoActivity : BaseActivity<ActivityOrdersTwoBinding>(R.layout.activity_orders_two) {
  private val viewModel: OrdersTwoVM by viewModels<OrdersTwoVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.ordersTwoVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "ORDERS_TWO_ACTIVITY"

  }
}
