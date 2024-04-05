package com.buildcart.app.modules.screennine.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityScreenNineBinding
import com.buildcart.app.modules.screennine.`data`.viewmodel.ScreenNineVM
import com.buildcart.app.modules.signuoone.ui.SignUoOneActivity
import kotlin.String
import kotlin.Unit

class ScreenNineActivity : BaseActivity<ActivityScreenNineBinding>(R.layout.activity_screen_nine) {
  private val viewModel: ScreenNineVM by viewModels<ScreenNineVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenNineVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtSkip.setOnClickListener {
      val destIntent = SignUoOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SCREEN_NINE_ACTIVITY"

  }
}
