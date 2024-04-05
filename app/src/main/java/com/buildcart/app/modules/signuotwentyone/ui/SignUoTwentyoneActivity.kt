package com.buildcart.app.modules.signuotwentyone.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoTwentyoneBinding
import com.buildcart.app.modules.orderssix.ui.OrdersSixActivity
import com.buildcart.app.modules.signuotwentyone.`data`.viewmodel.SignUoTwentyoneVM
import com.buildcart.app.modules.signuotwentytwo.ui.SignUoTwentytwoActivity
import kotlin.String
import kotlin.Unit

class SignUoTwentyoneActivity :
    BaseActivity<ActivitySignUoTwentyoneBinding>(R.layout.activity_sign_uo_twentyone) {
  private val viewModel: SignUoTwentyoneVM by viewModels<SignUoTwentyoneVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoTwentyoneVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnNext.setOnClickListener {
      val destIntent = SignUoTwentytwoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.linearRowfloatingicon.setOnClickListener {
      val destIntent = OrdersSixActivity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_TWENTYONE_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoTwentyoneActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
