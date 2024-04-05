package com.buildcart.app.modules.screeneleven.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityScreenElevenBinding
import com.buildcart.app.modules.screeneleven.`data`.viewmodel.ScreenElevenVM
import kotlin.String
import kotlin.Unit

class ScreenElevenActivity :
    BaseActivity<ActivityScreenElevenBinding>(R.layout.activity_screen_eleven) {
  private val viewModel: ScreenElevenVM by viewModels<ScreenElevenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenElevenVM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "SCREEN_ELEVEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ScreenElevenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
