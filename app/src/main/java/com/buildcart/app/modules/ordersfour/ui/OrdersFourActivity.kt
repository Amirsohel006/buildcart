package com.buildcart.app.modules.ordersfour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityOrdersFourBinding
import com.buildcart.app.modules.ordersfour.`data`.viewmodel.OrdersFourVM
import com.buildcart.app.modules.signuonine.ui.SignUoNineActivity
import kotlin.String
import kotlin.Unit

class OrdersFourActivity : BaseActivity<ActivityOrdersFourBinding>(R.layout.activity_orders_four) {
  private val viewModel: OrdersFourVM by viewModels<OrdersFourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.ordersFourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnAdd.setOnClickListener {
      val destIntent = SignUoNineActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }


  companion object {
    const val TAG: String = "ORDERS_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OrdersFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
