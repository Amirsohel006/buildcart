package com.buildcart.app.modules.ordersnine.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityOrdersNineBinding
import com.buildcart.app.modules.ordersnine.`data`.viewmodel.OrdersNineVM
import com.buildcart.app.modules.signuonineteen.ui.SignUoNineteenActivity
import kotlin.String
import kotlin.Unit

class OrdersNineActivity : BaseActivity<ActivityOrdersNineBinding>(R.layout.activity_orders_nine) {
  private val viewModel: OrdersNineVM by viewModels<OrdersNineVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.ordersNineVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnAdd.setOnClickListener {
      val destIntent = SignUoNineteenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ORDERS_NINE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OrdersNineActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
