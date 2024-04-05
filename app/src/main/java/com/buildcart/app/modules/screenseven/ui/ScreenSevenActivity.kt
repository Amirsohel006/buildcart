package com.buildcart.app.modules.screenseven.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityScreenSevenBinding
import com.buildcart.app.modules.screenseven.`data`.viewmodel.ScreenSevenVM
import com.buildcart.app.modules.signuoone.ui.SignUoOneActivity
import kotlin.String
import kotlin.Unit

class ScreenSevenActivity : BaseActivity<ActivityScreenSevenBinding>(R.layout.activity_screen_seven)
    {
  private val viewModel: ScreenSevenVM by viewModels<ScreenSevenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenSevenVM = viewModel
  }

  override fun setUpClicks(): Unit {
    binding.txtSkip.setOnClickListener {
      val destIntent = SignUoOneActivity.getIntent(this, null)
      startActivity(destIntent)
    }
  }

  companion object {
    const val TAG: String = "SCREEN_SEVEN_ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, ScreenSevenActivity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
