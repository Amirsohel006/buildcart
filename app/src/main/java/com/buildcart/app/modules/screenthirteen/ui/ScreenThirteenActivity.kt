package com.buildcart.app.modules.screenthirteen.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityScreenThirteenBinding
import com.buildcart.app.modules.screenthirteen.`data`.viewmodel.ScreenThirteenVM
import kotlin.String
import kotlin.Unit

class ScreenThirteenActivity :
    BaseActivity<ActivityScreenThirteenBinding>(R.layout.activity_screen_thirteen) {
  private val viewModel: ScreenThirteenVM by viewModels<ScreenThirteenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenThirteenVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SCREEN_THIRTEEN_ACTIVITY"

  }
}
