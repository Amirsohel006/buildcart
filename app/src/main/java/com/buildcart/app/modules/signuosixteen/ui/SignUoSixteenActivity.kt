package com.buildcart.app.modules.signuosixteen.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoSixteenBinding
import com.buildcart.app.modules.signuosixteen.`data`.viewmodel.SignUoSixteenVM
import kotlin.String
import kotlin.Unit

class SignUoSixteenActivity :
    BaseActivity<ActivitySignUoSixteenBinding>(R.layout.activity_sign_uo_sixteen) {
  private val viewModel: SignUoSixteenVM by viewModels<SignUoSixteenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoSixteenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_SIXTEEN_ACTIVITY"

  }
}
