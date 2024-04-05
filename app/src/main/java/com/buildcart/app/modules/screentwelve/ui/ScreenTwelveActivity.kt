package com.buildcart.app.modules.screentwelve.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityScreenTwelveBinding
import com.buildcart.app.modules.screentwelve.`data`.viewmodel.ScreenTwelveVM
import kotlin.String
import kotlin.Unit

class ScreenTwelveActivity :
    BaseActivity<ActivityScreenTwelveBinding>(R.layout.activity_screen_twelve) {
  private val viewModel: ScreenTwelveVM by viewModels<ScreenTwelveVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenTwelveVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SCREEN_TWELVE_ACTIVITY"

  }
}
