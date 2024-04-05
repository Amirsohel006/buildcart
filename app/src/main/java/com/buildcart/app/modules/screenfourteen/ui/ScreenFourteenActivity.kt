package com.buildcart.app.modules.screenfourteen.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityScreenFourteenBinding
import com.buildcart.app.modules.screeneleven.ui.ScreenElevenActivity
import com.buildcart.app.modules.screenfourteen.`data`.viewmodel.ScreenFourteenVM
import kotlin.String
import kotlin.Unit

class ScreenFourteenActivity :
    BaseActivity<ActivityScreenFourteenBinding>(R.layout.activity_screen_fourteen) {
  private val viewModel: ScreenFourteenVM by viewModels<ScreenFourteenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenFourteenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.frameSCREENFourteen.setOnClickListener {
      val destIntent = ScreenElevenActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SCREEN_FOURTEEN_ACTIVITY"

  }
}
