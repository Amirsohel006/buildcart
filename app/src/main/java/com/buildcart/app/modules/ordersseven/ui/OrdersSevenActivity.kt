package com.buildcart.app.modules.ordersseven.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityOrdersSevenBinding
import com.buildcart.app.modules.ordersseven.`data`.viewmodel.OrdersSevenVM
import kotlin.String
import kotlin.Unit

class OrdersSevenActivity : BaseActivity<ActivityOrdersSevenBinding>(R.layout.activity_orders_seven)
    {
  private val viewModel: OrdersSevenVM by viewModels<OrdersSevenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.ordersSevenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "ORDERS_SEVEN_ACTIVITY"

  }
}
