package com.buildcart.app.modules.orders.ui

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseFragment
import com.buildcart.app.databinding.FragmentOrdersBinding
import com.buildcart.app.modules.frame311.ui.Frame311Activity
import com.buildcart.app.modules.orders.`data`.viewmodel.OrdersVM
import com.google.android.material.tabs.TabLayoutMediator
import kotlin.String
import kotlin.Unit

class OrdersFragment : BaseFragment<FragmentOrdersBinding>(R.layout.fragment_orders) {
  private val viewModel: OrdersVM by viewModels<OrdersVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = arguments
    binding.ordersVM = viewModel

    // Initialize ViewPager2 and TabLayout
    val adapter = OrdersFragmentPagerAdapter(childFragmentManager, lifecycle)
    binding.viewPagerViewpager.adapter = adapter

    // Attach TabLayout to ViewPager2
    TabLayoutMediator(binding.tabLayout, binding.viewPagerViewpager) { tab, position ->
      tab.text = OrdersFragmentPagerAdapter.title[position]
    }.attach()
  }

  override fun setUpClicks(): Unit {
    // Handle clicks if needed

    binding.imageVector.setOnClickListener {
      // Open Frame311Activity -MenuDrawer Activity when ImageVector is clicked
      val intent = Intent(activity, Frame311Activity::class.java)
      startActivity(intent)
    }
  }

  companion object {
    const val TAG: String = "ORDERS_FRAGMENT"

    fun getInstance(bundle: Bundle?): OrdersFragment {
      val fragment = OrdersFragment()
      fragment.arguments = bundle
      return fragment
    }
  }
}
