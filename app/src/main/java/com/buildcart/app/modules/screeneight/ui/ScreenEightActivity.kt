package com.buildcart.app.modules.screeneight.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityScreenEightBinding
import com.buildcart.app.modules.screeneight.`data`.viewmodel.ScreenEightVM
import com.buildcart.app.modules.signuoone.ui.SignUoOneActivity
import kotlin.String
import kotlin.Unit

class ScreenEightActivity : BaseActivity<ActivityScreenEightBinding>(R.layout.activity_screen_eight)
    {
  private val viewModel: ScreenEightVM by viewModels<ScreenEightVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenEightVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtSkip.setOnClickListener {
      val destIntent = SignUoOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SCREEN_EIGHT_ACTIVITY"

  }
}
