package com.buildcart.app.modules.frame307.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import com.buildcart.app.R
import com.buildcart.app.appcomponents.base.BaseActivity
import com.buildcart.app.databinding.ActivityFrame307Binding
import com.buildcart.app.modules.frame307.`data`.viewmodel.Frame307VM
import kotlin.String
import kotlin.Unit

class Frame307Activity : BaseActivity<ActivityFrame307Binding>(R.layout.activity_frame_307) {
  private val viewModel: Frame307VM by viewModels<Frame307VM>()

  override fun onInitialized(): Unit {
    viewModel.navArguments = intent.extras?.getBundle("bundle")
    binding.frame307VM = viewModel
  }

  override fun setUpClicks(): Unit {
  }

  companion object {
    const val TAG: String = "FRAME307ACTIVITY"


    fun getIntent(context: Context, bundle: Bundle?): Intent {
      val destIntent = Intent(context, Frame307Activity::class.java)
      destIntent.putExtra("bundle", bundle)
      return destIntent
    }
  }
}
