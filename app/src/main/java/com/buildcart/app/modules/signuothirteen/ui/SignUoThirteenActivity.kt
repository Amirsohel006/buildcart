package com.buildcart.app.modules.signuothirteen.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivitySignUoThirteenBinding
import com.buildcart.app.modules.signuothirteen.`data`.viewmodel.SignUoThirteenVM
import kotlin.String
import kotlin.Unit

class SignUoThirteenActivity :
    BaseActivity<ActivitySignUoThirteenBinding>(R.layout.activity_sign_uo_thirteen) {
  private val viewModel: SignUoThirteenVM by viewModels<SignUoThirteenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.signUoThirteenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.imageArrowleft.setOnClickListener {
      finish()
    }
  }

  companion object {
    const val TAG: String = "SIGN_UO_THIRTEEN_ACTIVITY"

  }
}
