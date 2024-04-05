package com.buildcart.app.modules.signuofour.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoFourBinding
import com.buildcart.app.modules.frame308.ui.Frame308Activity
import com.buildcart.app.modules.signuo.ui.SignUoActivity
import com.buildcart.app.modules.signuofour.`data`.viewmodel.SignUoFourVM
import kotlin.String
import kotlin.Unit

class SignUoFourActivity : BaseActivity<ActivitySignUoFourBinding>(R.layout.activity_sign_uo_four) {
  private val viewModel: SignUoFourVM by viewModels<SignUoFourVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoFourVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnPlaceOrder.setOnClickListener {
      val destIntent = Frame308Activity.getIntent(this, null)
      startActivity(destIntent)
    }
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
    binding.linearRowpaypalone.setOnClickListener {
      val destIntent = SignUoActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_FOUR_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, SignUoFourActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
