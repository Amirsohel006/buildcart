package com.buildcart.app.modules.signuotwenty.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoTwentyBinding
import com.buildcart.app.modules.signuotwenty.`data`.viewmodel.SignUoTwentyVM
import kotlin.String
import kotlin.Unit

class SignUoTwentyActivity :
    BaseActivity<ActivitySignUoTwentyBinding>(R.layout.activity_sign_uo_twenty) {
  private val viewModel: SignUoTwentyVM by viewModels<SignUoTwentyVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoTwentyVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_TWENTY_ACTIVITY"

  }
}
