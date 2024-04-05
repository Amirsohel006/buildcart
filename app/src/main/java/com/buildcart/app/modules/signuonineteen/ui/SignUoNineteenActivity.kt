package com.buildcart.app.modules.signuonineteen.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoNineteenBinding
import com.buildcart.app.modules.ordersnine.ui.OrdersNineActivity
import com.buildcart.app.modules.signuonineteen.`data`.viewmodel.SignUoNineteenVM
import kotlin.String
import kotlin.Unit

class SignUoNineteenActivity :
    BaseActivity<ActivitySignUoNineteenBinding>(R.layout.activity_sign_uo_nineteen) {
  private val viewModel: SignUoNineteenVM by viewModels<SignUoNineteenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoNineteenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearRowfloatingicon.setOnClickListener {
      val destIntent = OrdersNineActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_NINETEEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoNineteenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
