package com.buildcart.app.modules.frametwentyseven.ui

import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityFrameTwentysevenBinding
import com.buildcart.app.modules.frametwentyeight.ui.FrameTwentyeightActivity
import com.buildcart.app.modules.frametwentyseven.`data`.viewmodel.FrameTwentysevenVM
import kotlin.String
import kotlin.Unit

class FrameTwentysevenActivity :
    BaseActivity<ActivityFrameTwentysevenBinding>(R.layout.activity_frame_twentyseven) {
  private val viewModel: FrameTwentysevenVM by viewModels<FrameTwentysevenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frameTwentysevenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.btnCancelOrder.setOnClickListener {
      val destIntent = FrameTwentyeightActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "FRAME_TWENTYSEVEN_ACTIVITY"

  }
}
