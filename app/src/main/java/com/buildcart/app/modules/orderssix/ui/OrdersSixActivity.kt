package com.buildcart.app.modules.orderssix.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityOrdersSixBinding
import com.buildcart.app.modules.orderssix.`data`.viewmodel.OrdersSixVM
import com.buildcart.app.modules.signuotwentyone.ui.SignUoTwentyoneActivity
import kotlin.String
import kotlin.Unit

class OrdersSixActivity : BaseActivity<ActivityOrdersSixBinding>(R.layout.activity_orders_six) {
  private val viewModel: OrdersSixVM by viewModels<OrdersSixVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.ordersSixVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.btnAdd.setOnClickListener {
      val destIntent = SignUoTwentyoneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "ORDERS_SIX_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, OrdersSixActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
