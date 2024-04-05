package com.buildcart.app.modules.orders1.ui

import androidx.fragment.app.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseFragment
import com.buildcart.app.databinding.FragmentOrders1Binding
import com.buildcart.app.modules.orders1.`data`.viewmodel.Orders1VM
import com.buildcart.app.modules.ordersfive.ui.OrdersFiveActivity
import kotlin.String
import kotlin.Unit

class Orders1Fragment : BaseFragment<FragmentOrders1Binding>(R.layout.fragment_orders1) {
  private val viewModel: Orders1VM by viewModels<Orders1VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.orders1VM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnTrackOrder.setOnClickListener {
      val destIntent = OrdersFiveActivity.getIntent(requireActivity(), null)
      startActivity(destIntent)
      requireActivity().onBackPressed()
    }
  }

  companion object {
    const val TAG: String = "ORDERS1FRAGMENT"

  }
}
