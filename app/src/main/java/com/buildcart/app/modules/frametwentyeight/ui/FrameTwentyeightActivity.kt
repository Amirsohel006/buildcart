package com.buildcart.app.modules.frametwentyeight.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityFrameTwentyeightBinding
import com.buildcart.app.modules.frametwentyeight.`data`.viewmodel.FrameTwentyeightVM
import kotlin.String
import kotlin.Unit

class FrameTwentyeightActivity :
    BaseActivity<ActivityFrameTwentyeightBinding>(R.layout.activity_frame_twentyeight) {
  private val viewModel: FrameTwentyeightVM by viewModels<FrameTwentyeightVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frameTwentyeightVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "FRAME_TWENTYEIGHT_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, FrameTwentyeightActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
