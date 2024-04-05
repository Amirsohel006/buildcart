package com.buildcart.app.modules.ordersone.ui

import androidx.fragment.app.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseFragment
import com.buildcart.app.databinding.FragmentOrdersOneBinding
import com.buildcart.app.modules.ordersone.`data`.viewmodel.OrdersOneVM
import kotlin.String
import kotlin.Unit

class OrdersOneFragment : BaseFragment<FragmentOrdersOneBinding>(R.layout.fragment_orders_one) {
  private val viewModel: OrdersOneVM by viewModels<OrdersOneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.ordersOneVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "ORDERS_ONE_FRAGMENT"

  }
}
