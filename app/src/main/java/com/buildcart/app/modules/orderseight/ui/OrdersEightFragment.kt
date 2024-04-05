package com.buildcart.app.modules.orderseight.ui

import androidx.fragment.app.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseFragment
import com.buildcart.app.databinding.FragmentOrdersEightBinding
import com.buildcart.app.modules.orderseight.`data`.viewmodel.OrdersEightVM
import kotlin.String
import kotlin.Unit

class OrdersEightFragment : BaseFragment<FragmentOrdersEightBinding>(R.layout.fragment_orders_eight)
    {
  private val viewModel: OrdersEightVM by viewModels<OrdersEightVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.ordersEightVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ORDERS_EIGHT_FRAGMENT"

  }
}
