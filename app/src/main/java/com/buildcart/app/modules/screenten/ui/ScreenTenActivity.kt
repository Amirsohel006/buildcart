package com.buildcart.app.modules.screenten.ui

import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityScreenTenBinding
import com.buildcart.app.modules.frame314.ui.Frame314Activity
import com.buildcart.app.modules.screenseven.ui.ScreenSevenActivity
import com.buildcart.app.modules.screenten.`data`.viewmodel.ScreenTenVM
import kotlin.String
import kotlin.Unit

class ScreenTenActivity : BaseActivity<ActivityScreenTenBinding>(R.layout.activity_screen_ten) {
  private val viewModel: ScreenTenVM by viewModels<ScreenTenVM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.screenTenVM = viewModel
    Handler(Looper.getMainLooper()).postDelayed( {
      val destIntent = Frame314Activity.getIntent(this, null)
      startActivity(destIntent)
      finish()
      }, 3000)
    }

    override fun setUpClicks(): Unit {
      binding.frameSCREENTen.setOnClickListener {
        val destIntent = ScreenSevenActivity.getIntent(this, null)
        startActivity(destIntent)
      }
    }

    companion object {
      const val TAG: String = "SCREEN_TEN_ACTIVITY"

    }
  }
